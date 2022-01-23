package com.vietbv.tuyenntt.qlnhahang.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;
import com.vietbv.tuyenntt.qlnhahang.model.MonAnDto;
import com.vietbv.tuyenntt.qlnhahang.model.NhomMonAnDto;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;
import com.vietbv.tuyenntt.qlnhahang.service.NhomMonAnService;
import com.vietbv.tuyenntt.qlnhahang.service.StorageService;

@Controller
@RequestMapping("admin/monan")
public class MonAnController {

	@Autowired
	NhomMonAnService _nhomMonAnService;

	@Autowired
	MonAnService _monAnService;

	@Autowired
	StorageService _storageService;

	@ModelAttribute("nhomMonAns")
	public List<NhomMonAnDto> getNhomMonAns() {
		return _nhomMonAnService.findAll().stream().map(item -> {
			NhomMonAnDto dto = new NhomMonAnDto();
			BeanUtils.copyProperties(item, dto);// copy nhóm món từ item sang dto
			return dto;
		}).collect(Collectors.toList()); // chuyển toàn bộ danh sách của dto sang list
	}

	@GetMapping("add")
	public String add(Model model) {
		MonAnDto dto = new MonAnDto();
		dto.setIsEdit(false);
		model.addAttribute("monAn", dto);
		return "admin/monans/addOrEdit";
	}
	
	@RequestMapping("listall")
	public String list(ModelMap model) {
		// trả về danh sách các category
		List<NhomMonAn> list = _nhomMonAnService.findAll();
		
		model.addAttribute("nhomMons", list);
		return "admin/monans/list";
	}
	
	@GetMapping("list")
	public String menu(ModelMap model) {
		// trả về danh sách các category
		List<NhomMonAn> list = _nhomMonAnService.findAll();
		
		model.addAttribute("nhomMonAns", list);
		return "admin/monans/listByCategory";
	}
	
	@GetMapping("/{maNhomMon}")
	public ModelAndView monAn(ModelMap model, @PathVariable("maNhomMon") Long maNhomMon) {
		List<MonAn> list = _monAnService.findByMaNhomMonAn(maNhomMon);
		model.addAttribute("monAnByCategory", list);
		return new ModelAndView("forward:/admin/monan/list",model);
	}

	// thêm mới và chỉnh sửa thông tin
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("product") MonAnDto dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("admin/monans/addOrEdit");
		}

		MonAn entity = new MonAn();
		BeanUtils.copyProperties(dto, entity); // copy nội dung từ dto sang entity(hạn chế việc get set nhiều lần)

		// thêm thông tin category vào productCategory
		NhomMonAn category = new NhomMonAn();
		category.setMaNhomMon(dto.getMaNhomMon());
		entity.setNhomMonAn(category);

		// lưu nội dung của img đc upload tới server
		if (!dto.getImageFile().isEmpty()) {
			// cho phép sinh ra 1 dãy kí tự dùng để nhận dạng
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage(_storageService.getStoredFileName(dto.getImageFile(), uuString));
			// xác định tên file cần lưu trữ
			_storageService.store(dto.getImageFile(), entity.getImage());
		}

		_monAnService.save(entity);// lưu thông tin của entity vào DB

		model.addAttribute("message", "Món ăn đã lưu!");// hiển thị thông báo
		return new ModelAndView("forward:/admin/monan/searchpaginated", model);
	}

	@RequestMapping("searchpaginated")
	public ModelAndView search(ModelMap model, @RequestParam(name = "tenMonAn", required = false) String tenMonAn,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(5);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("tenMonAn"));// sắp xếp theo field name
		Page<MonAn> resultPage = null;

		if (StringUtils.hasText(tenMonAn)) { // nếu name có giá trị
			resultPage = _monAnService.findByTenMonAnContaining(tenMonAn, pageable); // name: tên cần tìm kiếm.
																						// pageable: các thông số phân
																						// trang và sắp xếp
			model.addAttribute("tenMonAn", tenMonAn);
		} else {
			resultPage = _monAnService.findAll(pageable);
		}

		int totalPage = resultPage.getTotalPages();// số trang được hiển thị trên view(bn trang)
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 5) {
				if (end == totalPage)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			/*
			 * .collector(Collectors.toList()): chuyển các giá trị sinh ra (start, end)
			 * thành danh sách
			 * 
			 */
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			// danh sách các giá trị Integer để tính ra số trang cần hiển thị trên view
			model.addAttribute("pageNumbers", pageNumbers);
		}

		// trả về kết quả phương thức tìm kiếm
		model.addAttribute("productPage", resultPage);

		return new ModelAndView("forward:/admin/monan/listall", model); 
	}

	// chỉnh sửa form addOrEdit
	@GetMapping("edit/{maMonAn}")
	public ModelAndView edit(ModelMap model, @PathVariable("maMonAn") Long maMonAn) {

		Optional<MonAn> opt = _monAnService.findById(maMonAn);// tìm thử có id đó ko
		MonAnDto dto = new MonAnDto();

		if (opt.isPresent()) {// có dữ liệu trả về
			MonAn entity = opt.get();// lấy dữ liệu đó trong DB
			BeanUtils.copyProperties(entity, dto);// copy từ entity sang dto
			// lấy categoryId để thiết lập cho trường categoryProductDto
			dto.setMaNhomMon(entity.getNhomMonAn().getMaNhomMon());
			dto.setIsEdit(true);// bên edit thì true

			model.addAttribute("monAn", dto);

			return new ModelAndView("admin/monans/addOrEdit", model);
		}

		model.addAttribute("message", "Món ăn không tồn tại");

		return new ModelAndView("forward:/admin/monan/searchpaginated", model); // nếu ko có thì chuyển tới list
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){ //đọc nội dung filename đc gửi tới
		Resource file = _storageService.loadAsResource(filename);
		
		//trả về nội dung của filename đó
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
	@GetMapping("delete/{maMonAn}")
	public ModelAndView delete(ModelMap model, @PathVariable("maMonAn") Long maMonAn) {
		
		_monAnService.deleteById(maMonAn);
		
		model.addAttribute("message", "Món ăn đã bị xóa!");
		
		return new ModelAndView("forward:/admin/monan/searchpaginated",model);
	}
}

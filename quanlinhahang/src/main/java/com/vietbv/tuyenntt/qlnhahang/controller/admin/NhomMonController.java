package com.vietbv.tuyenntt.qlnhahang.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;
import com.vietbv.tuyenntt.qlnhahang.model.NhomMonAnDto;
import com.vietbv.tuyenntt.qlnhahang.service.NhomMonAnService;

@Controller
@RequestMapping("admin/nhommonan")
public class NhomMonController {
	
	@Autowired
	NhomMonAnService _nhomMonAnService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("nhomMonAn", new NhomMonAnDto());
		return "admin/nhommons/addOrEdit";
	}
	
	//thêm mới và chỉnh sửa thông tin
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("nhomMonAn") NhomMonAnDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/nhommons/addOrEdit");
		}
		
		NhomMonAn entity = new NhomMonAn();
		BeanUtils.copyProperties(dto, entity);	//copy nội dung từ dto sang entity(hạn chế việc get set nhiều lần)
		
		_nhomMonAnService.save(entity);//lưu thông tin của entity vào DB
		
		model.addAttribute("message", "Nhóm món đã thêm thành công!");//hiển thị thông báo
		return new ModelAndView("forward:/admin/nhommonan/searchpaginated",model);
	}

	@RequestMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name = "tenNhomMon", required = false) String tenNhomMon,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {	
		
		
		/*
		 * currentPage: trang hiện tại
		 * pageSize: kích thước của trang
		 * */
		int currentPage = page.orElse(1);//người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(5);//giá trị ngầm định 5 phần tử trên 1 trang
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("tenNhomMon"));//sắp xếp theo field name
		Page<NhomMonAn> resultPage = null;
		
		if(StringUtils.hasText(tenNhomMon)) {	//nếu name có giá trị
			resultPage = _nhomMonAnService.findByNameContaining(tenNhomMon, pageable); //name: tên cần tìm kiếm. pageable: các thông số phân trang và sắp xếp
			model.addAttribute("tenNhomMon", tenNhomMon);
		}else {
			resultPage = _nhomMonAnService.findAll(pageable);
		}
		
		int totalPage = resultPage.getTotalPages();//số trang được hiển thị trên view(bn trang)
		if(totalPage>0) {
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage + 2, totalPage);
			
			if(totalPage > 5) {
				if(end == totalPage) start = end - 5;
				else if(start == 1) end = start + 5;
			}
			/*
			 * .collector(Collectors.toList()): chuyển các giá trị sinh ra (start, end) thành danh sách
			 * 
			 * */
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			
			//danh sách các giá trị Integer để tính ra số trang cần hiển thị trên view
			model.addAttribute("pageNumbers", pageNumbers);	
		}
		
		//trả về kết quả phương thức tìm kiếm
		model.addAttribute("categoryPage",resultPage); 
		
		return "admin/nhommons/list";
	}
	
	@GetMapping("edit/{maMonAn}")
	public ModelAndView edit(ModelMap model, @PathVariable("maMonAn") Long maMonAn) {
		
		Optional<NhomMonAn> opt = _nhomMonAnService.findById(maMonAn);//tìm thử có id đó ko
		NhomMonAnDto dto = new NhomMonAnDto();
		
		if(opt.isPresent()) {//có dữ liệu trả về
			NhomMonAn entity = opt.get();//lấy dữ liệu đó trong DB
			BeanUtils.copyProperties(entity, dto);//copy từ entity sang dto
			
			dto.setIsEdit(true);//bên edit thì true
			
			model.addAttribute("nhomMonAn", dto);
			
			return new ModelAndView("admin/nhommons/addOrEdit", model);
		}
		
		model.addAttribute("message", "Nhóm món không tồn tại");
		
		return new ModelAndView("forward:/admin/nhommonan/searchpaginated", model); //nếu ko có thì chuyển tới list
	}
	
	@GetMapping("delete/{maNhomMon}")
	public ModelAndView delete(ModelMap model, @PathVariable("maNhomMon") Long maNhomMon) {
		
		_nhomMonAnService.deleteById(maNhomMon);
		
		model.addAttribute("message", "Nhóm món ăn đã bị xóa!");
		
		return new ModelAndView("forward:/admin/nhommonan/searchpaginated",model);
	}
}

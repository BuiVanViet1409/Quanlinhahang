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

import com.vietbv.tuyenntt.qlnhahang.domain.LienHe;
import com.vietbv.tuyenntt.qlnhahang.model.LienHeDto;
import com.vietbv.tuyenntt.qlnhahang.service.LienHeService;

@Controller
@RequestMapping("admin/lienhe")
public class LienHeController {
	@Autowired
	LienHeService _lienHeService;

	// thêm mới và chỉnh sửa thông tin
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("lienHe") LienHeDto dto,
			BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("error");
			return new ModelAndView("admin/lienhe/addOrEdit");
		}

		LienHe entity = new LienHe();
		BeanUtils.copyProperties(dto, entity); // copy nội dung từ dto sang entity(hạn chế việc get set nhiều lần)

		_lienHeService.save(entity);// lưu thông tin của entity vào DB

		model.addAttribute("message", "Đã chỉnh sửa thông tin liên hệ!");// hiển thị thông báo
		return new ModelAndView("forward:/admin/lienhe/searchpaginated", model);
	}

	@RequestMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "hoTen", required = false) String hoTen,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(5);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("hoTen"));// sắp xếp theo field name
		Page<LienHe> resultPage = null;

		if (StringUtils.hasText(hoTen)) { // nếu name có giá trị
			resultPage = _lienHeService.findByHoTenContaining(hoTen, pageable); // name: tên cần tìm kiếm.
																				// pageable: các thông số phân
																				// trang và sắp xếp
			model.addAttribute("hoTen", hoTen);
		} else {
			resultPage = _lienHeService.findAll(pageable);
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
		model.addAttribute("lienhePage", resultPage);

		return "admin/lienhe/contact";
	}

	@GetMapping("edit/{maLienHe}")
	public ModelAndView edit(ModelMap model, @PathVariable("maLienHe") Long maLienHe) {

		Optional<LienHe> opt = _lienHeService.findById(maLienHe);// tìm thử có id đó ko
		LienHeDto dto = new LienHeDto();

		if (opt.isPresent()) {// có dữ liệu trả về
			LienHe entity = opt.get();// lấy dữ liệu đó trong DB
			BeanUtils.copyProperties(entity, dto);// copy từ entity sang dto

			dto.setIsEdit(true);// bên edit thì true

			model.addAttribute("lienHe", dto);

			return new ModelAndView("admin/lienhe/addOrEdit", model);
		}

		model.addAttribute("message", "Không có danh sách khách hàng liên hệ");

		return new ModelAndView("forward:/admin/lienhe/searchpaginated", model); // nếu ko có thì chuyển tới list
	}

	@GetMapping("delete/{maLienHe}")
	public ModelAndView delete(ModelMap model, @PathVariable("maLienHe") Long maLienHe) {

		_lienHeService.deleteById(maLienHe);

		model.addAttribute("message", "Đã xóa!");

		return new ModelAndView("forward:/admin/lienhe/searchpaginated", model);
	}
}

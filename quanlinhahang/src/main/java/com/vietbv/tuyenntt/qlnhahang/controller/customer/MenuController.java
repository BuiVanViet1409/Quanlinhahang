package com.vietbv.tuyenntt.qlnhahang.controller.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;
import com.vietbv.tuyenntt.qlnhahang.service.NhomMonAnService;

@Controller
@RequestMapping("collections")
public class MenuController {
	
	@Autowired
	NhomMonAnService _nhomMonAnService;
	
	@Autowired
	MonAnService _monAnService;
	
	@RequestMapping("all")
	public ModelAndView search(ModelMap model, @RequestParam(name = "tenMonAn", required = false) String tenMonAn,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(10);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("tenMonAn"));// sắp xếp theo field name
		Page<MonAn> resultPage = null;
		if (StringUtils.hasText(tenMonAn)) {
			resultPage = _monAnService.findByTenMonAnContaining(tenMonAn, pageable);
			model.addAttribute("tenMonAn", tenMonAn);
		}else {
			resultPage = _monAnService.findAll(pageable);
//			model.addAttribute("all", resultPage);
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

		return new ModelAndView("forward:/collections/listall",model);
	}
	
	@GetMapping("listall")
	public String list(ModelMap model) {
		// trả về danh sách các category
		List<NhomMonAn> list = _nhomMonAnService.findAll();
		
		model.addAttribute("nhomMons", list);
		return "customer/thucdon/tatcamonan";
	}
	
	
	@GetMapping("list")
	public String menu(ModelMap model) {
		// trả về danh sách các category
		List<NhomMonAn> list = _nhomMonAnService.findAll();
		
		model.addAttribute("nhomMonAns", list);
		return "customer/thucdon/menu";
	}
	
	@GetMapping("/{maNhomMon}")
	public ModelAndView monAn(ModelMap model, @PathVariable("maNhomMon") Long maNhomMon) {
		List<MonAn> list = _monAnService.findByMaNhomMonAn(maNhomMon);
		model.addAttribute("monAnByCategory", list);
		return new ModelAndView("forward:/collections/list",model);
	}
	
	@GetMapping("ascprice")
	public ModelAndView ascPrice(ModelMap model, @RequestParam(name = "tenMonAn", required = false) String tenMonAn,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(10);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("gia"));// sắp xếp theo field name
		Page<MonAn> resultPage = null;

		
			resultPage = _monAnService.findAll(pageable);
			model.addAttribute("all", resultPage);

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

		return new ModelAndView("forward:/collections/listall",model);
	}
	
	@GetMapping("descprice")
	public ModelAndView descPrice(ModelMap model, @RequestParam(name = "tenMonAn", required = false) String tenMonAn,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(10);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(Direction.DESC ,"gia"));// sắp xếp theo field name
		Page<MonAn> resultPage = null;

		
			resultPage = _monAnService.findAll(pageable);
			model.addAttribute("all", resultPage);

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

		return new ModelAndView("forward:/collections/listall",model);
	}
	
	@GetMapping("descname")
	public ModelAndView descName(ModelMap model, @RequestParam(name = "tenMonAn", required = false) String tenMonAn,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		/*
		 * currentPage: trang hiện tại pageSize: kích thước của trang
		 */
		int currentPage = page.orElse(1);// người dùng ko nhập giá trị, giá trị ngầm định là 1
		int pageSize = size.orElse(10);// giá trị ngầm định 5 phần tử trên 1 trang

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(Direction.DESC ,"tenMonAn"));// sắp xếp theo field name
		Page<MonAn> resultPage = null;

		
			resultPage = _monAnService.findAll(pageable);
			model.addAttribute("all", resultPage);

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

		return new ModelAndView("forward:/collections/listall",model);
	}
}

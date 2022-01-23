package com.vietbv.tuyenntt.qlnhahang.controller.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.model.MonAnDto;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;

@Controller
@RequestMapping("chitiet")
public class ChiTietSanPham {
	
	@Autowired
	MonAnService _monAnService;
	
	@GetMapping("{maMonAn}")
	public ModelAndView chitiet(ModelMap model, @PathVariable("maMonAn") Long maMonAn, MonAnDto dto) {
		Optional<MonAn> opt = _monAnService.findById(maMonAn);// tìm thử có id đó ko
		if(opt.isPresent()) {
			List<MonAn> list = new ArrayList<MonAn>();
			MonAn entity = opt.get();
			list.add(entity);
			model.addAttribute("monAn", list);
			return new ModelAndView("/customer/monan/chitietmonan", model);
		}
		model.addAttribute("message", "Món ăn không tồn tại");
		return new ModelAndView("forward:/collections/all", model);
	}
}

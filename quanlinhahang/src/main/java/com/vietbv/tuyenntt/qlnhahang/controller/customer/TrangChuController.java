package com.vietbv.tuyenntt.qlnhahang.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;
import com.vietbv.tuyenntt.qlnhahang.service.NhomMonAnService;

@Controller
@RequestMapping("")
public class TrangChuController {

	@Autowired
	NhomMonAnService _nhomMonAnService;
	
	@Autowired
	MonAnService _monAnService;

	@RequestMapping(value = { "", "trang-chu" })
	public String index(ModelMap model) {
		// trả về danh sách các category
		List<NhomMonAn> list = _nhomMonAnService.findAll();
		
		model.addAttribute("nhomMonAns", list);
		return "customer/home/index";
	}
	
	@GetMapping("/{maNhomMon}")
	public ModelAndView monAn(ModelMap model, @PathVariable("maNhomMon") Long maNhomMon) {
		List<MonAn> list = _monAnService.findByMaNhomMonAn(maNhomMon);
		model.addAttribute("monAnByCategory", list);
		return new ModelAndView("forward:/trang-chu",model);
	}
	

	@GetMapping("thongtinnhahang")
	public String infor() {
		return "customer/thongtinnhahang/infor";
	}
	
	@GetMapping("sukien")
	public String events() {
		return "customer/sukien/events";
	}
}

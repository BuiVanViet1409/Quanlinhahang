package com.vietbv.tuyenntt.qlnhahang.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.model.DatShipDto;
import com.vietbv.tuyenntt.qlnhahang.service.BillDetailService;
import com.vietbv.tuyenntt.qlnhahang.service.BillService;

@Controller
@RequestMapping("ship")
public class QuanLiDatShip {
	
	@Autowired
	BillService _billService;
	
	@Autowired
	BillDetailService _billDetailService;
	
	@GetMapping("detail")
	public String detail(Model model) {
		List<DatShipDto> list = _billService.getDatShipList();
		System.out.println(list.get(0).getAddress());
		model.addAttribute("list", list);
		return "admin/datship/ship";
	}
	
	@GetMapping("delete/{maHoaDon}")
	public ModelAndView delete(ModelMap model, @PathVariable("maHoaDon") Long maHoaDon) {

		_billService.deleteById(maHoaDon);

		model.addAttribute("message", "Đã xóa!");

		return new ModelAndView("forward:/ship/detail", model);
	}
}

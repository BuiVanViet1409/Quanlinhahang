package com.vietbv.tuyenntt.qlnhahang.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.Quantri;
import com.vietbv.tuyenntt.qlnhahang.model.QuantriLoginDto;
import com.vietbv.tuyenntt.qlnhahang.service.QuantriService;

@Controller
public class QuanTriLoginController {
	
	@Autowired
	private QuantriService _quanTriService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("alogin")
	private String login(Model model) {
		model.addAttribute("quanTri", new QuantriLoginDto());
		return "admin/quantris/login";
	}
	
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("quanTri") QuantriLoginDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/admin/quantris/login",model);
		}
		
		Quantri quantri = _quanTriService.login(dto.getUsername(), dto.getPassword());
		
		//login thất bại
		if(quantri == null) {
			model.addAttribute("message", "tên hoặc password không hợp lệ!");
			return new ModelAndView("/admin/quantris/login",model);
		}
		//thành công
		session.setAttribute("username", quantri.getUsername());
		return new ModelAndView("forward:/trang-chu");
	}
	
	@GetMapping("alogout")
	public String logout(@ModelAttribute("quanTri") QuantriLoginDto dto) {
		session.removeAttribute("username");
		return "admin/quantris/login";
	}
}
package com.vietbv.tuyenntt.qlnhahang.controller.customer;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.DatBan;
import com.vietbv.tuyenntt.qlnhahang.model.DatBanDto;
import com.vietbv.tuyenntt.qlnhahang.service.DatBanService;

@Controller
@RequestMapping("book")
public class DatBanController {
	
	@Autowired
	DatBanService _datBanService;
	
	@RequestMapping("")
	public String add(Model model) {
		model.addAttribute("datBan", new DatBanDto());
		return "customer/datban/book";
	}
	
	@PostMapping("/datban")
	public ModelAndView datban(ModelMap model,
			@Valid @ModelAttribute("datBan") DatBanDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("customer/datban/book");
		}
		
		DatBan entity = new DatBan();
		BeanUtils.copyProperties(dto, entity);
		
		_datBanService.save(entity);
		
		model.addAttribute("message", "Cảm ơn bạn đã đặt bàn ở nhà hàng chúng tôi, chúng tôi sẽ liên hệ bạn sớm nhất");
		return new ModelAndView("forward:/book", model);
	}
}

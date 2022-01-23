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

import com.vietbv.tuyenntt.qlnhahang.domain.LienHe;
import com.vietbv.tuyenntt.qlnhahang.model.LienHeDto;
import com.vietbv.tuyenntt.qlnhahang.service.LienHeService;

@Controller
@RequestMapping("customer/lienhe")
public class CustomerLienHeController {

	@Autowired
	LienHeService _lienHeService;

	@RequestMapping("")
	public String add(Model model) {
		model.addAttribute("lienHe", new LienHeDto());
		return "customer/lienhe/contact";
	}

	@PostMapping("gui")
	public ModelAndView datban(ModelMap model, @Valid @ModelAttribute("lienHe") LienHeDto dto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("customer/lienhe/contact");
		}

		LienHe entity = new LienHe();
		BeanUtils.copyProperties(dto, entity);

		_lienHeService.save(entity);

		model.addAttribute("message", "Cảm ơn bạn đã liên hệ với nhà hàng chúng tôi, chúng tôi sẽ liên hệ bạn sớm nhất");
		return new ModelAndView("forward:/customer/lienhe", model);
	}

}

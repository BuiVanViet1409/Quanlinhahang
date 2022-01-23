package com.vietbv.tuyenntt.qlnhahang.controller.customer;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vietbv.tuyenntt.qlnhahang.domain.ChiTietHoaDon;
import com.vietbv.tuyenntt.qlnhahang.domain.HoaDon;
import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.model.CartItem;
import com.vietbv.tuyenntt.qlnhahang.model.HoaDonDto;
import com.vietbv.tuyenntt.qlnhahang.service.BillDetailService;
import com.vietbv.tuyenntt.qlnhahang.service.BillService;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;
import com.vietbv.tuyenntt.qlnhahang.service.ShoppingCartService;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
	
	@Autowired 
	MonAnService _monAnService;
	
	@Autowired
	ShoppingCartService _shoppingCartService;
	
	@Autowired
	BillService _billService;
	
	@Autowired
	BillDetailService _billDetailService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("views")
	public String viewCarts(Model model) {
		model.addAttribute("cartItem", _shoppingCartService.getAllItems());
		model.addAttribute("total", _shoppingCartService.getAmount());
		return "customer/shopping/cart-item";
	}
	
	@GetMapping("add/{maMonAn}")
	public String addCart(@PathVariable("maMonAn") Long maMonAn) {
		MonAn monAn = _monAnService.findMonAnById(maMonAn);
		if(monAn != null) {
			CartItem item = new CartItem();
			item.setMaMonAn(monAn.getMaMonAn());
			item.setTenMonAn(monAn.getTenMonAn());
			item.setGia(monAn.getGia());
			item.setSoluong(1);
			item.setImage(monAn.getImage());
			_shoppingCartService.add(item);
		}
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("clear")
	public String clearCart() {
		_shoppingCartService.clear();
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("delete/{maMonAn}")
	public String removeCart(@PathVariable("maMonAn") Long maMonAn) {
		_shoppingCartService.remove(maMonAn);
		return "redirect:/shopping-cart/views";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("maMonAn") Long maMonAn, @RequestParam("soluong") int soluong) {
		_shoppingCartService.update(maMonAn, soluong);
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("checkout")
	public String viewCheckOut(Model model) {
		
		model.addAttribute("checkout", new HoaDonDto());
		return "customer/shopping/checkout";
	}
	
//	@GetMapping("checkout")
//	public String checkOut(Model model) {
//		HoaDonDto hoaDon = new HoaDonDto();
//		KhachHang loginInfo = (KhachHang)session.getAttribute("tenKhachHang");
//		if(loginInfo != null) {
//			hoaDon.setAddress(loginInfo.getAddress());
//			hoaDon.setTen(loginInfo.getTenKhachHang());
//			hoaDon.setEmail(loginInfo.getEmail());
//		}
//		model.addAttribute("bills", hoaDon);
//		return "redirect:/shopping-cart/viewcheckout";
//	}
	
	@PostMapping("checkout")
	public ModelAndView CheckOutBill(ModelMap model ,@ModelAttribute("checkout") HoaDon hoadon) {
		Collection<CartItem> cartItemList = _shoppingCartService.getAllItems();
		hoadon.setNgayLap(new Date());
		HoaDon entity = _billService.save(hoadon);
		if (entity != null) {
			for (CartItem item  : cartItemList) {
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setMaMonAn(item.getMaMonAn());
				cthd.setMaHoaDon(entity.getMaHoaDon());
				cthd.setSoLuong(item.getSoluong());
				cthd.setThanhtien(item.getSoluong() * item.getGia());
				_billDetailService.save(cthd);
			}
		}
		
		cartItemList.clear();
		model.addAttribute("message", "Cám ơn bạn đã đặt hàng ở nhà hàng chúng tôi, chúng tôi sẽ liên hệ bạn sớm nhất");
		return new ModelAndView("forward:/shopping-cart/views", model);
	}
}

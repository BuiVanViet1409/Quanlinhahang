package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.vietbv.tuyenntt.qlnhahang.model.CartItem;
import com.vietbv.tuyenntt.qlnhahang.service.ShoppingCartService;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService{
	Map<Long, CartItem> maps = new HashMap<Long, CartItem>();
	
	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getMaMonAn());
		if(cartItem == null) {
			maps.put(item.getMaMonAn(), item);
		}else {
			cartItem.setSoluong(cartItem.getSoluong() + 1);
		}
	}
	
	@Override
	public void remove(Long id) {
		maps.remove(id);
	}
	
	@Override
	public CartItem update(Long maMonAn, int soluong) {
		CartItem cartItem = maps.get(maMonAn);
		cartItem.setSoluong(soluong);
		return cartItem;
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public Collection<CartItem> getAllItems(){
		return maps.values();
	}
	
	//đếm số lượng
	@Override
	public int getCount() {
		return maps.values().size();
	}
	
	//tổng tiền
	@Override
	public double getAmount() {
		return maps.values().stream()
				.mapToDouble(item -> item.getSoluong() * item.getGia())
				.sum();
	}
}

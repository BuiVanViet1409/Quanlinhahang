package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.Collection;

import com.vietbv.tuyenntt.qlnhahang.model.CartItem;

public interface ShoppingCartService {

	double getAmount();

	int getCount();

	Collection<CartItem> getAllItems();

	void clear();

	CartItem update(Long maMonAn, int soluong);

	void remove(Long id);

	void add(CartItem item);
	
}

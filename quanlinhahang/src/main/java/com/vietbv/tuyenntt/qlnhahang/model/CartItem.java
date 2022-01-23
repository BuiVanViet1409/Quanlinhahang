package com.vietbv.tuyenntt.qlnhahang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	private Long maMonAn;
	private String tenMonAn;
	private double gia;
	private int soluong;
	private String image;
}

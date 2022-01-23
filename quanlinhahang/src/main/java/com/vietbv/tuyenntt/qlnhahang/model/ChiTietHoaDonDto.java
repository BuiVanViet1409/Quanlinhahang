package com.vietbv.tuyenntt.qlnhahang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDonDto {
	private Long maCTHD;
	private Long maHoaDon;
	private Long maMonAn;
	private int soLuong;
	private double donGia;
}

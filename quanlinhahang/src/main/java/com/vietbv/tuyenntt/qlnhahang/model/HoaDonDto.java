package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonDto {
	private Long maHoaDon;
	@NotEmpty
	private String email;
	private double tongTien;
	private int soluong;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String ten;
	@NotEmpty
	private String address;
	private String note;
}

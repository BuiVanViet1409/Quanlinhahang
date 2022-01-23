package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatBanDto {
	private Long maDatBan;
	@NotEmpty
	private String hoTen;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String phone;
	@Min(value = 1)
	private int soluong;
	@NotEmpty
	private String ngayden;
	private String content;
	private Boolean isEdit = false;
}

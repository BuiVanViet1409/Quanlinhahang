package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LienHeDto {
	private Long maLienHe;
	@NotEmpty
	private String hoTen;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String noidung;
	
	private Boolean isEdit = false;
}

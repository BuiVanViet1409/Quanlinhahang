package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//lưu các thông tin của ng quản trị để đăng nhập hệ thống

public class QuantriLoginDto{
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
}

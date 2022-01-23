package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
//lưu các thông tin của ng quản trị để đăng nhập hệ thống
@Entity
@Table(name = "LienHes")
public class LienHe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maLienHe;
	
	@Column(length = 60, nullable = false)
	private String hoTen;
	@Column(length = 60, nullable = false)
	@Email
	private String email;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String noidung;
}

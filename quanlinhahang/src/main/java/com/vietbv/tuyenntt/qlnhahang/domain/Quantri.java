package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//lưu các thông tin của ng quản trị để đăng nhập hệ thống
@Entity
@Table(name = "Quantris")
public class Quantri implements Serializable{
	@Id
	@Column(length = 30)
	private String username;
	@Column(length = 60, nullable = false)
	private String password;
}

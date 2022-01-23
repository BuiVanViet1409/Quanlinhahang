package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DatBans")
public class DatBan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maDatBan;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String hoTen;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	@Column(length = 20)
	private String phone;
	@Column(nullable = false)
	private int soluong;
	@Column(nullable = false)
	private String ngayden;
	@Column(length = 200)
	private String content;
}

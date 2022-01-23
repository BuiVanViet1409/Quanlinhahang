package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietHoaDons")
public class ChiTietHoaDon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maCTHD;
	@Column(nullable = false)
	private int soLuong;
	@Column(nullable = false)
	private double thanhtien;
	
	@Column(nullable = false)
	@JoinColumn(name = "maMonAn")
	private Long maMonAn;
	@Column(nullable = false)
	@JoinColumn(name = "maHoaDon")
	private Long maHoaDon;
	
//	@ManyToOne
//	@JoinColumn(name = "maMonAn")
//	private MonAn monAn;
//	
//	@ManyToOne
//	@JoinColumn(name = "maHoaDon")
//	private HoaDon hoaDon;
}

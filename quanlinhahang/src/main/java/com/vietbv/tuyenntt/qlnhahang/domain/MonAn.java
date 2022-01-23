package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MonAns")
public class MonAn implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maMonAn;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String tenMonAn;
	
	@Column(nullable = false)
	private double gia;
	@Column(length = 200)
	private String image;
	@Column(columnDefinition = "nvarchar(500) not null")
	private String mota;
	
	@ManyToOne
	@JoinColumn(name = "maNhomMon")
	private NhomMonAn nhomMonAn;
	
	//productId lấy tập hợp các ordetDetails
	@OneToMany(mappedBy = "maMonAn", cascade = CascadeType.ALL)
	private Set<ChiTietHoaDon> chiTietHoaDons;
}

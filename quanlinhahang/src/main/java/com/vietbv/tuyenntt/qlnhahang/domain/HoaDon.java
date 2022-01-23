package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDons")
public class HoaDon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maHoaDon;
	@Temporal(TemporalType.DATE)
	private Date ngayLap;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String address;
	@Column(length = 20)
	private String phone;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String ten;
	@Column(length = 200,nullable = false)
	private String note;
	@OneToMany(mappedBy = "maHoaDon", cascade = CascadeType.ALL)
	private Set<ChiTietHoaDon> chiTietHoaDons;
	
	
	
	
}

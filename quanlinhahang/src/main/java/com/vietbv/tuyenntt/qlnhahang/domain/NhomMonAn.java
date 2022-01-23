package com.vietbv.tuyenntt.qlnhahang.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NhomMonAns")
public class NhomMonAn implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maNhomMon;
	
	@Column(name="tenNhomMon", length = 100,
			columnDefinition = "nvarchar(100) not null")
	private String tenNhomMon;
	
	@OneToMany(mappedBy = "nhomMonAn", cascade = CascadeType.ALL)
	private Set<MonAn> MonAns;
}

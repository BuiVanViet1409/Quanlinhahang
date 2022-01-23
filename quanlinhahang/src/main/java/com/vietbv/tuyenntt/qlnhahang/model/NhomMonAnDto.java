package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhomMonAnDto {
	private Long maNhomMon;
	@NotEmpty
	@Length(min = 2)
	private String tenNhomMon;
	//nhận biết trạng thái edit hay là add new
	private Boolean isEdit = false;
}

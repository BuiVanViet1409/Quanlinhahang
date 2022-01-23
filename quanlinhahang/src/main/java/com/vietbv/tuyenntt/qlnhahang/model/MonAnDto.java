package com.vietbv.tuyenntt.qlnhahang.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonAnDto {
	private Long maMonAn;
	@NotEmpty
	private String tenMonAn;
	
	//giá sản phẩm
	private double gia;
	private String image;//lưu tên
	private MultipartFile imageFile;
	
	private String mota;
	private Long maNhomMon;
	
	private Boolean isEdit;
}

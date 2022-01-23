package com.vietbv.tuyenntt.qlnhahang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

//chưa thông số cấu hình dịch vụ dùng để thao tác và lưu trữ file
@ConfigurationProperties("storage")
@Data
public class StorageProperties {
	//xác định vị trí lưu các file đc upload
	private String location;
}

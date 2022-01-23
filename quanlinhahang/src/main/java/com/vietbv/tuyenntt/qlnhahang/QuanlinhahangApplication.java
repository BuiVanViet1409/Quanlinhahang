package com.vietbv.tuyenntt.qlnhahang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.vietbv.tuyenntt.qlnhahang.config.StorageProperties;
import com.vietbv.tuyenntt.qlnhahang.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)	//xử dụng các thông số cấu hình trong StorageProperties
public class QuanlinhahangApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanlinhahangApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return(args->{
			storageService.init();
		});
	}
}

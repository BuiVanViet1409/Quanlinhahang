package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vietbv.tuyenntt.qlnhahang.config.StorageProperties;
import com.vietbv.tuyenntt.qlnhahang.exception.StorageException;
import com.vietbv.tuyenntt.qlnhahang.exception.StorageFileNotFoundException;
import com.vietbv.tuyenntt.qlnhahang.service.StorageService;

@Service
public class FileSystemStorageServiceImpl implements StorageService {
	// xác định đường dẫn gốc dùng để lưu hình ảnh
	private final Path rootLocation;

	//tạo ra file lưu trữ dựa vào id đc truyền vào
	@Override
	public String getStoredFileName(MultipartFile file, String id) {
		// tính ra phần mở rộng: png, jpg
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());// trả về tên file
		return "p" + id + "." + ext;
	}

	//truyền các thông tin cấu hình cho phần lưu trữ
	public FileSystemStorageServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	// lưu thông tin file từ MultipartFile
	@Override
	public void store(MultipartFile file, String storedFileName){
		try {
			// nếu file đc upload rỗng
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file");
			}

			// chuẩn hóa normalize, chuyển thành đường dẫn tuyệt đối
			Path destinationFile = this.rootLocation.resolve(Paths.get(storedFileName)).normalize().toAbsolutePath();

			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current directory");
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StorageException("Failed to store file", e);
		}
	}

	// nạp nội dung file dưới dạng resource
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			// nếu tồn tại thì tiếp tục thực hiện so sánh
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}

			throw new StorageFileNotFoundException("Could not read file: " + filename);
		} catch (Exception e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename);
		}
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	// xóa file
	// IOException: ném sang ngoại lệ
	@Override
	public void delete(String storedFilename) throws IOException {
		Path destinationFile = rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();

		Files.delete(destinationFile);
	}

	// khởi tạo các thư mục
	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
			System.out.println(rootLocation.toString());
		} catch (Exception e) {
			throw new StorageException("Could not initiaize storage", e);
		}
	}
}

package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vietbv.tuyenntt.qlnhahang.domain.Quantri;
import com.vietbv.tuyenntt.qlnhahang.repository.QuantriRepository;
import com.vietbv.tuyenntt.qlnhahang.service.QuantriService;

@Service
public class QuantriServiceImpl implements QuantriService{
	
	@Autowired
	private BCryptPasswordEncoder _bCryptPasswordEncoder;
	
	@Autowired
	private QuantriRepository _quanTriRepository;
	
	@Override
	public Quantri login(String username, String password) {
		Optional<Quantri> optExist = findById(username);
		
		//login thành công
		//matches: so sánh password vs giá trị password đã đc tạo ra mã băm
		if(optExist.isPresent() && _bCryptPasswordEncoder.matches(password, optExist.get().getPassword())) {
			optExist.get().setPassword("");
			return optExist.get();
		}
		return null; //kết quả login ko thành công
	}

	@Override
	public <S extends Quantri> S save(S entity) {
		//tìm account có trong db
		Optional<Quantri> optExist = findById(entity.getUsername());
		//nếu tồn tại
		if(optExist.isPresent()) {
			//nếu người dùng ko nhập password khi edit
			if(StringUtils.isEmpty(entity.getPassword())) {
				//lấy lại pass cũ
				entity.setPassword(optExist.get().getPassword());
			}else {
				entity.setPassword(_bCryptPasswordEncoder.encode(entity.getPassword()));
			}
		}else {
			//nếu ko tồn tại thì tạo mới và mã hóa acc
			entity.setPassword(_bCryptPasswordEncoder.encode(entity.getPassword()));
		}
		
		return _quanTriRepository.save(entity);
	}

	@Override
	public List<Quantri> findAll() {
		return _quanTriRepository.findAll();
	}

	@Override
	public Optional<Quantri> findById(String id) {
		return _quanTriRepository.findById(id);
	}

	@Override
	public void deleteById(String id) {
		_quanTriRepository.deleteById(id);
	}
	
	
}

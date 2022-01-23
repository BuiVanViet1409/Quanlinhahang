package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;
import com.vietbv.tuyenntt.qlnhahang.repository.NhomMonAnRepository;
import com.vietbv.tuyenntt.qlnhahang.service.NhomMonAnService;

@Service
public class NhomMonAnServiceImpl implements NhomMonAnService{
	
	@Autowired
	NhomMonAnRepository _nhomMonAnRepository;

	@Override
	public <S extends NhomMonAn> S save(S entity) {
		return _nhomMonAnRepository.save(entity);
	}

	@Override
	public Page<NhomMonAn> findByNameContaining(String tenNhomMon, Pageable pageable) {
		return _nhomMonAnRepository.findByTenNhomMonContaining(tenNhomMon, pageable);
	}

	@Override
	public List<NhomMonAn> findAll() {
		return _nhomMonAnRepository.findAll();
	}
	
	@Override
	public Page<NhomMonAn> findAll(Pageable pageable) {
		return _nhomMonAnRepository.findAll(pageable);
	}

	@Override
	public Optional<NhomMonAn> findById(Long id) {
		return _nhomMonAnRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		_nhomMonAnRepository.deleteById(id);
	}
	
	
}

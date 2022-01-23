package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.LienHe;
import com.vietbv.tuyenntt.qlnhahang.repository.LienHeRepository;
import com.vietbv.tuyenntt.qlnhahang.service.LienHeService;

@Service
public class LienHeServiceImpl implements LienHeService{
	
	@Autowired
	LienHeRepository _lienHeRepository;

	@Override
	public <S extends LienHe> S save(S entity) {
		return _lienHeRepository.save(entity);
	}

	@Override
	public Page<LienHe> findByHoTenContaining(String hoten, Pageable pageable) {
		return _lienHeRepository.findByHoTenContaining(hoten, pageable);
	}

	@Override
	public Page<LienHe> findAll(Pageable pageable) {
		return _lienHeRepository.findAll(pageable);
	}

	@Override
	public List<LienHe> findAll() {
		return _lienHeRepository.findAll();
	}

	@Override
	public List<LienHe> findAll(Sort sort) {
		return _lienHeRepository.findAll(sort);
	}

	@Override
	public Optional<LienHe> findById(Long id) {
		return _lienHeRepository.findById(id);
	}


	@Override
	public void delete(LienHe entity) {
		_lienHeRepository.delete(entity);
	}

	@Override
	public LienHe getById(Long id) {
		return _lienHeRepository.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		_lienHeRepository.deleteById(id);
	}
}

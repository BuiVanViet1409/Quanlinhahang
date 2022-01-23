package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;
import com.vietbv.tuyenntt.qlnhahang.repository.MonAnRepository;
import com.vietbv.tuyenntt.qlnhahang.service.MonAnService;

@Service
public class MonAnServiceImpl implements MonAnService{
	@Autowired
	MonAnRepository _monAnRepository;

	@Override
	public <S extends MonAn> S save(S entity) {
		return _monAnRepository.save(entity);
	}

	@Override
	public Page<MonAn> findByTenMonAnContaining(String tenMonAn, Pageable pageable) {
		return _monAnRepository.findByTenMonAnContaining(tenMonAn, pageable);
	}
	
	@Override
	public List<MonAn> findByMaNhomMonAn(Long maNhomMon) {
		return _monAnRepository.findByMaNhomMonAn(maNhomMon);
	}

	@Override
	public List<MonAn> findAll() {
		return _monAnRepository.findAll();
	}

	@Override
	public Page<MonAn> findAll(Pageable pageable) {
		return _monAnRepository.findAll(pageable);
	}

	@Override
	public List<MonAn> findAll(Sort sort) {
		return _monAnRepository.findAll(sort);
	}

	@Override
	public Optional<MonAn> findById(Long id) {
		return _monAnRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		_monAnRepository.deleteById(id);
	}
	
	@Override
	public MonAn findMonAnById(Long maMonAn) {
		for(MonAn monAn : _monAnRepository.findAll()) {
			if(monAn.getMaMonAn() == maMonAn) {
				return monAn;
			}
		}
		return null;
	}
	
}

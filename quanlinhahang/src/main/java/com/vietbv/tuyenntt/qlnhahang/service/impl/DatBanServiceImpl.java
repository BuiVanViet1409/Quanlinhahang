package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.DatBan;
import com.vietbv.tuyenntt.qlnhahang.repository.DatBanRepository;
import com.vietbv.tuyenntt.qlnhahang.service.DatBanService;

@Service
public class DatBanServiceImpl implements DatBanService{
	
	@Autowired
	DatBanRepository _datBanRepository;

	@Override
	public <S extends DatBan> S save(S entity) {
		return _datBanRepository.save(entity);
	}

	@Override
	public List<DatBan> findAll() {
		return _datBanRepository.findAll();
	}

	@Override
	public Page<DatBan> findAll(Pageable pageable) {
		return _datBanRepository.findAll(pageable);
	}

	@Override
	public List<DatBan> findAll(Sort sort) {
		return _datBanRepository.findAll(sort);
	}

	@Override
	public List<DatBan> findAllById(Iterable<Long> ids) {
		return _datBanRepository.findAllById(ids);
	}

	@Override
	public Optional<DatBan> findById(Long id) {
		return _datBanRepository.findById(id);
	}

	@Override
	public Page<DatBan> findByHoTenContaining(String hoten, Pageable pageable) {
		return _datBanRepository.findByHoTenContaining(hoten, pageable);
	}

	@Override
	public <S extends DatBan> List<S> saveAll(Iterable<S> entities) {
		return _datBanRepository.saveAll(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return _datBanRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		_datBanRepository.deleteById(id);
	}

	@Override
	public void delete(DatBan entity) {
		_datBanRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		_datBanRepository.deleteAll();
	}

	@Override
	public DatBan getById(Long id) {
		return _datBanRepository.getById(id);
	}
	
	
}

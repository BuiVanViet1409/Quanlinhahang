package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.ChiTietHoaDon;
import com.vietbv.tuyenntt.qlnhahang.repository.BillDetailRepository;
import com.vietbv.tuyenntt.qlnhahang.service.BillDetailService;

@Service
public class BillDetailServiceImpl implements BillDetailService{
	
	@Autowired
	BillDetailRepository _billDetailRepository;

	@Override
	public <S extends ChiTietHoaDon> S save(S entity) {
		return _billDetailRepository.save(entity);
	}

	@Override
	public Page<ChiTietHoaDon> findAll(Pageable pageable) {
		return _billDetailRepository.findAll(pageable);
	}

	@Override
	public List<ChiTietHoaDon> findAll() {
		return _billDetailRepository.findAll();
	}

	@Override
	public List<ChiTietHoaDon> findAll(Sort sort) {
		return _billDetailRepository.findAll(sort);
	}

	@Override
	public long count() {
		return _billDetailRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		_billDetailRepository.deleteById(id);
	}

	@Override
	public void delete(ChiTietHoaDon entity) {
		_billDetailRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		_billDetailRepository.deleteAll();
	}

	@Override
	public ChiTietHoaDon getById(Long id) {
		return _billDetailRepository.getById(id);
	}
	
}

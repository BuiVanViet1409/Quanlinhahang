package com.vietbv.tuyenntt.qlnhahang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietbv.tuyenntt.qlnhahang.domain.HoaDon;
import com.vietbv.tuyenntt.qlnhahang.model.DatShipDto;
import com.vietbv.tuyenntt.qlnhahang.repository.BillRepository;
import com.vietbv.tuyenntt.qlnhahang.service.BillService;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository _billRepository;

	@Override
	public Long getIDLastHoaDon() {
		return _billRepository.getIDLastHoaDon();
	}

	@Override
	public <S extends HoaDon> S save(S entity) {
		return _billRepository.save(entity);
	}

	@Override
	public <S extends HoaDon> Optional<S> findOne(Example<S> example) {
		return _billRepository.findOne(example);
	}

	@Override
	public Page<HoaDon> findAll(Pageable pageable) {
		return _billRepository.findAll(pageable);
	}

	@Override
	public List<HoaDon> findAll() {
		return _billRepository.findAll();
	}

	@Override
	public List<HoaDon> findAll(Sort sort) {
		return _billRepository.findAll(sort);
	}

	@Override
	public List<HoaDon> findAllById(Iterable<Long> ids) {
		return _billRepository.findAllById(ids);
	}

	@Override
	public Optional<HoaDon> findById(Long id) {
		return _billRepository.findById(id);
	}

	@Override
	public <S extends HoaDon> List<S> saveAll(Iterable<S> entities) {
		return _billRepository.saveAll(entities);
	}

	@Override
	public long count() {
		return _billRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		_billRepository.deleteById(id);
	}

	@Override
	public void delete(HoaDon entity) {
		_billRepository.delete(entity);
	}
	
	@Override
	public HoaDon getById(Long id) {
		return _billRepository.getById(id);
	}

	@Override
	public <S extends HoaDon> List<S> findAll(Example<S> example) {
		return _billRepository.findAll(example);
	}

	@Override
	public <S extends HoaDon> List<S> findAll(Example<S> example, Sort sort) {
		return _billRepository.findAll(example, sort);
	}
	
	public List<DatShipDto> getDatShipList() {
		return _billRepository.getDatShipList();
	}
	
	

}

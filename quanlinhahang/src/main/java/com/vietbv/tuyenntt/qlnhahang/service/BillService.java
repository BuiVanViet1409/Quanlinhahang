package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietbv.tuyenntt.qlnhahang.domain.HoaDon;
import com.vietbv.tuyenntt.qlnhahang.model.DatShipDto;

public interface BillService {

	<S extends HoaDon> List<S> findAll(Example<S> example, Sort sort);

	<S extends HoaDon> List<S> findAll(Example<S> example);

	HoaDon getById(Long id);

	void delete(HoaDon entity);

	void deleteById(Long id);

	long count();

	<S extends HoaDon> List<S> saveAll(Iterable<S> entities);

	Optional<HoaDon> findById(Long id);

	List<HoaDon> findAllById(Iterable<Long> ids);

	List<HoaDon> findAll(Sort sort);

	List<HoaDon> findAll();

	Page<HoaDon> findAll(Pageable pageable);

	<S extends HoaDon> Optional<S> findOne(Example<S> example);

	<S extends HoaDon> S save(S entity);

	Long getIDLastHoaDon();
	
	List<DatShipDto> getDatShipList();

	

}

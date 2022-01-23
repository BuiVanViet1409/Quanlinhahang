package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietbv.tuyenntt.qlnhahang.domain.DatBan;

public interface DatBanService{

	DatBan getById(Long id);

	void deleteAll();

	void delete(DatBan entity);

	void deleteById(Long id);

	boolean existsById(Long id);

	<S extends DatBan> List<S> saveAll(Iterable<S> entities);

	Optional<DatBan> findById(Long id);

	List<DatBan> findAllById(Iterable<Long> ids);

	List<DatBan> findAll(Sort sort);

	List<DatBan> findAll();

	<S extends DatBan> S save(S entity);

	Page<DatBan> findByHoTenContaining(String hoten, Pageable pageable);

	Page<DatBan> findAll(Pageable pageable);

}

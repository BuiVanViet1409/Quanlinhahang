package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietbv.tuyenntt.qlnhahang.domain.LienHe;

public interface LienHeService {

	LienHe getById(Long id);

	void delete(LienHe entity);

	Optional<LienHe> findById(Long id);

	List<LienHe> findAll(Sort sort);

	List<LienHe> findAll();

	Page<LienHe> findAll(Pageable pageable);

	<S extends LienHe> S save(S entity);

	Page<LienHe> findByHoTenContaining(String hoten, Pageable pageable);

	void deleteById(Long id);

}

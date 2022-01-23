package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;

public interface NhomMonAnService {

	void deleteById(Long id);

	Optional<NhomMonAn> findById(Long id);

	List<NhomMonAn> findAll();

	<S extends NhomMonAn> S save(S entity);

	Page<NhomMonAn> findAll(Pageable pageable);

	Page<NhomMonAn> findByNameContaining(String tenNhomMon, Pageable pageable);

}

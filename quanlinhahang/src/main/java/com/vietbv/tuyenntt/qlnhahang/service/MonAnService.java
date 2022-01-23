package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;

public interface MonAnService {

	void deleteById(Long id);

	Optional<MonAn> findById(Long id);

	List<MonAn> findAll(Sort sort);

	Page<MonAn> findAll(Pageable pageable);

	<S extends MonAn> S save(S entity);

	List<MonAn> findAll();

	Page<MonAn> findByTenMonAnContaining(String tenMonAn, Pageable pageable);

	List<MonAn> findByMaNhomMonAn(Long maNhomMon);

	MonAn findMonAnById(Long maMonAn);


}

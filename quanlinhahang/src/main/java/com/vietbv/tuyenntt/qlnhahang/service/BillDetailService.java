package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietbv.tuyenntt.qlnhahang.domain.ChiTietHoaDon;

public interface BillDetailService {

	ChiTietHoaDon getById(Long id);

	void deleteAll();

	void delete(ChiTietHoaDon entity);

	void deleteById(Long id);

	long count();

	List<ChiTietHoaDon> findAll(Sort sort);

	List<ChiTietHoaDon> findAll();

	Page<ChiTietHoaDon> findAll(Pageable pageable);

	<S extends ChiTietHoaDon> S save(S entity);

}

package com.vietbv.tuyenntt.qlnhahang.service;

import java.util.List;
import java.util.Optional;

import com.vietbv.tuyenntt.qlnhahang.domain.Quantri;

public interface QuantriService {

	void deleteById(String id);

	Optional<Quantri> findById(String id);

	List<Quantri> findAll();

	<S extends Quantri> S save(S entity);

	Quantri login(String username, String password);

}

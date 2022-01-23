package com.vietbv.tuyenntt.qlnhahang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vietbv.tuyenntt.qlnhahang.domain.Quantri;

@Repository
public interface QuantriRepository extends JpaRepository<Quantri, String>{

}

package com.vietbv.tuyenntt.qlnhahang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vietbv.tuyenntt.qlnhahang.domain.LienHe;

@Repository
public interface LienHeRepository extends JpaRepository<LienHe, Long>{
	Page<LienHe> findByHoTenContaining(String hoten, Pageable pageable);
}

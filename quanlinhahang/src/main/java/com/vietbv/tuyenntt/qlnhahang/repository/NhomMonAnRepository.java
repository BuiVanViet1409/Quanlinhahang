package com.vietbv.tuyenntt.qlnhahang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vietbv.tuyenntt.qlnhahang.domain.NhomMonAn;

@Repository
public interface NhomMonAnRepository extends JpaRepository<NhomMonAn, Long>{
	Page<NhomMonAn> findByTenNhomMonContaining(String tenNhomMon, Pageable pageable);
}

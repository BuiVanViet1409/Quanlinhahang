package com.vietbv.tuyenntt.qlnhahang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vietbv.tuyenntt.qlnhahang.domain.DatBan;

@Repository
public interface DatBanRepository extends JpaRepository<DatBan, Long>{
	Page<DatBan> findByHoTenContaining(String hoten, Pageable pageable);
}

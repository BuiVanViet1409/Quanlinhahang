package com.vietbv.tuyenntt.qlnhahang.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vietbv.tuyenntt.qlnhahang.domain.MonAn;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, Long>{
	Page<MonAn> findByTenMonAnContaining(String tenMonAn, Pageable pageable);
	@Query("SELECT p FROM MonAn p WHERE p.nhomMonAn.maNhomMon = ?1")
	List<MonAn> findByMaNhomMonAn(Long maNhomMon);
}

package com.vietbv.tuyenntt.qlnhahang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vietbv.tuyenntt.qlnhahang.domain.HoaDon;
import com.vietbv.tuyenntt.qlnhahang.model.DatShipDto;

public interface BillRepository extends JpaRepository<HoaDon, Long>{
	@Query("SELECT MAX(maHoaDon) FROM HoaDon")
	Long getIDLastHoaDon();
	
	
	@Query(value = "SELECT a.maHoaDon, a.ten, a.address, a.email, a.note,a.ngayLap, a.phone, b.soLuong, b.thanhtien, c.tenMonAn FROM hoadons a INNER JOIN chitiethoadons b ON a.maHoaDon = b.maHoaDon INNER JOIN monans c ON b.maMonAn = c.maMonAn", nativeQuery = true)
	List<DatShipDto> getDatShipList();
}

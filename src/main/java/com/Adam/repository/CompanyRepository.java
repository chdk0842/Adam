package com.Adam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Adam.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {	
	
	
	//회사코드가 max인 쿼리문 : 시퀀스라 가장 높은게 최근이라 member안에 company와 매칭 (쿼리문 만들기)
	@Query(value = "select max(next_val) 'com_num' from MY_SEQUENCE",  nativeQuery= true)
	Long findByComNumnativeQuery();
	
	
	Company findByComNum(Long comNum);
	
}

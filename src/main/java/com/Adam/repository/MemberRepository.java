package com.Adam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Adam.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Member findByUserId(String userId); //회원가입시 중복 회원이 있는지 검사하기 위해
	
	//시퀀스 1씩 증가 (=10002)
	@Query(value = "select max(next_val)+1 'com_num' from MY_SEQUENCE", nativeQuery= true)
	Long findByCompanyByNative();
	
	
	
	
}

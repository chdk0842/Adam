package com.Adam.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Adam.dto.MemberFormDto;
import com.Adam.entity.Company;
import com.Adam.entity.Member;
import com.Adam.repository.CompanyRepository;
import com.Adam.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service //service 클래스의 역할
@Transactional //서비스 클래서에서 로직을 처리하다가 에러가 발생하면 로직을 수행하기 이전 상태로 되돌려 준다. 
@RequiredArgsConstructor
public class MemberService implements UserDetailsService { //UserDetailsService: 로그인시 request에서 넘어온 사용자 정보를 받음
	private final MemberRepository memberRepository; //의존성 주입
	private final CompanyRepository companyRepository; //의존성 주입
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Member member = memberRepository.findByUserId(userId); 
		
		if(member == null) {
			throw new UsernameNotFoundException(userId);
		}
		
		//userDetails의 객체를 반환
		return User.builder()
				.username(member.getUserId())
				.password(member.getPw())
				.roles(member.getRole().toString())
				.build();
	}
	
	
	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member); //member 테이블에 insert
	}
	
	public Company saveCompany(Company company) {
		return companyRepository.save(company); //member 테이블에 insert
	}
	

	
	public MemberFormDto getCompany() {
		Long comNum = memberRepository.findByCompanyByNative();
		MemberFormDto mf = new MemberFormDto();
		mf.setComNum(comNum);
		
		return mf;
	}
	
	//아이디 중복체크 메소드
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByUserId(member.getUserId());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
	// TODO memberService 회사코드를 받아서 조회후 true false 리턴
	//회사코드
		public int vaildateDuplicateComNum(Long comNum) {
			
			Company company = companyRepository.findByComNum(comNum);
			int chk;
			
			if (company != null) {
				
				return chk = 0;
			}
			
			return chk = 1;
		}
	
	

}

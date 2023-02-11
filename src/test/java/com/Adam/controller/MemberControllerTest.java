package com.Adam.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import com.Adam.constant.Role;
import com.Adam.dto.CompanyDto;
import com.Adam.dto.MemberFormDto;
import com.Adam.entity.Company;
import com.Adam.entity.Member;
import com.Adam.service.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
/* @Transactional */
class MemberControllerTest {

	@Autowired
	private MemberService memberservice;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PasswordEncoder passwordEncoder;

	/*
	 * public Member createMember(String id, String password) { 
	 * MemberFormDto member = new MemberFormDto();
	 * member.setName("신초아");
	 * member.setId("chdk");
	 * member.setRole(Role.ADMIN);
	 * member.setCom_name("집");
	 * 
	 * Member member2 = Member.createMember(member, passwordEncoder); return
	 * memberservice.saveMember(member2); }
	 */

//	public Company createCompany() {
//		CompanyDto company = new CompanyDto();
//		company.setCom_name("회사임");
//
//		Company company2 = Company.createCompany(company);
//		return memberservice.saveCompany(company2);
//	}

//	@Test
//	@DisplayName("회사등록 테스트")
//	public void companyAddTest() throws Exception {
//		Company company = createCompany();
//		Company savedCompany = memberservice.saveCompany(company);
//		
//		assertEquals(company.getCom_name(), savedCompany.getCom_name());
//		
//		
//	}
	
	/*
	 * @Test
	 * 
	 * @DisplayName("로그인 성공 테스트")
	 * public void loginSuccessTest() throws Exception {
	 * String id = "chdk";
	 * String password = "1234";
	 * this.createMember(id,password);
	 * mockMvc.perform(formLogin().userParameter("id")
	 * .loginProcessingUrl("/member/userMain") 
	 * //회원가입 메소드를 실행 후에 회원정보로 로그인이 되는지 테스트를 진행(해당 url로 로그인 요청)
	 * .user(id).password(password))
	 * .andExpect(SecurityMockMvcResultMatchers.authenticated()); 
	 * //로그인이 성공해서 인증되면테스트 코드를 통과시킨다. }
	 * 
	 */
	

}

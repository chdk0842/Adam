package com.Adam.entity;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.Adam.constant.Role;
import com.Adam.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member") //테이블명
@Getter
@Setter
@ToString
public class Member {
	@Id
	@Column(unique = true)
	private String userId;
	
	private String name;
	
	private String pw;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comNum")
	private Company company;

	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder, Company getCom) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setUserId(memberFormDto.getUserId());
		member.setCompany(getCom);
		
		 String password = passwordEncoder.encode(memberFormDto.getPw()); //비밀번호 암호화
		 member.setPw(password);
		 
		
		member.setRole(memberFormDto.getRole());
		
		return member;
	}



}

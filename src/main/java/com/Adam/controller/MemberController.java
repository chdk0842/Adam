package com.Adam.controller;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Adam.constant.Role;
import com.Adam.dto.MemberFormDto;
import com.Adam.entity.Company;
import com.Adam.entity.Member;
import com.Adam.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	private final PasswordEncoder passwordEncoder;

	// 일반회원가입 화면
	@GetMapping(value = "/membernew")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
		return "member/memberForm";
	}

	// 대표회원가입 화면
	@GetMapping(value = "/adminnew")
	public String adinForm(Model model) {
		model.addAttribute("memberFormDto", memberService.getCompany());
		return "member/adminForm";
	}
	
	

	// 일반회원가입 버튼을 눌렀을때 실행되는 메소드
	@PostMapping(value = "/membernew")
	public String memberForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		// @Valid : 유효성을 검증하려는 객체 앞에 붙인다.
		// bindingResult: 유효성 검증후에 결과를 넣어준다.

		// 에러가 있다면 회원가입 페이지로 이동
		if (bindingResult.hasErrors()) {
			return "member/memberForm";
		}

		memberFormDto.setRole(Role.USER);

		try {
			// 회사코드
			Company getCom = new Company();
			getCom.setComNum(memberFormDto.getComNum());

			// 회원가입
			Member member = Member.createMember(memberFormDto, passwordEncoder, getCom);
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/memberForm";
		}

		return "redirect:/";
	}

	// 대표회원가입 버튼을 눌렀을때 실행되는 메소드
	@PostMapping(value = "/adminnew")
	public String adminrForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		// @Valid : 유효성을 검증하려는 객체 앞에 붙인다.
		// bindingResult: 유효성 검증후에 결과를 넣어준다.

		// 에러가 있다면 회원가입 페이지로 이동
		if (bindingResult.hasErrors()) {
			return "member/adminForm";
		}

		memberFormDto.setRole(Role.ADMIN);

		try {
			// 회사코드
			Company company = Company.createCompany(memberFormDto);
			memberService.saveCompany(company);
			Company getCom = new Company();
			MemberFormDto mt = memberService.getCompany();
			getCom.setComNum(mt.getComNum() - 1);

			// 회원가입
			Member member = Member.createMember(memberFormDto, passwordEncoder, getCom);
			memberService.saveMember(member);

		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/adminForm";
		}

		return "redirect:/";
	}
	

	// 로그인 화면
	@GetMapping(value = "/login")
	public String loginMember() {
		return "member/memberLoginForm";
	}

	private final SessionManager sessionManager;

	// 로그인 후 메인 화면
	@GetMapping(value = "/userMain")
	public String userMain() {
		return "/member/userMain";
	}

	// 로그인을 실패했을때
	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
		return "member/memberLoginForm";
	}
}

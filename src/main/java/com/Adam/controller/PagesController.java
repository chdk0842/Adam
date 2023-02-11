package com.Adam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/Pages")
@Controller
@RequiredArgsConstructor
public class PagesController {

	// 마이페이지
	@GetMapping(value = "/myPage")
	public String memberForm() {
		return "pages/myPage";
	}


	// 기획리스트
	@GetMapping(value = "/projectList")
	public String projectList() {
		return "pages/projectList";
	}

	// 이달의 플랜
	@GetMapping(value = "/calendar")
	public String calendar() {
		return "pages/calendar";
	}

	// 백그라운드
	@GetMapping(value = "/background")
	public String background() {
		return "pages/background";
	}

}

package com.Adam.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Adam.dto.ProjectFormDto;
import com.Adam.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectController {
	
	private final ProjectService projectService;
	
	    //기획하기 페이지
		@GetMapping(value = "/admin/project/new")
		public String projectForm(Model model) {
			model.addAttribute("projectFormDto", new ProjectFormDto());
			return "project/projectForm";
			
		}
		
		//프로젝트 등록
		@PostMapping(value = "/admin/project/new")
		public String projectNew(@Valid ProjectFormDto projectFormDto, BindingResult bindingResult,
				Model model, @RequestParam("projectImgFile") List<MultipartFile> projectImgFileList) {
			if(bindingResult.hasErrors()) {
				return "project/projectForm";
			}
			
			//첫번째 이미지가 있는지 검사
			if(projectImgFileList.get(0).isEmpty() && projectFormDto.getId() == null) {
				model.addAttribute("errorMessage", "첫번째 이미지는 필수 입력 값 입니다.");
				return "project/projectForm";
			}
			
			try {
				projectService.saveProject(projectFormDto, projectImgFileList);
			} catch (Exception e) {
				model.addAttribute("errorMessage", "프로젝트 등록 중 에러가 발생했습니다.");
				return "project/projectForm";
			}
			
			return "/member/userMain";
		}
		
		//프로젝트 수정 페이지 보기
		@GetMapping(value = "/admin/project/{projectId}")
		public String projectDtl(@PathVariable("projectId") Long projectId, Model model) {
			try {
				ProjectFormDto projectFormDto = projectService.getProjectDtl(projectId);
				model.addAttribute(projectFormDto);
			} catch (Exception e) {
				model.addAttribute("errorMessage", "존재하지 않는 프로젝트입니다.");
				model.addAttribute("projectFormDto", new ProjectFormDto());
				return "project/projectForm";
			}
			return "project/projectForm";
		}
		
		//프로젝트 수정
				@PostMapping(value = "/admin/project/{projectId}")
				public String projectUpdate(@Valid ProjectFormDto projectFormDto, BindingResult bindingResult,
						Model model, @RequestParam("projectImgFile") List<MultipartFile> projectImgFileList) {
					if(bindingResult.hasErrors()) {
						return "project/projectForm";
					}
					
					//첫번째 이미지가 있는지 검사
					if(projectImgFileList.get(0).isEmpty() && projectFormDto.getId() == null) {
						model.addAttribute("errorMessage", "첫번째 이미지는 필수 입력 값 입니다.");
						return "project/projectForm";
					}
					
					try {
						projectService.updateProject(projectFormDto, projectImgFileList);
					} catch (Exception e) {
						e.printStackTrace();
						model.addAttribute("errorMessage", "프로젝트 수정 중 에러가 발생했습니다.");
						return "project/projectForm";
					}
					
					return "/member/userMain";
				}
				
				
		
		// TODO : projectManage 작성
		
		//프로젝트 상세 페이지
//		@GetMapping(value = "/project/{projectId}")
//		public String projectDtl(Model model, @PathVariable("projectId") Long projectId) {
//			ProjectFormDto projectFormDto = projectService.getProjectDtl(projectId);
//			model.addAttribute("project", projectFormDto);
//			return "project/projectDtl";
//		}
		
		

}

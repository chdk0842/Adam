package com.Adam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Adam.dto.MainProjectDto;
import com.Adam.dto.ProjectSearchDto;
import com.Adam.entity.Project;

public interface ProjectRepositoryCustom {
	// 프로젝트관리 페이지 정보를 가져온다
	Page<Project> getAdminProjectPage(ProjectSearchDto projectSearchDto, Pageable pageable);

	// 메인화면에 뿌리는프로젝트 정보를 가져온다
	Page<MainProjectDto> getMainProjectPage(ProjectSearchDto projectSearchDto, Pageable pageable);

}

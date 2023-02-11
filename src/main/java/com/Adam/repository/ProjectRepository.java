package com.Adam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.Adam.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>,
QuerydslPredicateExecutor<Project>, ProjectRepositoryCustom {
    
	List<Project> findByProjectName(String projectName);
	
	List<Project> findByProjectNameorProjectContentContent(String projectName, String projectContent);
	
	@Query("select p from Project p where p.ProjectContent like %?1% order by p.deadLine desc")
	List<Project> findByProjectContent(String projectContent);
	
	@Query(value = "select * from Project p where p.content like %:projectContent% order by p.deadLine desc", nativeQuery =true)
	List<Project> findByProjectContentByNative(@Param("projectContent") String projectContent);
}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.dto.ProjectNameInfo;

@Repository
public interface ProjectNameInfoRepo extends JpaRepository<ProjectNameInfo,Integer> {
	
	
	@Query(value ="select tech_components.component_id as value, tech_components.component_name as text"
			+ " from strat_to_component"
			+ " inner join tech_components on strat_to_component.component_id = tech_components.component_id"
			+ " where strat_to_component.strat_id = ?1"
			+ " order by tech_components.component_name asc" , nativeQuery = true)
	public List<ProjectNameInfo> getProjectNameInfoStratId(int stratId);
	
	@Query(value ="select tech_components.component_id as value, tech_components.component_name as text"
			+ " from strat_to_component"
			+ " inner join tech_components on strat_to_component.component_id = tech_components.component_id"
			+ " where strat_to_component.strat_id = ?1 and lower(tech_components.component_name) like concat('%',concat(?2,'%'))"
			+ " order by tech_components.component_name asc" , nativeQuery = true)
	public List<ProjectNameInfo> getProjectNameInfoSuggestion(int stratId,String keyword);
	
	

}

package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ProjectInfo;

@Repository
public interface ProjectInfoRepo extends JpaRepository<ProjectInfo, Integer>{

	@Query(value="select strategies.strat_id,strategies.strat_name from strategies\r\n"
			+ "where strategies.strat_id= ?1",nativeQuery=true)
	ProjectInfo getProjectInfo(int stratId);
}

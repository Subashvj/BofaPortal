package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MilestoneInfo;

@Repository
public interface MilestoneInfoRepo extends JpaRepository<MilestoneInfo, Integer> {
	
	@Query(nativeQuery = true , 
			value = "SELECT task_milestones.milestone_id AS value, "
					+ "task_milestones.milestone_desc AS text "
					+ "FROM task_milestones "
					+ "WHERE task_milestones.milestone_visible=1")
	public List<MilestoneInfo> restrieveMilestoneInfoData();

}

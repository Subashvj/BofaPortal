package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallMilestoneInfo;

@Repository
public interface InstallMilestoneRepository extends JpaRepository<InstallMilestoneInfo, Integer> {
	@Query(value="select install_milestones.inst_mile_id, inst_milestone_types.milestone_desc,\r\n"
			+ "to_char(install_milestones.start_date,'mm/dd') as startdate,\r\n"
			+ "to_char(install_milestones.end_date,'mm/dd') as enddate,\r\n"
			+ "install_milestones.start_date as sd, install_milestones.end_date as ed\r\n"
			+ "from install_milestones\r\n"
			+ "inner join inst_milestone_types on install_milestones.inst_milestone_type_id = inst_milestone_types.inst_milestone_type_id\r\n"
			+ "where install_milestones.install_id = ?1 \r\n"
			+ "order by install_milestones.start_date asc, install_milestones.end_date asc", nativeQuery = true)
	List<InstallMilestoneInfo> installMilestoneInfos(int installId); 

}

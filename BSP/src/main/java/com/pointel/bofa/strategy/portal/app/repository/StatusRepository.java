package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.StatusInfo;

@Repository
public interface StatusRepository extends JpaRepository<StatusInfo, Integer>{

	@Query(value="select strat_status.strat_status_id as value, strat_status.strat_status_desc as text\r\n"
			+ "from strat_status\r\n"
			+ "union\r\n"
			+ "select strat_status_descriptions.strat_status_id as value, strat_status_descriptions.strat_status_desc as text\r\n"
			+ "from strat_status_descriptions",nativeQuery = true)
	
	public List<StatusInfo> statusList();
	
}
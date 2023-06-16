package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.CabStatus;

@Repository
public interface CabStatusInfoRepo extends JpaRepository<CabStatus, Integer>{

	@Query(value="select cab_status.cab_status, cab_status.cab_status_description \r\n"
			+ "from cab_status order by cab_status.cab_status desc",nativeQuery=true)
	public List<CabStatus> getCabStatus();
}

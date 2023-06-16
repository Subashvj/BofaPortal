package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.DevPlanning;
import com.pointel.bofa.strategy.portal.app.dto.DevPlanningPk;


@Repository
public interface DevPlanningRepo extends JpaRepository<DevPlanning, DevPlanningPk>{

	
	@Query(value="select * from DEV_PLANNING where STRAT_ID =?1 and DEV_MONTH =?2  and DEV_YEAR=?3 and DEV_USER=?4",nativeQuery = true)
	DevPlanning checkDevPlanning(int stratId,int devMonth,int devYear,String devUser);
	
	@Modifying
	@Query(value="Delete from DEV_PLANNING where STRAT_ID =?1 and DEV_MONTH =?2  and DEV_YEAR=?3 and DEV_USER=?4",nativeQuery = true)
	void deleteDevPlanning(int stratId,int devMonth,int devYear,String devUser);
	
}

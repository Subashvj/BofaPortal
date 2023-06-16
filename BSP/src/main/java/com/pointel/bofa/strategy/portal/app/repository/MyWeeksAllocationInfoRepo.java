package com.pointel.bofa.strategy.portal.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MyWeeksAllocationInfo;

@Repository
public interface MyWeeksAllocationInfoRepo extends JpaRepository<MyWeeksAllocationInfo, Integer> {

	@Query(value = "select resourceplanning.strat_id,resourceplanning.hours, replace((resourceplanning.hours/8),'.000','') as seconds,\r\n"
			+ "	resourceplanning.week_start,strategies.strat_name from resourceplanning\r\n"
			+ "	inner join strategies on resourceplanning.strat_id=strategies.strat_id where\r\n"
			+ "	resourceplanning.userid=?1 and\r\n"
			+ "	resourceplanning.week_start=to_date(?2,'mm-dd-yyyy') and\r\n"
			+ "	resourceplanning.hours is not null", nativeQuery = true)
	List<MyWeeksAllocationInfo> retriveMyWeeksAllocationInfo(String userId, String date);

}

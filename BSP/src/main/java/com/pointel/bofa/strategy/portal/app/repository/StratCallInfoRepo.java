package com.pointel.bofa.strategy.portal.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.StratCallInfo;

public interface StratCallInfoRepo extends JpaRepository<StratCallInfo, Integer> {
	
	@Query(value = "SELECT strategies.strat_id,"
			+ " CONCAT(strategies.strat_id,concat(': ',strategies.strat_name)) as title,"
			+ " strategies.target_date as startdate, '#337ab7\' as color,"
			+ " CONCAT('strat_details.php?strat_id=\',strategies.strat_id) as url"
			+ " FROM strategies WHERE"
			+ " (strategies.target_date >=TO_DATE(?1,'YYYY-MM-DD') AND strategies.target_date <= TO_DATE(?2,'YYYY-MM-DD'))"
			+ " AND strategies.strat_status_id <>2"
			+ " UNION"
			+ " SELECT strategies.strat_id,"
			+ " CONCAT(strategies.strat_id,concat(': ',strategies.strat_name)) as title,"
			+ " strategies2.full_deploy as start2, '#d9534f\' as color,"
			+ " CONCAT('strat_details.php?strat_id=\',strategies.strat_id) as url"
			+ " FROM strategies"
			+ " inner join strategies2 on strategies.strat_id = strategies2.strat_id"
			+ " WHERE (strategies2.full_deploy >= TO_DATE(?1,'YYYY-MM-DD') AND strategies2.full_deploy <= TO_DATE(?2,'YYYY-MM-DD'))"
			+ " AND strategies.strat_status_id <>2",nativeQuery = true)
	public List<StratCallInfo> retrieveInstallCallInfoData(String startDate,String endDate);

}

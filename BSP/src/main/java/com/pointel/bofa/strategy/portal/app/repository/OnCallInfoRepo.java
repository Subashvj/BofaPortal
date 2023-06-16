package com.pointel.bofa.strategy.portal.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.OnCallInfo;

public interface OnCallInfoRepo extends JpaRepository<OnCallInfo, Integer> {
	
	@Query(value = "SELECT oncall.coverage_id as id, oncall.start_date "
			+ "as startdate, oncall.end_date + INTERVAL '1' DAY as enddate, "
			+ "'true\' as allDay, '#6acbfb\' as color,'#222222\' as textColor, "
			+ "CONCAT(oncall_coverage.coverage_desc,concat(': \', users.displayname)) as title, "
			+ "oncall.oncallorder, '1\' as edit FROM oncall "
			+ "INNER JOIN oncall_coverage ON oncall.coverage_type = oncall_coverage.coveragetype "
			+ "INNER JOIN users ON oncall.userid = users.userid "
			+ "WHERE oncall.start_date <= TO_DATE(?1,'YYYY-MM-DD') AND oncall.end_date >= TO_DATE(?2,'YYYY-MM-DD') "
			+ "ORDER BY oncall.oncallorder ASC"
			, nativeQuery = true)
	public List<OnCallInfo> retrieveOncallInfoData(String startDate , String endDate);

}

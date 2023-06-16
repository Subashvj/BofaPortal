package com.pointel.bofa.strategy.portal.app.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.HolidaycalInfo;

@Repository
public interface HolidaycallInfoRepo extends JpaRepository<HolidaycalInfo, Integer> {
	
	@Query(value = "select calendar_events.cal_date as startdate, calendar_events.cal_evet_desc as title, "
			+ "'\\' as rendering, '#e1eaed' as color, '#222222' as textcolor from calendar_events "
			+ "inner join cal_event_types on calendar_events.cal_event_type = cal_event_types.cal_event_type "
			+ "where calendar_events.cal_date>=TO_DATE(?1,'YYYY-MM-DD') and calendar_events.cal_date<=TO_DATE(?2,'YYYY-MM-DD') "
			+ "union "
			+ "select calendar_events.cal_date as startdate, calendar_events.cal_evet_desc as title,"
			+ " 'background' as rendering, '#9bb9c1' as color, '#222222' as textcolor "
			+ "from calendar_events "
			+ "inner join cal_event_types on calendar_events.cal_event_type = cal_event_types.cal_event_type "
			+ "where calendar_events.cal_date>=TO_DATE(?1,'YYYY-MM-DD') and calendar_events.cal_date<=TO_DATE(?2,'YYYY-MM-DD')" 
			,nativeQuery = true)
	List<HolidaycalInfo> retrieveHolidaycallInfoData(String startDate,String endDate);
	

}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dao.OverviewInfo;
@Repository
public interface OverviewRepository extends JpaRepository<OverviewInfo,Integer >{
	@Query(value="select strategies.strat_id, strategies.strat_name, strategies.strat_requestor, strategies.strat_requestor_dept, strat_phases.strat_phase_desc,\r\n"
			+ "strategies.strat_objectives, strategies.strat_bus_just, strategies.strat_benefit, strategies.strat_added_by,\r\n"
			+ "addedby.displayname addbyname, strategies.strat_category, strat_categories.strat_cat_desc, strategies.strat_update,\r\n"
			+ "to_char(strategies.target_date) as target_date, to_char(strategies.start_date) as start_date,strategies1.analyst_summary,\r\n"
			+ "nvl(strategies.target_firm,0) as target_firm, strategies.strat_statusdate, strategies.execview, strat_status.strat_status_desc,\r\n"
			+ "strategies.strat_status_id, lobs.lob_desc, strategies.strat_color, strategies1.exec_status, strategies1.sizing_due, strategies1.kickoff_date,\r\n"
			+ "strategies.strat_req_bus_area, strategies.strat_added, strategies2.cast, application.application_name, ivr_solution.ivr_solution_desc,\r\n"
			+ "strategies2.pprt, strategies2.ucra, strategies2.full_deploy, strat_colors.strat_color_desc,\r\n"
			+ "strat_areas_new.area, users.displayname from strategies\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join strat_phase_history on strategies.strat_id = strat_phase_history.strat_id\r\n"
			+ "inner join strat_phases on strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "inner join strat_colors on strategies.strat_color = strat_colors.strat_color\r\n"
			+ "inner join ivr_solution on strategies2.ivr_solution_id = ivr_solution.ivr_solution_id\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join users on strategies.strat_name = users.displayname\r\n"
			+ "inner join strat_areas_new on strategies2.strat_requestor_dept_id = strat_areas_new.area_id\r\n"
			+ "inner join users addedby on strategies.strat_added_by = addedby.userid\r\n"
			+ "inner join strat_categories on strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "inner join lobs on strategies1.lob_id = lobs.lob_id\r\n"
			+ "inner join strat_status on strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "inner join funding_types on strategies1.funding_type = funding_types.fund_id\r\n"
			+ "inner join user_groups on strategies1.group_id = user_groups.group_id\r\n"
			+ "inner join ( select strat_to_group.strat_id,\r\n"
			+ "listagg(user_groups.usergroupdesc,'/') as group_desc, listagg(user_groups.group_id,'/') as group_id2\r\n"
			+ "from user_groups\r\n"
			+ "inner join strat_to_group on strat_to_group.usergroup = user_groups.group_id\r\n"
			+ "where strat_to_group.strat_id = ?1\r\n"
			+ "group by strat_to_group.strat_id,user_groups.usergroupdesc, user_groups.group_id\r\n"
			+ ") groups1 on strategies.strat_id = groups1.strat_id\r\n"
			+ "left join ( select 1 as hiddenval,strat_id from user_hide_home\r\n"
			+ "where user_hide_home.user_id =?2 and user_hide_home.strat_id =?1\r\n"
			+ ") hid on strategies.strat_id = hid.strat_id\r\n"
			+ "left join users sponsor on strategies.strat_req_bus_area = sponsor.userid\r\n"
			+ "left join funding_sources on strategies1.funding_source = funding_sources.funding_src_id\r\n"
			+ "where strategies.strat_id =?1",nativeQuery = true)
	List<OverviewInfo> overviewinf(int stratId, String userId);

}

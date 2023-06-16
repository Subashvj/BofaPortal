package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.PmInfo;

@Repository
public interface PmRepository extends JpaRepository<PmInfo,Integer>{
	
	@Query(value = "select strategies.strat_id, strategies.strat_name, strategies1.sharepoint_link, sponsor.displayname as sponsorname,\r\n"
			+ "strategies1.projuid, strategies1.gppid, strategies1.priority_request, funding_types.fund_desc, strategies1.resource_plan,\r\n"
			+ "strategies1.qc_num, strategies1.pm_change_notes, strategies1.test_notes, groups1.group_desc as groups_list,\r\n"
			+ "strategies.execview, funding_sources.funding_src_desc, strategies1.funding_num, strategies1.parent_clarity,\r\n"
			+ "strategies1.child_clarity, strategies1.nexus_id, strategies1.kickoff_date, strategies1.proj_reg, strategies1.pet_num,\r\n"
			+ "strategies1.risks, strategies1.issues, strategies1.gotogreen from strategies\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join funding_types on strategies1.funding_type = funding_types.fund_id\r\n"
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
			+ "where strategies.strat_id =?1",  nativeQuery = true)
	public List<PmInfo> getPmInfo(int startId,String userId);
}

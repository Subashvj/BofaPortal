package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.RecusersInfo;

@Repository
public interface RecusersListRepository extends JpaRepository<RecursersList,Integer>{

	@Query(value="select strat_to_component.strat_id, tech_cmpnt_to_est_group.estimate_grp, estimate_groups.group_name,\r\n"
			+ "estimate_groups.owner, users.displayname, users.proj_role from strat_to_component\r\n"
			+ "inner join tech_cmpnt_to_est_group on strat_to_component.component_id = tech_cmpnt_to_est_group.component_id\r\n"
			+ "inner join estimate_groups on  tech_cmpnt_to_est_group.estimate_grp = estimate_groups.estimate_grp\r\n"
			+ "inner join users on estimate_groups.owner = users.userid\r\n"
			+ "where strat_to_component.strat_id = ?1 and estimate_groups.owner not in (?2)",nativeQuery=true)
	public List<RecursersList> getRecusersListInfo(int stratId,List<RecusersInfo>recuInfo);
}

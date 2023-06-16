package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;

@Repository
public interface RecommendedMembersRepo extends JpaRepository<RecommendedMembers, Integer>{

@Query(value ="select strat_to_component.strat_id, tech_cmpnt_to_est_group.estimate_grp,"
		+ " listagg(estimate_groups.group_name,',\') as group_name, estimate_groups.owner,"
		+ " users.displayname from strat_to_component"
		+ " inner join tech_cmpnt_to_est_group on strat_to_component.component_id = tech_cmpnt_to_est_group.component_id"
		+ " inner join estimate_groups on tech_cmpnt_to_est_group.estimate_grp = estimate_groups.estimate_grp"
		+ " inner join users on estimate_groups.owner = users.userid"
		+ " where strat_to_component.strat_id = ?1"
		+ " and estimate_groups.owner not in ('recusers')"
		+ " group by estimate_groups.owner, strat_to_component.strat_id, tech_cmpnt_to_est_group.estimate_grp, users.displayname",  nativeQuery = true)
public List<RecommendedMembers> getMembers(int strat_id);
}


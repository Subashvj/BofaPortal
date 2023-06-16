package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.Resources;

public interface ResourcePlanMasterDataRepo extends JpaRepository<Resources, String> {
	
	@Query(nativeQuery = true , value = "select strat_members.username, users.displayname, user_types.usertype_desc from strat_members "
			+ "inner join users on strat_members.username = users.userid "
			+ "inner join user_types on users.usertype_id = user_types.usertype "
			+ "where strat_members.strat_id = ?1 "
			+ "and strat_members.username <> 'bbb' "
			+ "union select distinct dev_planning.dev_user, users.displayname, user_types.usertype_desc from dev_planning "
			+ "inner join users on dev_planning.dev_user = users.userid "
			+ "inner join user_types on users.usertype_id = user_types.usertype "
			+ "where dev_planning.strat_id = ?1 "
			+ "order by displayname")
	List<Resources> retrieveResourcePlanMasterData(int StratId);

}

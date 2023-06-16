package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
@Repository
public interface StratMemberInfoRepo extends JpaRepository<StratMemberInfo,Integer>{
	@Query(value ="select strat_members.username, strat_members.role_id, strat_roles.role_desc,users.displayname,"
			+ " users.mgrid, users.active, users.connection_key from strat_members"
			+ " inner join users on strat_members.username = users.userid"
			+ " inner join strat_roles on strat_members.role_id = strat_roles.role_id"
			+ " where strat_members.strat_id=?1"
			+ " order by strat_roles.role_desc, users.mgrid, users.active desc", nativeQuery = true)
	public List<StratMemberInfo> getStratMemberInfo(int stratId);
	
	

}

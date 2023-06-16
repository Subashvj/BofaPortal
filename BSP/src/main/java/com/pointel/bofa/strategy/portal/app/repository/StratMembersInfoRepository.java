package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;


@Repository
public interface StratMembersInfoRepository extends JpaRepository<StratMemberInfo, String> {

	@Query(value="select strat_members.username, strat_members.role_id, strat_roles.role_desc,\r\n"
			+ "users.displayname, users.mgrid from strat_members\r\n"
			+ "inner join users on strat_members.username = users.userid\r\n"
			+ "inner join strat_roles on strat_members.role_id = strat_roles.role_id\r\n"
			+ "where strat_members.strat_id =?1 order by strat_roles.role_desc",nativeQuery=true)
	
	public List<StratMemberInfo> getStratMembers(int stratId);
	
	
}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.TeamInfo;
@Repository
public interface TeamRepository extends JpaRepository<TeamInfo, String>{
	@Query(value=" \r\n"
			+ "select DISTINCT users.userid,users.displayname from mgmt_structure l1\r\n"
			+ "inner join mgmt_structure l2 on l1.user_id = l2.mgr\r\n"
			+ "inner join mgmt_structure l3 on l2.user_id = l3.mgr\r\n"
			+ "inner join mgmt_structure l4 on l3.user_id = l4.mgr\r\n"
			+ "inner join mgmt_structure l5 on l4.user_id = l5.mgr\r\n"
			+ "left join users on l1.user_id = users.userid\r\n"
			+ "or l2.user_id = users.userid\r\n"
			+ "or l3.user_id = users.userid\r\n"
			+ "or l4.user_id = users.userid\r\n"
			+ "or l5.user_id = users.userid where l1.mgr=?1 and\r\n"
			+ "users.active = 1 order by users.displayname asc", nativeQuery = true)
	public List<TeamInfo> teaminforepo(String username);

}

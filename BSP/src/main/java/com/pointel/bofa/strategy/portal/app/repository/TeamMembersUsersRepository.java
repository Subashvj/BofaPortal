package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.TeamMemberUsersInfo;
@Repository
public interface TeamMembersUsersRepository extends JpaRepository<TeamMemberUsersInfo, String>{

	@Query(value="select users.userid as value, users.displayname as text \r\n"
			+ "from users\r\n"
			+ "left join ( select strat_members.username from strat_members\r\n"
			+ "where strat_members.strat_id = ?1\r\n"
			+ ") a on users.userid = a.username\r\n"
			+ "where users.active = 1 and a.username is  null\r\n"
			+ "order by users.displayname asc",nativeQuery = true)
	List<TeamMemberUsersInfo> memberUsersInfos(int stratId);
	
	
	@Query(value="select users.userid as value, users.displayname as text \r\n"
			+ "from users\r\n"
			+ "left join ( select strat_members.username from strat_members\r\n"
			+ "where strat_members.strat_id =?1\r\n"
			+ ") a on users.userid = a.username\r\n"
			+ "where users.active = 1 and a.username is  null and \r\n"
			+ "lower(users.displayname) LIKE CONCAT('%',CONCAT(?2,'%')) \r\n"
			+ "\r\n"
			+ "order by users.displayname asc",nativeQuery = true)
	List<TeamMemberUsersInfo> memberUsersSearchInfos(int stratId,String searchValue);
	
	
}

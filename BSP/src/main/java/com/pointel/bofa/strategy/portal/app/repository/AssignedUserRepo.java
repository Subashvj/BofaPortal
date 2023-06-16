package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.AssignedUser;

public interface AssignedUserRepo extends JpaRepository<AssignedUser, String> {
	
	@Query(nativeQuery = true,value = "select users.email , users.displayname from strat_members "
			+ "inner join users on strat_members.username = users.userid "
			+ "where users.active = 1 "
			+ "and strat_members.strat_id = ?1")
	List<AssignedUser> retrieveAssignedUser(int stratId);
	
	@Query(nativeQuery = true , value = "select users.email  ,users.displayname from users where users.userid = ?1")
	List<AssignedUser> retrirveAssignUser(String userId);

}

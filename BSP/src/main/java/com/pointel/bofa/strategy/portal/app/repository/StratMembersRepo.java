package com.pointel.bofa.strategy.portal.app.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.StratMembers;
@Repository
public interface StratMembersRepo extends JpaRepository<StratMembers, Integer>{
	@Query(value = "select * from strat_members where strat_id=?1 and username=?2",nativeQuery = true)
	public StratMembers getStratMembersByStratIdAndUserName(int stratId,String username);
			
	@Modifying
	@Query(value = "delete from strat_members where strat_id=?1 AND username=?2",nativeQuery = true)
	public void deleteStratMembers(int stratId,String username);
	
	
  StratMembers findByStratIdAndUsername(int stratId,String userName);
}

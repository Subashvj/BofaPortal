package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.RecusersInfo;

@Repository
public interface RecusersRepository extends JpaRepository<RecusersInfo, String> {

	@Query(value="  select strat_members.username as users\r\n"
			+ "	from strat_members where strat_members.strat_id = ?1",nativeQuery = true)
	public List<RecusersInfo> getRecusersInfoId(int StratId);
}

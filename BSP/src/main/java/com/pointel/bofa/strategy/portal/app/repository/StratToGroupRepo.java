package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.StratToGroup;
import com.pointel.bofa.strategy.portal.app.entity.StratToGroupPk;

@Repository
public interface StratToGroupRepo extends JpaRepository<StratToGroup, StratToGroupPk>{

	@Modifying
	@Query(value="Delete from strat_to_group where strat_id=?1",nativeQuery=true)
	public void deleteStratToGroup(int stratId);

}

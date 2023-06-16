package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.entity.StratToComponent;
import com.pointel.bofa.strategy.portal.app.entity.StratToComponentPK;

@Repository
public interface StratToComponentRepo extends JpaRepository<StratToComponent,StratToComponentPK>{
	
	@Modifying
	@Query(value="Delete from strat_to_component where strat_id=?1",nativeQuery = true)
	void stratToComponent(int stratId);
}

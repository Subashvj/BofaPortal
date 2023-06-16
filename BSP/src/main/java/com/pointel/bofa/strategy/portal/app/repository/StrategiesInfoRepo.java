package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.StrategiesInfo;

public interface StrategiesInfoRepo extends JpaRepository<StrategiesInfo, Integer> {
	
	@Query(nativeQuery = true , value = "select strategies.strat_id,strategies.strat_name from strategies where strategies.strat_id = ?1")
	List<StrategiesInfo> retrieveStrategiesInfo(int stratId);

}

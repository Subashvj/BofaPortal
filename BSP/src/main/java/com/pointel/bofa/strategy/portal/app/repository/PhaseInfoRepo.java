package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.PhaseInfo;

@Repository
public interface PhaseInfoRepo extends JpaRepository<PhaseInfo, Integer> {
	
	@Query(nativeQuery = true ,
			value = "SELECT "
					+ "strat_phases.strat_phase_id as value, "
					+ "strat_phases.strat_phase_desc as text "
					+ "FROM strat_phases "
					+ "WHERE strat_phases.strat_phase_visible = 1 "
					+ "ORDER BY "
					+ "strat_phases.strat_phase_display_order ASC")
	public List<PhaseInfo> restrievePhaseInfoData();

}

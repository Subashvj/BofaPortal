package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.StratPhases;
@Repository
public interface StratPhasesRepository extends JpaRepository<StratPhases, Integer>{
@Query(value="select strat_phases.strat_phase_id as value,\r\n"
		+ "concat(strat_phases.dmaic,concat(':',strat_phases.strat_phase_desc)) as text\r\n"
		+ "from strat_phases order by strat_phases.strat_phase_display_order asc\r\n"
		,nativeQuery = true)

public List<StratPhases> getStratPhasesList(); 
}
package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ScopeDesign;

@Repository
public interface ScopeDesignRepository  extends JpaRepository<ScopeDesign,Integer>{

	@Query(value = "select strategies2.impact_prompt, strategies2.impact_ui, strategies2.impact_did, strategies2.impact_kvp,\r\n"
			+ "strategies2.impact_nlu, strategies2.impact_dynmen, strategies2.impact_dt, strategies2.impact_db,\r\n"
			+ "strategies2.impact_grammar, strategies2.impact_cti, strategies2.impact_codeonly from strategies2\r\n"
			+ "where strat_id = ?1",  nativeQuery = true)
	public List<ScopeDesign> getScopeDesign(int startId);
	
}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ScopeTesting;

@Repository
public interface ScopeTestingRepository extends JpaRepository<ScopeTesting,Integer>{

	@Query(value = "select strategies2.impact_regrtest, strategies2.impact_sit, strategies2.impact_functest,strategies2.impact_pivtest\r\n"
			+ "from strategies2 where strat_id=?1",  nativeQuery = true)
	public List<ScopeTesting> getScopeTesting(int startId);
}

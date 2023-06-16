package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.ScopeAnalytics;

@Repository
public interface ScopeAnalyticsRepository extends JpaRepository<ScopeAnalytics,Integer> {
	
	@Query(value = "select strategies2.impact_champchall from strategies2 where strat_id=?1",  nativeQuery = true)
	public List<ScopeAnalytics> getScopeAnalytics(int startId);
}

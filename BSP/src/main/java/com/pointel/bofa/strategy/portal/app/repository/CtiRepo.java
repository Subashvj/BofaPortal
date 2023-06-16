package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.Cti;

@Repository
public interface CtiRepo extends JpaRepository<Cti, Integer> {
	@Query(value ="select cti_planning.strat_id, cti_planning.cti_month, cti_planning.cti_year, cti_planning.cti_hours/8 as cti_hours,"
			+ " estimate_groups.group_name from cti_planning"
			+ " inner join estimate_groups on cti_planning.estimate_grp = estimate_groups.estimate_grp"
			+ " where cti_planning.strat_id = ?1"
			+ " order by cti_planning.cti_year, cti_planning.cti_month" ,  nativeQuery = true)
	public List<Cti> getCti(int strat_id);
	

}

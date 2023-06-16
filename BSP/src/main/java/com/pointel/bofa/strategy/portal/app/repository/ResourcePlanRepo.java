package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ResourcePlan;
@Repository
public interface ResourcePlanRepo extends JpaRepository<ResourcePlan, String> {
	@Query(value ="select users.userid,"
			+ " nvl(nullif(trim(users.nickname),''),regexp_substr(users.displayname,' ',1)) as shortname,"
			+ " dev_planning.strat_id, dev_planning.dev_month, dev_planning.dev_year, dev_planning.dev_hours/8 as dev_hours,"
			+ " users.displayname from dev_planning"
			+ " inner join users on dev_planning.dev_user = users.userid"
			+ " where dev_planning.strat_id = ?1 order by  dev_planning.dev_year,  dev_planning.dev_month, shortname", nativeQuery = true)
	public List<ResourcePlan> getResourcePlan(int strat_id);
}

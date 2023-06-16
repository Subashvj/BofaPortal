package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.entity.EstimateGroups;

@Repository
public interface EstimateGroupsInfoRepo extends JpaRepository<EstimateGroups, Integer>{

	@Query(value="select estimate_groups.estimate_grp, estimate_groups.group_name \r\n"
			+ "from estimate_groups order by estimate_groups.group_name asc",nativeQuery=true)
	public List<EstimateGroups> getEstimateGrp();
}

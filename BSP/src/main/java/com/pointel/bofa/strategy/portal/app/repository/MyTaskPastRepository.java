package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MytaskPastInfo;
@Repository
public interface MyTaskPastRepository extends JpaRepository<MytaskPastInfo, Integer>{
	
	@Query(value="select count(task_id) as pastdue from strat_tasks\r\n"
			+ "where strat_tasks.assigned_to = ?1 and strat_tasks.task_status_id\r\n"
			+ "not in (4,5) and strat_tasks.task_due < sysdate", nativeQuery = true)
	public List<MytaskPastInfo> getTaskPastin(String username);

	@Query(value="select count(task_id) as pastdue from strat_tasks\r\n"
			+ "where strat_tasks.assigned_to IN ?1 and strat_tasks.task_status_id\r\n"
			+ "not in (4,5) and strat_tasks.task_due < sysdate",nativeQuery = true)
	public List<MytaskPastInfo> getTaskpastTeamin (String teammembers);
}


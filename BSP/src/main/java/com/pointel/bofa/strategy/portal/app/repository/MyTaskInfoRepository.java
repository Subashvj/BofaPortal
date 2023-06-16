package com.pointel.bofa.strategy.portal.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MyTaskInfo;

@Repository
public interface MyTaskInfoRepository extends JpaRepository<MyTaskInfo, BigInteger>{

	
	@Query(value = "select strat_tasks.task_id,strat_tasks.strat_id,strat_tasks.task_desc,\r\n"
			+ "to_char(strat_tasks.task_due,'MONRR')as task_due_short,strat_tasks.task_due,strategies.strat_name \r\n"
			+ "from strat_tasks\r\n"
			+ "inner join strategies on strat_tasks.strat_id=strategies.strat_id\r\n"
			+ "where strat_tasks.task_status_id not in (4,5)\r\n"
			+ "and strat_tasks.assigned_to=?1\r\n"
			+ "order by strat_tasks.task_due asc",  nativeQuery = true)
	public List<MyTaskInfo> getMyTaskInfo(String username);
	

	
}

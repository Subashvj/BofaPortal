package com.pointel.bofa.strategy.portal.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.dto.TasksInfo;

@Repository
public interface MyTasksRepository extends JpaRepository<TasksInfo,Integer>{
	
	@Query(value = "select strat_tasks.task_id, strat_tasks.task_desc,\r\n"
			+ "to_char(strat_tasks.task_start,'mm/dd') as task_start_f, to_char(strat_tasks.task_due,'mm/dd') as task_due_f,\r\n"
			+ "strat_tasks.task_start, strat_tasks.task_due, strat_tasks.task_percent, strat_task_status.task_status_desc,\r\n"
			+ "users.displayname, task_milestones.milestone_desc, strat_tasks.task_status_id, strat_tasks.milestone_id,\r\n"
			+ "(strat_tasks.task_due - strat_tasks.task_start)+1 as busdays,\r\n"
			+ "(100*(sysdate - strat_tasks.task_start)/((strat_tasks.task_due - strat_tasks.task_start)+1)) as shouldbe,\r\n"
			+ "strat_phase_id, assigned_to, task_notes, c.displayname as assignedby, c.userid as curassignby\r\n"
			+ "from strat_tasks\r\n"
			+ "inner join strat_task_status on strat_tasks.task_status_id = strat_task_status.task_status_id\r\n"
			+ "inner join users on strat_tasks.assigned_to = users.userid\r\n"
			+ "inner join users c on strat_tasks.assigned_by = c.userid\r\n"
			+ "left join task_milestones on strat_tasks.milestone_id = task_milestones.milestone_id\r\n"
			+ "where strat_tasks.strat_id = ?1 and strat_tasks.task_status_id <>5\r\n"
			+ "order by task_due, task_start, task_due",  nativeQuery = true)
	public List<TasksInfo> getTaskInfo(int startId);

}

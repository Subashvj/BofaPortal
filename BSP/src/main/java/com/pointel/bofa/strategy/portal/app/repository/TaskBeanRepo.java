package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.TaskBean;

public interface TaskBeanRepo extends JpaRepository<TaskBean, Integer> {
	
	@Query(nativeQuery = true , value = "SELECT strat_tasks.strat_id, strat_tasks.task_desc, strat_tasks.task_start, strat_tasks.task_due, strat_tasks.task_percent, strat_tasks.task_status_id, strat_tasks.assigned_to, assignedto.displayname as assignedtoname, assignedby.displayname as assignedbyname, strat_tasks.assigned_by, assignedby.displayname, strat_tasks.add_date, strat_tasks.last_update, strat_tasks.milestone_id, strat_tasks.task_notes, strat_tasks.strat_phase_id From strat_tasks inner join users assignedto on strat_tasks.assigned_to = assignedto.userid inner join users assignedby on strat_tasks.assigned_by = assignedby.userid WHERE strat_tasks.task_id = 101")
		List<TaskBean> retrieveTaskBeanData(int stratId);

}

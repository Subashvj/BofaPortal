package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallationTasks;

@Repository
public interface InstallationTasksRepository extends JpaRepository<InstallationTasks,Integer>{

	@Query(value="select installs.install_id, installs.install_title, installs.install_date, installs.install_end,\r\n"
			+ "strategies.strat_id, strategies.strat_name, strat_tasks.task_id, strat_tasks.task_desc,\r\n"
			+ "strat_tasks.task_start, strat_tasks.task_due, strat_tasks.task_percent, strat_task_status.task_status_desc,\r\n"
			+ "users.displayname, strat_tasks.last_update, task_milestones.milestone_desc, strat_tasks.task_notes,\r\n"
			+ "strat_tasks.task_status_id,\r\n"
			+ "case when strat_tasks.task_due < trunc(sysdate) then 1 else 0 end as pastdue,\r\n"
			+ "case when strat_tasks.task_start <= trunc(sysdate) then 1 else 0 end as started,\r\n"
			+ "to_char(strat_tasks.task_start,'mm/dd') as task_start_f, to_char(strat_tasks.task_due,'mm/dd') as task_due_f,\r\n"
			+ "(strat_tasks.task_due - strat_tasks.task_start)+1 as busdays,\r\n"
			+ "(100*(sysdate - strat_tasks.task_start)/((strat_tasks.task_due - strat_tasks.task_start)+1)) as shouldbe\r\n"
			+ "from installs\r\n"
			+ "inner join strat_to_install on installs.install_id = strat_to_install.install_id\r\n"
			+ "inner join strategies on strat_to_install.strat_id = strategies.strat_id\r\n"
			+ "inner join strat_tasks on strategies.strat_id = strat_tasks.strat_id\r\n"
			+ "inner join strat_task_status on strat_tasks.task_status_id = strat_task_status.task_status_id\r\n"
			+ "inner join users on strat_tasks.assigned_to = users.userid\r\n"
			+ "left join task_milestones on strat_tasks.milestone_id = task_milestones.milestone_id\r\n"
			+ "where installs.install_id = ?1 and strat_tasks.task_status_id <> 5\r\n"
			+ "order by strat_tasks.task_start asc, strat_tasks.task_due asc, strat_to_install.strat_id asc",nativeQuery=true)
	public List<InstallationTasks> getInstallTasksInfo(int installId);
}

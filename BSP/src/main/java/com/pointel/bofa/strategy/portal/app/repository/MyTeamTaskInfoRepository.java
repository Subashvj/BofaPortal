package com.pointel.bofa.strategy.portal.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskInfo;

@Repository
public interface MyTeamTaskInfoRepository extends JpaRepository<MyTeamTaskInfo, BigInteger> {

	@Query(value="select strat_tasks.task_id,strat_tasks.strat_id,strat_tasks.task_desc,\r\n"
			+ "to_char(strat_tasks.task_due,'MONRR') as task_due_short,\r\n"
			+ "strat_tasks.task_due,users.userid,users.displayname,\r\n"
			+ "nvl(users.nickname,regexp_substr(users.displayname,'/',1)) as shortname,\r\n"
			+ "strat_tasks.task_percent,strat_tasks.last_update,strategies.strat_name\r\n"
			+ "from strat_tasks\r\n"
			+ "inner join users on strat_tasks.assigned_to=users.userid\r\n"
			+ "inner join strategies on strat_tasks.strat_id=strategies.strat_id\r\n"
			+ "where\r\n"
			+ "strat_tasks.assigned_to In (?1) and\r\n"
			+ "strat_tasks.task_status_id not in (4,5) and\r\n"
			+ "users.mgrid=?2\r\n"
			+ "order by strat_tasks.task_due asc",nativeQuery = true)
	public List<MyTeamTaskInfo> retriveMyTeamTask(String users,String username);
	
	
	
}

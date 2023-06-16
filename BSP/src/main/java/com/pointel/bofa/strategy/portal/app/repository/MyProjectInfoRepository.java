package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MyProjectInfo;

@Repository
public interface MyProjectInfoRepository extends JpaRepository<MyProjectInfo,Integer>{

	@Query(value="select a.strat_id,a.strat_name,a.strat_color,gg.strat_phase_desc , to_char(a2.full_deploy,'mm/dd/yyyy') as fullDeploy,strt_roles.role_desc,\r\n"
			+ "			strat_status_descriptions.strat_status_desc,tottasks as taskcount from strategies a\r\n"
			+ "			left join( select strat_tasks.strat_id, count(strat_tasks.task_id) as tottasks from strat_tasks\r\n"
			+ "			where strat_tasks.assigned_to = 'aaa' and strat_tasks.task_status_id <> 5\r\n"
			+ "			group by strat_tasks.strat_id\r\n"
			+ "			)strat_tasks on a.strat_id = strat_tasks.strat_id\r\n"
			+ "			inner join strat_members on a.strat_id=strat_members.strat_id\r\n"
			+ "			inner join strat_members b on a.strat_id=b.strat_id\r\n"
			+ "			inner join users on b.username = users.userid\r\n"
			+ "			inner join strat_roles on b.role_id = strat_roles.role_id\r\n"
			+ "			inner join strat_roles strt_roles on b.role_id = strt_roles.role_id\r\n"
			+ "			inner join strat_priority on a.strat_id = strat_priority.strat_id\r\n"
			+ "			inner join strat_status_descriptions on a.strat_status_id = strat_status_descriptions.strat_status_id\r\n"
			+ "			inner join strategies2 a2 on a.strat_id = a2.strat_id\r\n"
			+ "			inner join( select a.strat_id,b.strat_phase_desc from strat_phase_history a\r\n"
			+ "			inner join strat_phases b on a.strat_phase_id=b.strat_phase_id\r\n"
			+ "			inner join( select strat_phase_history.strat_id,\r\n"
			+ "			max(strat_phase_history.strat_phase_history_id) as lasthist from strat_phase_history\r\n"
			+ "			group by strat_phase_history.strat_id )c on a.strat_phase_history_id=c.lasthist\r\n"
			+ "			)gg on a.strat_id=gg.strat_id, ( select listagg(user_hide_home.strat_id,',') as stratcol\r\n"
			+ "			from user_hide_home where user_hide_home.user_id=?1)ff\r\n"
			+ "			where a.strat_status_id in (3,4)\r\n"
			+ "			and a.strat_status_id not in (2,5) and b.username=?1\r\n"
			+ "			group by a.strat_name, a.strat_id, strat_members.strat_id, strat_members.username, a.strat_color,\r\n"
			+ "			strat_roles.role_desc, gg.strat_phase_desc, strat_status_descriptions.strat_status_desc, strat_priority.priority, strt_roles.role_desc,\r\n"
			+ "			a2.full_deploy, users.displayname, tottasks, strat_status_descriptions.strat_status_short, a.strat_status_id",nativeQuery = true)
public List<MyProjectInfo> retriveMyProjectInfo(String userId);
			
@Query(value="select a.strat_id,a.strat_name,a.strat_color,gg.strat_phase_desc , to_char(a2.full_deploy,'mm/dd/yyyy') as fullDeploy,strt_roles.role_desc,\r\n"
		+ "strat_status_descriptions.strat_status_desc,tottasks as taskcount from strategies a\r\n"
		+ "left join( select strat_tasks.strat_id, count(strat_tasks.task_id) as tottasks from strat_tasks\r\n"
		+ "where strat_tasks.assigned_to = ?1 and strat_tasks.task_status_id <> 5\r\n"
		+ "group by strat_tasks.strat_id\r\n"
		+ ")strat_tasks on a.strat_id = strat_tasks.strat_id\r\n"
		+ "inner join strat_members on a.strat_id=strat_members.strat_id\r\n"
		+ "inner join strat_members b on a.strat_id=b.strat_id\r\n"
		+ "inner join users on b.username = users.userid\r\n"
		+ "inner join strat_roles on b.role_id = strat_roles.role_id\r\n"
		+ "inner join strat_roles strt_roles on b.role_id = strt_roles.role_id\r\n"
		+ "inner join strat_priority on a.strat_id = strat_priority.strat_id\r\n"
		+ "inner join strat_status_descriptions on a.strat_status_id = strat_status_descriptions.strat_status_id\r\n"
		+ "inner join strategies2 a2 on a.strat_id = a2.strat_id\r\n"
		+ "inner join( select a.strat_id,b.strat_phase_desc from strat_phase_history a\r\n"
		+ "inner join strat_phases b on a.strat_phase_id=b.strat_phase_id\r\n"
		+ "inner join( select strat_phase_history.strat_id,\r\n"
		+ "max(strat_phase_history.strat_phase_history_id) as lasthist from strat_phase_history\r\n"
		+ "group by strat_phase_history.strat_id )c on a.strat_phase_history_id=c.lasthist\r\n"
		+ ")gg on a.strat_id=gg.strat_id, ( select listagg(user_hide_home.strat_id,',') as stratcol\r\n"
		+ "from user_hide_home where user_hide_home.user_id=?1)ff\r\n"
		+ "where a.strat_status_id in (1,3,4)\r\n"
		+ "and a.strat_status_id not in (2,5) and b.username=?1\r\n"
		+ "group by a.strat_name, a.strat_id, strat_members.strat_id, strat_members.username, a.strat_color,\r\n"
		+ "strat_roles.role_desc, gg.strat_phase_desc, strat_status_descriptions.strat_status_desc, strat_priority.priority, strt_roles.role_desc,\r\n"
		+ "a2.full_deploy, users.displayname, tottasks, strat_status_descriptions.strat_status_short, a.strat_status_id", nativeQuery = true)
public List<MyProjectInfo> myProjectInf(String userId);
	

	
}

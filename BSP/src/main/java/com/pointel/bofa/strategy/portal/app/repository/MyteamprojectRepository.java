package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamProjectsInfo;


@Repository
public interface MyteamprojectRepository extends JpaRepository<MyTeamProjectsInfo, Integer>{

	@Query(value="select strat_members.strat_id, strategies.strat_name, strat_members.username, strat_roles.role_desc,\r\n"
			+ "strat_status_descriptions.strat_status_desc,to_char(strategies2.full_deploy,'mm/dd/yyyy')as full_deploy  from strategies\r\n"
			+ "inner join strat_members on strategies.strat_id = strat_members.strat_id\r\n"
			+ "inner join strat_priority on strategies.strat_id = strat_priority.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join strat_roles on strat_members.role_id = strat_roles.role_id\r\n"
			+ "inner join strat_status_descriptions on strategies.strat_status_id = strat_status_descriptions.strat_status_id\r\n"
			+ "where strat_members.username in (?1) and strategies.strat_status_id not in (2,5) and strategies.strat_status_id in (3,4)\r\n"
			+ "group by strat_members.strat_id, strategies.strat_name, strat_members.username, strat_roles.role_desc, strat_status_descriptions.strat_status_desc,\r\n"
			+ "strategies2.full_deploy, strategies.strat_status_id, strat_priority.priority\r\n"
			+ "order by strategies.strat_status_id desc, full_deploy asc, strat_priority.priority asc " , nativeQuery = true)
	public List<MyTeamProjectsInfo> teamprojectinf(String userslist);
}

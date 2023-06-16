package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pointel.bofa.strategy.portal.app.dto.ProjectListInfo;

public interface ProjectListInfoRepo extends JpaRepository<ProjectListInfo, Integer> {

	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id ", nativeQuery = true)
	public List<ProjectListInfo> fetchProjectInfo();

	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by ?#{#pageable}",  countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id) countObj",nativeQuery = true)
	public Page<ProjectListInfo> fetchProjectDetails(Pageable pageable);

	// stratId desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by strat_id desc,?#{#pageable}",  countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by strategies.strat_id desc) countObj",nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratIdDesc(Pageable pageable);

	// stratName desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by strategies.strat_name desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by strategies.strat_name desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratNameDesc(Pageable pageable);

	// lob_desc desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by lobs.lob_desc desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by lobs.lob_desc desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailLobDesDesc(Pageable pageable);

	// strat_status_desc desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id by strat_status.strat_status_desc desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by strat_status.strat_status_desc desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratStatusDesDesc(Pageable pageable);

	// strat_status_id desc
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id order by strat_status.strat_status_id desc", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id order by strat_status.strat_status_id desc) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratStatusIdDesc(Pageable pageable);

	// strat_cat_desc desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by strat_categories.strat_cat_desc desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by strat_categories.strat_cat_desc desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratCatDesDesc(Pageable pageable);

	// displayname desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by pm.displayname desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by pm.displayname desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailDisplayNameDesc(Pageable pageable);

	// target_date desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by strategies.target_date desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by strategies.target_date desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailTargetDateDesc(Pageable pageable);
	
	//Platfrom_Type_Description
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by platform_type.platform_type_description desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by platform_type.platform_type_description desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailPlatformTypeDesc(Pageable pageable);
	
	// install_start desc
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id order by v.install_start desc", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id order by v.install_start desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailInstatllStartDesc(Pageable pageable);

	// instdate desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by target_date desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by target_date desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailInstDateDesc(Pageable pageable);
	
	// component_name desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by tc.component_name desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by tc.component_name desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailComponentNameDesc(Pageable pageable);

	// strat_phase_desc desc
	@Query(value = "SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
			+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
			+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
			+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
			+ "inner join application on strategies.application = application.app_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
			+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
			+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
			+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
			+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
			+ "ORDER BY strat_members.strat_id\r\n"
			+ ") pm on strategies.strat_id = pm.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
			+ "GROUP by strat_to_install.strat_id\r\n"
			+ "ORDER BY strat_to_install.strat_id\r\n"
			+ ") v ON strategies.strat_id = v.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
			+ "FROM strat_to_component\r\n"
			+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
			+ "GROUP BY strat_id\r\n"
			+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
			+ "LEFT JOIN\r\n"
			+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
			+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
			+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
			+ ") phases ON strategies.strat_id = phases.strat_id order by phases.strat_phase_desc desc,?#{#pageable}", countQuery = "SELECT count(*) FROM (SELECT DISTINCT strategies.strat_id as strat_id,strategies.strat_name as strat_name,strat_status.strat_status_desc as strat_status_desc,\r\n"
					+ "strat_categories.strat_cat_desc as strat_cat_desc,application.application_name,to_char(strategies.target_date,'mm/dd/yyyy') as target_date,\r\n"
					+ "to_char(strategies2.full_deploy,'mm/dd/yyyy') as full_deploy,\r\n"
					+ "lobs.lob_desc as lob_desc,tc.component_name,phases.strat_phase_desc,platform_type.platform_type_description FROM strategies\r\n"
					+ "inner join application on strategies.application = application.app_id\r\n"
					+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
					+ "inner join strategies2 on strategies.strat_id = strategies2.strat_id\r\n"
					+ "inner join platform_type on strategies.platform_id = platform_type.platform_id\r\n"
					+ "LEFT JOIN lobs ON strategies1.lob_id = lobs.lob_id\r\n"
					+ "INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id\r\n"
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id\r\n"
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members\r\n"
					+ "INNER JOIN users ON strat_members.username = users.userid\r\n"
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id, users.displayname\r\n"
					+ "ORDER BY strat_members.strat_id\r\n"
					+ ") pm on strategies.strat_id = pm.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_install.strat_id, MAX(installs.install_date) as install_start FROM strat_to_install\r\n"
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id\r\n"
					+ "GROUP by strat_to_install.strat_id\r\n"
					+ "ORDER BY strat_to_install.strat_id\r\n"
					+ ") v ON strategies.strat_id = v.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_to_component.strat_id, listagg(tech_components.component_name,', ') component_name\r\n"
					+ "FROM strat_to_component\r\n"
					+ "INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id\r\n"
					+ "GROUP BY strat_id\r\n"
					+ ") tc ON strategies.strat_id = tc.strat_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "( SELECT strat_phase_history.strat_id, strat_phases.strat_phase_desc FROM strat_phase_history\r\n"
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id\r\n"
					+ "GROUP BY strat_phase_history.strat_id, strat_phases.strat_phase_desc\r\n"
					+ "ORDER BY strat_phase_history.strat_phase_updated DESC\r\n"
					+ ") phases ON strategies.strat_id = phases.strat_id order by phases.strat_phase_desc desc) countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratPhaseDesDesc(Pageable pageable);

	// instdate < before
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) < ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) < ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailInstDateBefore(String date, Pageable pageable);

	// instdate > after
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) > ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) > ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailInstDateAfter(String date, Pageable pageable);

	// instdate = on
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) = ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where ifnull(v.install_start,strategies.target_date) = ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailInstDateOn(String date, Pageable pageable);

	// strat_id < lessthan
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id < ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id < ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratIdLessThan(String stratId, Pageable pageable);

	// strat_id > greaterthan
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id > ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id > ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratIdGreaterThan(String stratId, Pageable pageable);

	// strat_id = equalsTo
	@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
			+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
			+ "strat_status.strat_status_id as strat_status_id, "
			+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
			+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
			+ "phases.strat_phase_desc FROM strategies "
			+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
			+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
			+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
			+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
			+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
			+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
			+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
			+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
			+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
			+ ") tc ON strategies.strat_id = tc.strat_id "
			+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
			+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
			+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
			+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id = ?1", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
					+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
					+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
					+ "strat_status.strat_status_id as strat_status_id, "
					+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
					+ "strategies.target_date, "
					+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
					+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
					+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
					+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
					+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
					+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
					+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
					+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
					+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
					+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
					+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
					+ ") tc ON strategies.strat_id = tc.strat_id "
					+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
					+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
					+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
					+ ") phases ON strategies.strat_id = phases.strat_id where strategies.strat_id = ?1) AS countObj", nativeQuery = true)
	public Page<ProjectListInfo> fetchProjDetailStratIdEqualsTo(String stratId, Pageable pageable);

	    // strat_name filter
		@Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
				+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
				+ "strat_status.strat_status_id as strat_status_id, "
				+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " + "strategies.target_date, "
				+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, " + "tc.component_name, "
				+ "phases.strat_phase_desc FROM strategies "
				+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
				+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
				+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
				+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
				+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
				+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
				+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
				+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
				+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
				+ ") tc ON strategies.strat_id = tc.strat_id "
				+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
				+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
				+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
				+ ") phases ON strategies.strat_id = phases.strat_id where LOWER(strategies.strat_name) LIKE CONCAT('%', ?1, '%') "
				+ "or LOWER(lobs.lob_desc) LIKE CONCAT('%', ?1, '%') or LOWER(strat_status.strat_status_desc) LIKE CONCAT('%', ?1, '%') "
				+ "or LOWER(strat_categories.strat_cat_desc) LIKE CONCAT('%', ?1, '%') or LOWER(pm.displayname) LIKE CONCAT('%', ?1, '%') "
				+ "or LOWER(tc.component_name) LIKE CONCAT('%', ?1, '%') or LOWER(phases.strat_phase_desc) LIKE CONCAT('%', ?1, '%')", countQuery = "SELECT count(*) FROM (SELECT DISTINCT "
						+ "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
						+ "lobs.lob_desc as lob_desc, " + "strat_status.strat_status_desc as strat_status_desc, "
						+ "strat_status.strat_status_id as strat_status_id, "
						+ "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, "
						+ "strategies.target_date, "
						+ "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
						+ "tc.component_name, " + "phases.strat_phase_desc FROM strategies "
						+ "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
						+ "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
						+ "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
						+ "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
						+ "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
						+ "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
						+ "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
						+ "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
						+ "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
						+ ") tc ON strategies.strat_id = tc.strat_id "
						+ "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
						+ "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
						+ "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
						+ ") phases ON strategies.strat_id = phases.strat_id where LOWER(strategies.strat_name) LIKE CONCAT('%', ?1, '%') "
						+ "or LOWER(lobs.lob_desc) LIKE CONCAT('%', ?1, '%') or LOWER(strat_status.strat_status_desc) LIKE CONCAT('%', ?1, '%') "
						+ "or LOWER(strat_categories.strat_cat_desc) LIKE CONCAT('%', ?1, '%') or LOWER(pm.displayname) LIKE CONCAT('%', ?1, '%') "
						+ "or LOWER(tc.component_name) LIKE CONCAT('%', ?1, '%') or LOWER(phases.strat_phase_desc) LIKE CONCAT('%', ?1, '%') ) AS countObj", nativeQuery = true)
		public Page<ProjectListInfo> fetchSearchFilter(String stratName, Pageable pageable);

		
		//stratName filter
		 @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
				  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
				  "strat_status.strat_status_desc as strat_status_desc, " +
				  "strat_status.strat_status_id as strat_status_id, " +
				  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
				  "strategies.target_date, " +
				  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
				  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
				  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
				  +
				  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
				  +
				  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
				  +
				  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
				  +
				  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
				  +
				  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
				  +
				  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
				  +
				  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
				  +
				  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
				  + ") tc ON strategies.strat_id = tc.strat_id " +
				  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
				  +
				  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
				  +
				  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
				  +
				  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strategies.strat_name) like CONCAT('%', ?1, '%') "
				  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
				  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
				  + "lobs.lob_desc as lob_desc, " +
				  "strat_status.strat_status_desc as strat_status_desc, " +
				  "strat_status.strat_status_id as strat_status_id, " +
				  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
				  "strategies.target_date, " +
				  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
				  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
				  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
				  +
				  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
				  +
				  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
				  +
				  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
				  +
				  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
				  +
				  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
				  +
				  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
				  +
				  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
				  +
				  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
				  + ") tc ON strategies.strat_id = tc.strat_id " +
				  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
				  +
				  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
				  +
				  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
				  +
				  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strategies.strat_name) like CONCAT('%', ?1, '%') ) AS countObj"
				  , nativeQuery = true) public Page<ProjectListInfo> fetchStratNameFilter(String
				  lobDesc, Pageable pageable);
		
		
		  // lob_desc = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(lobs.lob_desc) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(lobs.lob_desc) like CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo> fetchLobDescFilter(String
		  lobDesc, Pageable pageable);
		  
		  // strat_status_desc = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strat_status.strat_status_desc) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strat_status.strat_status_desc) like CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo>
		  fetchStratStatusDescFilter(String stratStatusDesc, Pageable pageable);
		  
		  // strat_cat_desc = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strat_categories.strat_cat_desc) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(strat_categories.strat_cat_desc) LIKE CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo>
		  fetchStratCatDescFilter(String stratCatDesc, Pageable pageable);
		  
		  // displayname = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(pm.displayname) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(pm.displayname) like CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo>
		  fetchDisplayNameFilter(String stratCatDesc, Pageable pageable);
		  
		  // componentName = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(tc.component_name) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(tc.component_name) like CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo>
		  fetchComponentNameFilter(String stratCatDesc, Pageable pageable);
		  
		  // stratphasedesc = filter
		  
		  @Query(value = "SELECT DISTINCT " + "strategies.strat_id as strat_id, " +
		  "strategies.strat_name as strat_name, " + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(phases.strat_phase_desc) like CONCAT('%', ?1, '%') "
		  , countQuery = "SELECT count(*) FROM (SELECT DISTINCT " +
		  "strategies.strat_id as strat_id, " + "strategies.strat_name as strat_name, "
		  + "lobs.lob_desc as lob_desc, " +
		  "strat_status.strat_status_desc as strat_status_desc, " +
		  "strat_status.strat_status_id as strat_status_id, " +
		  "strat_categories.strat_cat_desc as strat_cat_desc, " + "pm.displayname, " +
		  "strategies.target_date, " +
		  "v.install_start, ifnull(v.install_start,strategies.target_date) as instdate, "
		  + "tc.component_name, " + "phases.strat_phase_desc FROM strategies " +
		  "LEFT JOIN lobs ON strategies.lob_id = lobs.lob_id INNER JOIN strat_status ON strategies.strat_status_id = strat_status.strat_status_id "
		  +
		  "INNER JOIN strat_categories ON strategies.strat_category = strat_categories.strat_cat_id "
		  +
		  "Left JOIN ( SELECT strat_members.strat_id, users.displayname FROM strat_members INNER JOIN users ON strat_members.username = users.userid "
		  +
		  "WHERE strat_members.role_id = 1 GROUP By strat_members.strat_id ORDER BY strat_members.strat_id) pm on strategies.strat_id = pm.strat_id "
		  +
		  "LEFT JOIN ( SELECT strat_to_install.strat_id, MAX(installs.install_start) as install_start FROM strat_to_install "
		  +
		  "INNER JOIN installs ON strat_to_install.install_id = installs.install_id GROUP by strat_to_install.strat_id "
		  +
		  "ORDER BY strat_to_install.strat_id ) v ON strategies.strat_id = v.strat_id "
		  +
		  "LEFT JOIN( SELECT strat_to_component.strat_id, GROUP_CONCAT(tech_components.component_name SEPARATOR ', ') component_name "
		  +
		  "FROM strat_to_component INNER JOIN tech_components ON strat_to_component.component_id = tech_components.component_id GROUP BY strat_id "
		  + ") tc ON strategies.strat_id = tc.strat_id " +
		  "LEFT JOIN ( SELECT strat_phase_history.strat_id,strat_phases.strat_phase_desc FROM strat_phase_history "
		  +
		  "INNER JOIN strat_phases ON strat_phase_history.strat_phase_id = strat_phases.strat_phase_id "
		  +
		  "GROUP BY strat_phase_history.strat_id ORDER BY strat_phase_history.strat_phase_updated DESC "
		  +
		  ") phases ON strategies.strat_id = phases.strat_id where LOWER(phases.strat_phase_desc) like CONCAT('%', ?1, '%') ) AS countObj"
		  , nativeQuery = true) public Page<ProjectListInfo>
		  fetchStratPhaseFilter(String stratCatDesc, Pageable pageable);
		 
				
}

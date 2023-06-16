package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallationOverview;

@Repository
public interface InstallationOverviewRepository extends JpaRepository<InstallationOverview,Integer>{
	
	@Query(value = "select installs.install_id,installs.install_date, installs.install_end, installs.install_title,\r\n"
			+ "installs.install_owner, status.status_desc, users.displayname As owner,\r\n"
			+ "installs.install_status_id, installs.install_type, installs.create_date,\r\n"
			+ "installs.install_laststatus, users.displayname, install_statuses.install_status_desc,\r\n"
			+ "install_types.install_type_desc, estimate_groups.group_name,\r\n"
			+ "nvl(installs.install_ownergroup,0) as install_ownergroup,\r\n"
			+ "nvl(i.totallinked,0) as totallinked,\r\n"
			+ "install_environments.inst_environment, installs.inst_env_id, installs.cab_num, installs.cab_status,\r\n"
			+ "installs.cab_approval_date, cab_status.cab_status_description, installs.vacob_bundle, installs.bundle_name\r\n"
			+ "from installs\r\n"
			+ "inner join users on installs.install_owner = users.userid\r\n"
			+ "inner join install_statuses on installs.install_status_id = install_statuses.install_status_id\r\n"
			+ "inner join status on installs.install_status_id = status.status_id\r\n"
			+ "inner join cab_status on installs.cab_status = cab_status.cab_status\r\n"
			+ "inner join install_types on installs.install_type = install_types.install_type\r\n"
			+ "left join estimate_groups on installs.install_ownergroup = estimate_groups.estimate_grp\r\n"
			+ "left join(\r\n"
			+ "select strat_to_install.strat_id,\r\n"
			+ "count(strat_to_install.strat_id) as totallinked from strat_to_install\r\n"
			+ "group by strat_to_install.install_id, strat_to_install.strat_id\r\n"
			+ "-- AS i on installs.install_id= i.install_id\r\n"
			+ ") i on installs.install_id=install_id\r\n"
			+ "inner join install_environments on installs.inst_env_id = install_environments.inst_env_id\r\n"
			+ "where installs.install_id = ?1",  nativeQuery = true)
	public List<InstallationOverview> getInstallationOverviewInfo(int installId);
}

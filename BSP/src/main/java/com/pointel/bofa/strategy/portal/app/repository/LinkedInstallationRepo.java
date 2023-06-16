package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.LinkedInstallation;

public interface LinkedInstallationRepo extends JpaRepository<LinkedInstallation, Integer> {
	
	

	@Query(nativeQuery = true,value = "select DISTINCT install_to_file.install_id, "
			+ "installs.install_title, install_environments.inst_environment, "
			+ "to_char (TO_DATE(installs.install_date,'YYYY-MM-DD')) as instdate,"
			+ " to_char (TO_DATE(installs.install_date,'YYYY-MM-DD')) as instdate2 "
			+ "from file_to_strat "
			+ "inner join install_to_file on file_to_strat.file_id = install_to_file.file_id "
			+ "inner join installs on install_to_file.install_id = installs.install_id "
			+ "inner join install_environments on installs.inst_env_id = install_environments.inst_env_id "
			+ "where file_to_strat.strat_id = ?1 "
			+ "union select distinct strat_to_install.install_id, "
			+ "installs.install_title, install_environments.inst_environment, "
			+ "to_char (TO_DATE(installs.install_date,'YYYY-MM-DD')) as instdate, "
			+ "to_char (TO_DATE(installs.install_date,'YYYY-MM-DD')) as instdate2 "
			+ "from strat_to_install inner join installs on strat_to_install.install_id = installs.install_id "
			+ "inner join install_environments on installs.inst_env_id = install_environments.inst_env_id "
			+ "where strat_to_install.strat_id = ?1")
	List<LinkedInstallation> retrieveLinkedInstallationData(int stratId);

}

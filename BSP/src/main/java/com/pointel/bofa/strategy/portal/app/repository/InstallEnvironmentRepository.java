package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallEnvironmentInfo;

@Repository
public interface InstallEnvironmentRepository extends JpaRepository<InstallEnvironmentInfo, Integer>{
	@Query(value="select install_environments.inst_env_id,\r\n"
			+ "install_environments.inst_environment\r\n"
			+ "from install_environments\r\n"
			+ "where\r\n"
			+ "install_environments.inst_env_visible=1\r\n"
			+ "order by\r\n"
			+ "install_environments.inst_environment asc",nativeQuery = true)
	List<InstallEnvironmentInfo> environmentInfo();

}

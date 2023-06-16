package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.entity.InstallEnvironments;

@Repository
public interface InstalltionsEnvironmentsInfoRepo extends JpaRepository<InstallEnvironments,Integer>{
	
	
	/*
	 * @Query(name="select install_environments.inst_env_id as value,\r\n" +
	 * "install_environments.inst_environment as text from install_environments \r\n"
	 * + "where install_environments.inst_env_visible = 1\r\n" +
	 * "order by install_environments.inst_environment",nativeQuery=true)
	 */ public List<InstallEnvironments> findByInstEnvVisible(int instEnvVisible); 
}

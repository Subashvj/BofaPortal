package com.pointel.bofa.strategy.portal.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallCallInfo;

@Repository
public interface InstallCallInfoRepo extends JpaRepository<InstallCallInfo, Integer> {
	
	@Query(value = "SELECT installs.install_id as id,installs.install_title as title,"
			+ " installs.install_date as inststart,CONCAT('inst_manage.php?inst_id=',installs.install_id) as url"
			+ " from installs WHERE"
			+ " installs.install_date >= TO_DATE(?1,'YYYY-MM-DD') AND"
			+ " installs.install_date <= TO_DATE(?2,'YYYY-MM-DD')",nativeQuery = true)
	List<InstallCallInfo> retrieveInstallCallInfoData(String startDate,String endDate);
	
	@Query(value = "SELECT installs.install_id as id,installs.install_title as title,"
			+ " installs.install_date as inststart,CONCAT('inst_manage.php?inst_id=',installs.install_id) as url"
			+ " from installs WHERE"
			+ " installs.install_date >= '02-Jan-2022' AND"
			+ " installs.install_date <= '01-Feb-2022'",nativeQuery = true)
	public List<InstallCallInfo> retrieveInstallCallInfoData1();
	

}

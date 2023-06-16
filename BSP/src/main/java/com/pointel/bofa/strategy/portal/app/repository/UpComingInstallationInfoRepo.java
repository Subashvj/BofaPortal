package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.UpComingInstallationInfo;

@Repository
public interface UpComingInstallationInfoRepo extends JpaRepository<UpComingInstallationInfo, Integer> {

	@Query(value = "select installs.install_id,installs.install_title, to_char(installs.INSTALL_DATE,'MONRR') as install_start,install_types.install_type_desc_short\r\n"
			+ "from installs inner join install_types on installs.install_type=install_types.install_type \r\n"
			+ "where (installs.install_end >= sysdate or\r\n"
			+ "(installs.INSTALL_DATE <= sysdate and (installs.install_end is null)))\r\n"
			+ "and rownum<= 6 and installs.install_status_id <> 4\r\n"
			+ "order by installs.INSTALL_DATE asc" ,nativeQuery = true)
	public List<UpComingInstallationInfo> getUpComingInsatallations();
	
	
}

package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.CurrentInstallationId;


@Repository
public interface CurrentInstallationIdRepo extends JpaRepository<CurrentInstallationId, String>{
	
	@Query(value = "select \r\n"
			+ "listagg(strat_to_install.install_id,',') as install_Id from strat_to_install \r\n"
			+ "where strat_to_install.strat_id=?1",nativeQuery=true)
	CurrentInstallationId retrieveCurrentInstallationId(int stratId);
	
	
}

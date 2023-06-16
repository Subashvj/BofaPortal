package com.pointel.bofa.strategy.portal.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.StratToInstall;


@Repository
public interface DeleteStratToInstallRepository extends JpaRepository<StratToInstall, Integer>{

	@Modifying
	@Transactional
	@Query(value = "delete from strat_to_install WHERE strat_id=?1 AND install_id=?2",nativeQuery = true)
	public void deleteUpdateInstalltionInfo(int stratId,int installId);

}

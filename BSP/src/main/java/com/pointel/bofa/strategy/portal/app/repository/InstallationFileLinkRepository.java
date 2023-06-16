package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.InstallationFileLink;

@Repository
public interface InstallationFileLinkRepository extends JpaRepository<InstallationFileLink,Integer>{
	
}

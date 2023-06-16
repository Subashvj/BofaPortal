package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.Artifacts;


@Repository
public interface ArtifactsRepo extends JpaRepository<Artifacts,Integer>{
	
	

}

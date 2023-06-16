package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.ArtifactUser;


@Repository
public interface ArtifactUserRepo extends JpaRepository<ArtifactUser,Integer>{
	
	
	
	ArtifactUser findByArtifactIdAndArtifactUser(int artifactId,String artifactUser);

}

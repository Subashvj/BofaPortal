package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointel.bofa.strategy.portal.app.entity.ArtifactToComponent;
import com.pointel.bofa.strategy.portal.app.entity.ArtifactToComponentPk;

public interface ArtifactToComponentRepo extends JpaRepository<ArtifactToComponent,ArtifactToComponentPk>{

}

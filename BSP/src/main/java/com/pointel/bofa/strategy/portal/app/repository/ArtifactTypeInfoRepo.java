package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.dto.ArtifactTypeInfo;

@Repository
public interface ArtifactTypeInfoRepo extends JpaRepository<ArtifactTypeInfo,Integer> {
	
	
	@Query(value ="select artifact_types.artifact_type_id , artifact_types.artifact_type_desc"
			+ " from artifact_types"
			+ " where artifact_types.artifact_visible = 1"
			+ " order by artifact_type_desc asc", nativeQuery = true)
	public List<ArtifactTypeInfo> getArtifactTypeInfo();
	
	
	@Query(value ="select artifact_types.artifact_type_id , artifact_types.artifact_type_desc"
			+ " from artifact_types"
			+ " where artifact_visible = 1 and lower(artifact_type_desc) like concat('%',concat(?1,'%'))"
			+ " order by artifact_type_desc asc", nativeQuery = true)
	public List<ArtifactTypeInfo> getArtifactTypeInfoSuggestion(String keyword);
	
	
	

}

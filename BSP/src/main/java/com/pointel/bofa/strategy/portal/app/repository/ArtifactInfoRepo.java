package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ArtifactInfo;
@Repository
public interface ArtifactInfoRepo extends JpaRepository<ArtifactInfo,Integer>{
	
	
		@Query(value="select artifacts.artifact_id, listagg(tech_components.component_name) as component_names,"
				+ " artifacts.artifact_added, artifacts.artifact_version, artifact_types.artifact_type_desc,"
				+ " to_char(artifacts.artifact_note) as artifact_note from artifacts"
				+ " inner join artifact_to_component on artifacts.artifact_id = artifact_to_component.artifact_id"
				+ " inner join artifact_types on artifacts.artifact_type_id = artifact_types.artifact_type_id"
				+ " inner join tech_components on artifact_to_component.component_id = tech_components.component_id"
				+ " where artifacts.artifact_id = ?1 group by artifacts.artifact_id, artifacts.artifact_added,"
				+ " artifacts.artifact_version, artifact_types.artifact_type_desc, to_char(artifacts.artifact_note)",nativeQuery = true)
		ArtifactInfo getArtifactInfo(int artifactId);
	

}

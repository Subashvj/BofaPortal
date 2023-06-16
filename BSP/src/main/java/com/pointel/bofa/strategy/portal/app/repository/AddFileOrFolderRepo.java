package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.AddFileOrFolder;


@Repository
public interface AddFileOrFolderRepo extends JpaRepository<AddFileOrFolder,Integer>{
	
	@Query(value = "SELECT 0 as artifact_type_id, 'NONE' as artifact_type_desc, 0 as sort_order from dual"
			+ " UNION"
			+ " SELECT artifact_types.artifact_type_id, artifact_types.artifact_type_desc, artifact_types.sort_order"
			+ " FROM artifact_types"
			+ " WHERE artifact_types.artifact_visible = 1"
			+ " ORDER BY sort_order ASC",  nativeQuery = true)
	public List<AddFileOrFolder> getAddFileOrFolder();

	
	@Query(value = "SELECT 0 as artifact_type_id, 'NONE' as artifact_type_desc, 0 as sort_order from dual"
			+ " UNION SELECT artifact_types.artifact_type_id, artifact_types.artifact_type_desc, artifact_types.sort_order"
			+ " FROM artifact_types"
			+ " WHERE artifact_types.artifact_visible = 1 and lower(artifact_types.artifact_type_desc) like concat('%',concat(?1,'%'))"
			+ " ORDER BY sort_order ASC",  nativeQuery = true)
	public List<AddFileOrFolder> getAddFileOrFolderSuggestion(String keyword);
	
	
	
	
	
	
	
}

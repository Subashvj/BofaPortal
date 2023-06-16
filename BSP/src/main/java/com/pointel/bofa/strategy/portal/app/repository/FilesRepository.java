package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.Files;

@Repository
public interface FilesRepository extends JpaRepository<Files,Integer>{
	
	@Query(value = "select attachments.file_att_id,attachments.file_desc,attachments.file_name,attachments.link,\r\n"
			+ "users.displayname as addedby,attachments.added_date,attachments.locked,attachments.folder_id,\r\n"
			+ "trunc(sysdate)- attachments.added_date as age,\r\n"
			+ "nvl(artifact_types.sort_order,0) as sort_order,\r\n"
			+ "nvl(artifact_types.non_public,0) as non_public,\r\n"
			+ "artifact_types.artifact_type_desc,attachments.artifact_id,\r\n"
			+ "strat_files.desc_, strat_files.added from attachments\r\n"
			+ "inner join users on attachments.added_by = users.userid\r\n"
			+ "inner join strat_files on attachments.file_name = strat_files.file_name\r\n"
			+ "left join artifact_types on attachments.folder_id = artifact_types.artifact_type_id\r\n"
			+ "where attachments.file_type = 1 and\r\n"
			+ "attachments.file_visible = 1 and attachments.type_id = ?1\r\n"
			+ "order by non_public,sort_order",  nativeQuery = true)
	public List<Files> getFilesInfo(int typeId);
}

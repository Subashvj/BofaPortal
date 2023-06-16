package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallFilesInfo;
@Repository
public interface InstallFilesRepository extends JpaRepository<InstallFilesInfo, Integer>{
	@Query(value="select attachments.file_att_id, attachments.file_desc, attachments.file_name,\r\n"
			+ "attachments.link, users.displayname as addedby, attachments.added_date\r\n"
			+ "from attachments\r\n"
			+ "inner join users on attachments.added_by = users.userid\r\n"
			+ "where attachments.file_type = 2 and attachments.file_visible = 1\r\n"
			+ "and attachments.type_id = ?1", nativeQuery = true)
List<InstallFilesInfo> filesInfos(int typeId);
}

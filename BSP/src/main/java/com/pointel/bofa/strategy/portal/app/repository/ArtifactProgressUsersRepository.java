package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ArtifactProgressUsers;

@Repository
public interface ArtifactProgressUsersRepository extends JpaRepository<ArtifactProgressUsers,Integer>{
	
	@Query(value = "select users.displayname, artifact_users.artifact_user, artifact_users.artifact_role, artifact_users.artifact_signoff,\r\n"
			+ "to_char(artifact_users.artifact_signoff_date,'mm/dd/yy') as artifact_signoff_date from artifact_users\r\n"
			+ "inner join users on artifact_users.artifact_user = users.userid\r\n"
			+ "where artifact_users.artifact_id = ?1 order by artifact_users.artifact_role, users.displayname",  nativeQuery = true)
	public List<ArtifactProgressUsers> getArtifactProgressUsers(int artifactId);
}

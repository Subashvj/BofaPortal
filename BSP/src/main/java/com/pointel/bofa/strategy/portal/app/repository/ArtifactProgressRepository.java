package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ArtifactProgress;

@Repository
public interface ArtifactProgressRepository extends JpaRepository<ArtifactProgress,Integer>{
	
	@Query(value = "select sum(case when artifact_users.artifact_role = 1 then  1 else 0 end) as required_total,\r\n"
			+ "sum(case when artifact_users.artifact_role = 2 then  1 else 0 end) as optional_total,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 1 and artifact_users.artifact_role = 1 then  1 else 0 end) as required_progress,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 1 and artifact_users.artifact_role = 2 then  1 else 0 end) as optional_progress,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 2 and artifact_users.artifact_role = 1 then  1 else 0 end) as required_cond,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 2 and artifact_users.artifact_role = 2 then  1 else 0 end) as optional_cond,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 3 and artifact_users.artifact_role = 1 then  1 else 0 end) as required_decl,\r\n"
			+ "sum(case when artifact_users.artifact_signoff = 3 and artifact_users.artifact_role = 2 then  1 else 0 end) as optional_decline\r\n"
			+ "from artifact_users\r\n"
			+ "where artifact_users.artifact_id = ?1",  nativeQuery = true)
	public List<ArtifactProgress> getArtifactProgress(int artifactId);
}

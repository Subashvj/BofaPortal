package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ApprovalsCallInfo;
@Repository
public interface ApprovalsInfoRepo extends JpaRepository<ApprovalsCallInfo, Integer> {
	
	@Query(nativeQuery = true , value = "select artifacts.artifact_id,to_char(artifacts.artifact_link) as artifact_link, "
			+ "artifacts.artifact_added, artifacts.artifact_due,artifacts.artifact_active,"
			+ "artifact_types.artifact_type_desc, artifacts.artifact_version,artifacts.strat_id, "
			+ "listagg(tech_components.component_name) as component_names, "
			+ "to_char(artifacts.artifact_due,'MM/DD') as due_short, "
			+ "to_char(artifacts.artifact_added,'MM/DD') as added_short, "
			+ "to_char(artifacts.artifact_note)as artifact_note,artifacts.artifact_type_id, "
			+ "artifact_types.sort_order,artifact_types.non_public "
			+ "from artifacts inner join artifact_types on artifacts.artifact_type_id = artifact_types.artifact_type_id "
			+ "inner join artifact_to_component on artifacts.artifact_id = artifact_to_component.artifact_id "
			+ "inner join tech_components on artifact_to_component.component_id = tech_components.component_id "
			+ "where artifacts.strat_id = ?1 "  //This is a input field.
			+ "group by artifacts.artifact_id, to_char(artifacts.artifact_link), "
			+ "artifacts.artifact_added, artifacts.artifact_due, artifacts.artifact_active, "
			+ "artifact_types.artifact_type_desc, artifacts.artifact_version, artifacts.strat_id, "
			+ "to_char(artifacts.artifact_note), artifacts.artifact_type_id, artifact_types.sort_order, "
			+ "artifact_types.non_public order by component_names, artifact_types.artifact_type_desc, "
			+ "artifacts.artifact_version desc " )
	List<ApprovalsCallInfo> retrieveApprovalsInfoData(int stratId);

}

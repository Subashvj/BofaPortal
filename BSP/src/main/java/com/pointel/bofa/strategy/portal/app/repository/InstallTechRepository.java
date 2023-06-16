package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallTechInfo;
@Repository
public interface InstallTechRepository extends JpaRepository<InstallTechInfo, Integer>{
	@Query(value="select tech_components.component_name, count(strat_to_component.component_id) as tot\r\n"
			+ "from strat_to_install\r\n"
			+ "inner join strat_to_component on strat_to_install.strat_id = strat_to_component.strat_id\r\n"
			+ "inner join tech_components on strat_to_component.component_id = tech_components.component_id\r\n"
			+ "where strat_to_install.install_id = ?1 group by component_name\r\n"
			+ "order by count(strat_to_component.component_id) desc", nativeQuery = true)
	List<InstallTechInfo> techInfos(int installId);

}

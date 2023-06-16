package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
@Repository
public interface TechcomponentsEditRepository extends JpaRepository<TechComponentsEditInfo, Integer>{
	@Query(value="select tech_components.component_id, tech_components.component_name, incl\r\n"
			+ "from tech_components\r\n"
			+ "left join ( select strat_to_component.component_id, '1' as incl from strat_to_component\r\n"
			+ "where strat_to_component.strat_id =?1\r\n"
			+ ")b on  tech_components.component_id = b.component_id\r\n"
			+ "where tech_components.component_visible =1 order by tech_components.component_name asc",nativeQuery = true)
	List<TechComponentsEditInfo> componentsEditinfos (int stratId);

}

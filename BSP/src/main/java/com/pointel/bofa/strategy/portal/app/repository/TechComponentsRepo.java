package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.dto.TechComponents;

@Repository
public interface TechComponentsRepo extends JpaRepository<TechComponents, String>{
	
	@Query(value = "select tech_components.component_name from strat_to_component"
			+ " inner join tech_components on strat_to_component.component_id = tech_components.component_id"
			+ " where strat_to_component.strat_id=?",  nativeQuery = true)
	public List<TechComponents> getComponents(int strat_id);

}

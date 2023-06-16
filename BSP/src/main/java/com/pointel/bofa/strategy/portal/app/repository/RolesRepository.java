package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.RolesInfo;
@Repository
public interface RolesRepository extends JpaRepository<RolesInfo, Integer> {
	@Query(value="  select strat_roles.role_id as value, strat_roles.role_desc as text from strat_roles\r\n"
			+ "where strat_roles.role_visible = 1 order by strat_roles.role_desc asc", nativeQuery = true)
	List<RolesInfo> roles();
	
	@Query(value="select strat_roles.role_id as value, strat_roles.role_desc as text from strat_roles\r\n"
			+ "  where strat_roles.role_visible = 1 and \r\n"
			+ "  lower( strat_roles.role_desc) LIKE CONCAT('%',CONCAT(?1,'%'))\r\n"
			+ "  order by strat_roles.role_desc asc", nativeQuery = true)
	List<RolesInfo> rolesSearch(String searchValue);

}

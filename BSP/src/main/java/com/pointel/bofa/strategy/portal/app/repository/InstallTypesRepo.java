package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.InstallTypes;

@Repository
public interface InstallTypesRepo extends JpaRepository<InstallTypes, Integer>{
@Query(value="select install_types.install_type,\r\n"
		+ "install_types.install_type_desc from install_types",nativeQuery = true)
List<InstallTypes> typesInfos();
}

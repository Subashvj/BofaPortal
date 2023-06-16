package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;

@Repository
public interface LinkedInstallEditRepository extends JpaRepository<LinkedInstalltionEditInfo, Integer>{

	@Query(value = "select installs.install_id, installs.install_title, installs.install_date,\r\n"
			+ "case when b.install_id is null then null else '1' end as incl,\r\n"
			+ "installs.install_status_id, install_types.install_type_desc, b.link_date,\r\n"
			+ "b.displayname, b.install_id as iid from installs\r\n"
			+ "inner join install_types on installs.install_type = install_types.install_type\r\n"
			+ "left join( select '1' as incl, strat_to_install.install_id, strat_to_install.link_date,\r\n"
			+ "users.displayname from strat_to_install\r\n"
			+ "left join users on strat_to_install.link_by = users.userid\r\n"
			+ "where strat_to_install.strat_id = ?1 ) b on installs.install_id = b.install_id\r\n"
			+ "where ( installs.install_status_id = 1 or installs.install_status_id = 2 or\r\n"
			+ "installs.install_status_id = 5 or installs.install_status_id = 6\r\n"
			+ ") or b.install_id is not null order by installs.install_date asc\r\n"
			+ "",nativeQuery = true)
	List<LinkedInstalltionEditInfo>  editInfos (int stratId);
	
}

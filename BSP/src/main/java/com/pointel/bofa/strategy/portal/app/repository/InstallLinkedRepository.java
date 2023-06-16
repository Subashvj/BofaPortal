package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallLinked;

@Repository
public interface InstallLinkedRepository extends JpaRepository<InstallLinked,Integer>{

	@Query(value = "select strat_to_install.install_id, strat_to_install.strat_id, strategies.strat_name,\r\n"
			+ "strat_categories.strat_cat_desc, strat_status.strat_status_desc, strategies.strat_color,\r\n"
			+ "lobs.lob_desc, k.strat_phase_desc, strategies.strat_status_id, hj.pmname,\r\n"
			+ "count(fut.futureinst) futureinst, added.displayname as addedby,\r\n"
			+ "strat_to_install.link_date from strat_to_install\r\n"
			+ "inner join strategies on strat_to_install.strat_id = strategies.strat_id\r\n"
			+ "inner join strategies1 on strategies.strat_id = strategies1.strat_id\r\n"
			+ "inner join strat_categories on strategies.strat_category = strat_categories.strat_cat_id\r\n"
			+ "inner join strat_status on strategies.strat_status_id = strat_status.strat_status_id\r\n"
			+ "inner join lobs on strategies1.lob_id = lobs.lob_id\r\n"
			+ "left join(\r\n"
			+ "select sph.strat_id, sph.strat_phase_id, sp.strat_phase_desc\r\n"
			+ "from strat_phase_history sph\r\n"
			+ "inner join(\r\n"
			+ "select strat_phase_history.strat_id,\r\n"
			+ "max(strat_phase_history.strat_phase_history_id) as strat_phase_history_id\r\n"
			+ "from strat_phase_history group by strat_phase_history.strat_id)\r\n"
			+ "maxx on sph.strat_phase_history_id  = maxx.strat_phase_history_id\r\n"
			+ "left join\r\n"
			+ "strat_phases sp on sph.strat_phase_id = sp.strat_phase_id\r\n"
			+ ")k on strat_to_install.strat_id = k.strat_id\r\n"
			+ "left join\r\n"
			+ "(\r\n"
			+ "select strat_members.strat_id,\r\n"
			+ "LISTAGG(users.displayname,',') as pmname from strat_members\r\n"
			+ "inner join users on strat_members.username = users.userid\r\n"
			+ "where strat_members.role_id in (1,2)\r\n"
			+ "group by strat_members.strat_id\r\n"
			+ ") hj on strategies.strat_id = hj.strat_id\r\n"
			+ "left join(\r\n"
			+ "select distinct strat_to_install.strat_id, '1/' as futureinst from\r\n"
			+ "( select installs.install_date thisinstdate from installs\r\n"
			+ "where installs.install_id = 3147) tttt, strat_to_install\r\n"
			+ "inner join installs on strat_to_install.install_id = installs.install_id\r\n"
			+ "where installs.install_date > tttt.thisinstdate\r\n"
			+ ")fut on strategies.strat_id = fut.strat_id\r\n"
			+ "left join users added on strat_to_install.link_by = added.userid\r\n"
			+ "where strat_to_install.install_id = ?1\r\n"
			+ "group by strat_to_install.strat_id, strat_to_install.install_id, strategies.strat_name, strat_categories.strat_cat_desc, strat_status.strat_status_desc,\r\n"
			+ "strategies.strat_color, lobs.lob_desc, k.strat_phase_desc, strategies.strat_status_id, hj.pmname,\r\n"
			+ "added.displayname, strat_to_install.link_date\r\n"
			+ "order by hj.pmname, strat_status.strat_status_desc",  nativeQuery = true)
	public List<InstallLinked> getInstallLinked(int installId);
}

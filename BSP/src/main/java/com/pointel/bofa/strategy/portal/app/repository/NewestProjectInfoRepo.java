package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.NewestProjectInfo;

@Repository
public interface NewestProjectInfoRepo extends JpaRepository<NewestProjectInfo, Integer>{

	@Query(value="select strategies.strat_id,strategies.strat_name, strategies.strat_added_by as strat_added_by, lobs.lob_desc from strategies\r\n"
			+ "inner join strategies1 on strategies1.strat_id = strategies.strat_id\r\n"
			+ "inner join lobs on strategies1.lob_id=lobs.lob_id\r\n"
			+ "where rownum <= 6 order by strategies.strat_added_by desc", nativeQuery = true)
	public List<NewestProjectInfo> getNewestProjectInfo();
	
	
	
	
}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.LobsInfo;
@Repository
public interface LobsRepository extends JpaRepository<LobsInfo, Integer>{

	@Query(value="select lobs.lob_id as value, lobs.lob_desc as text from lobs\r\n"	+ 
			"where lobs.lob_visible = 1 order by text asc",nativeQuery=true)

	public List<LobsInfo> getLobsList();

}

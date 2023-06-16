package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.Typesinfo;
@Repository
public interface TypesRepo extends JpaRepository<Typesinfo, Integer>{
@Query(value="select strat_categories.strat_cat_id as value, strat_categories.strat_cat_desc as text\r\n"
		+ "from strat_categories order by text asc",nativeQuery = true)
List<Typesinfo> typesinfos();
}

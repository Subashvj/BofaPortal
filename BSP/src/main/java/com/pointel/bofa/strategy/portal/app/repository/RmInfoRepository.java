package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.Rminfo;
@Repository
public interface RmInfoRepository extends JpaRepository<Rminfo, Integer>{
	@Query (value="select strategies.execview, strategies.priorityhide, strategies2.auto_survey, strategies2.selfaudit from strategies2 \r\n"
			+ "inner join strategies on strategies2.strat_id = strategies.strat_id\r\n"
			+ "where strategies2.strat_id =?1", nativeQuery = true)
	List<Rminfo> rmInfo(int stratId);

}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.HistoryInfo;
@Repository
public interface HistoryInfoRepo  extends JpaRepository<HistoryInfo, String>{
	@Query(value="select strat_history.hist_id, strat_history.fdate, strat_comments.fdate as consumer_fdate,\r\n"
			+ "to_char(strat_history.fdate,'mm/dd') as ffdate, to_char(strat_history.fdate,'mm/dd') as fydate,\r\n"
			+ "users.displayname, strat_history.new_status_id, strat_history.comment_, strat_comments.comment_ as consumer_comment,\r\n"
			+ "strat_history.analyst_include from strat_history\r\n"
			+ "inner join users on strat_history.userid = users.userid\r\n"
			+ "inner join strat_comments on strat_history.strat_id = strat_comments.strat_id\r\n"
			+ "where strat_history.public_ = 1 and strat_comments.public_ = 1 and \r\n"
			+ "strat_history.strat_id = ?1 and strat_comments.strat_id = ?1\r\n"
			+ "order by strat_history.fdate asc, strat_comments.fdate asc" ,nativeQuery = true)
	
	List<HistoryInfo> historyinfos(int stratId);
	
}

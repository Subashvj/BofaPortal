package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallHistoryInfo;
@Repository
public interface InstallHistoryRepository extends JpaRepository<InstallHistoryInfo, Integer>{
	@Query(value="select install_history.hist_id, install_history.fdate,\r\n"
			+ "to_char(install_history.fdate,'mm/dd/yy') as fydate,\r\n"
			+ "users.displayname, install_history.new_status_id,install_history.comment_\r\n"
			+ " from install_history\r\n"
			+ "inner join users on install_history.userid = users.userid\r\n"
			+ "where install_history.public_ = 1 and install_history.install_id = ?1\r\n"
			+ "order by install_history.fdate asc",nativeQuery = true)
	List<InstallHistoryInfo> historyInfos(int installId);
	

}

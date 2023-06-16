package com.pointel.bofa.strategy.portal.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.ProjectCalInfo;

public interface ProjectCalInfoRepo extends JpaRepository<ProjectCalInfo, Integer> {
	
	@Query(value = "SELECT whosout.out_id as id, users.displayname as title ,"
			+ "whosout.whodate as startdate,whosout.outlen, users.userid, "
			+ "'\\' as enddate, whosout.outtype,"
			+ "CASE	"
			+ "WHEN whosout.outtype = '1\' THEN '#5cb85c\'"
			+ "WHEN whosout.outtype = '7\' THEN '#d9534f\'"
			+ "WHEN whosout.outtype = '3\' THEN '#5bc0de\'"
			+ "WHEN whosout.outtype = '8\' THEN '#337ab7\'"
			+ "ELSE '#77777\'"
			+ "END as color FROM whosout "
			+ "INNER JOIN users ON whosout.userid = users.userid "
			+ "WHERE whosout.whodate >= TO_DATE(?1,'YYYY-MM-DD') AND whosout.whodate <= TO_DATE(?2,'YYYY-MM-DD') AND	"
			+ "users.active = 1 "
			+ "ORDER BY whosout.outlen, whosout.outtype", nativeQuery = true)
	public List<ProjectCalInfo> retrieveProjectCalData(String startData , String endDate);

}

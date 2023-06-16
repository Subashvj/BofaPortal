package com.pointel.bofa.strategy.portal.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.UserCalInfo;

public interface UserCalInfoRepo extends JpaRepository<UserCalInfo, Integer>{
	
	@Query(value = "SELECT whosout.out_id as id,users.displayname as title,whosout.whodate as startdate,whosout.outlen,users.userid,"
			+ " '\\' as end,'\\' as edit,whosout.outtype,"
			+ " CASE"
			+ " WHEN whosout.outtype = '1' THEN '#5cb85c\'"
			+ " WHEN whosout.outtype = '7' THEN '#d9534f\'"
			+ " WHEN whosout.outtype = '3' THEN '#5bc0de\'"
			+ " WHEN whosout.outtype = '8' THEN '#337ab7\'"
			+ " ELSE '#777777\'"
			+ " END as color,f.myuser FROM whosout"
			+ " INNER JOIN users ON whosout.userid = users.userid"
			+ " LEFT JOIN( SELECT DISTINCT users.userid as myu, 1 as myuser FROM mgmt_structure l1"
			+ " Left Join mgmt_structure l2 ON l1.user_id = l2.mgr"
			+ " Left Join mgmt_structure l3 ON l2.user_id = l3.mgr"
			+ " Left Join mgmt_structure l4 ON l3.user_id = l4.mgr"
			+ " Left Join mgmt_structure l5 ON l4.user_id = l5.mgr"
			+ " Left Join users ON"
			+ " l1.user_id = users.userid OR"
			+ " l2.user_id = users.userid OR"
			+ " l3.user_id = users.userid OR"
			+ " l4.user_id = users.userid OR"
			+ " l5.user_id = users.userid"
			+ " WHERE (l1.mgr = 'test' ) AND users.active = '1') f ON users.userid = f.myu WHERE"
			+ " whosout.whodate >= TO_DATE(?1,'YYYY-MM-DD') AND whosout.whodate <= TO_DATE(?2,'YYYY-MM-DD') AND"
			+ " users.active = 1 ORDER BY whosout.outlen,whosout.outtype",nativeQuery = true)
	public List<UserCalInfo> retrieveUserCalInfoData(String startDate,String endDate);

}

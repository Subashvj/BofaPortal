package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.WhosOutInfo;
@Repository
public interface WhosRepository extends JpaRepository<WhosOutInfo, String>{
	@Query(value="SELECT whosout.userid, whosout.outlen,\r\n"
			+ "			users.displayname, outtypes.outdesc, whosout.outtype\r\n"
			+ "			FROM whosout\r\n"
			+ "			INNER JOIN users ON whosout.userid=users.userid\r\n"
			+ "			INNER JOIN outtypes ON whosout.outtype = outtypes.outtype\r\n"
			+ "			WHERE\r\n"
			+ "			whodate = trunc(sysdate) AND\r\n"
			+ "			(whosout.userid=users.userid) AND\r\n"
			+ "			(whosout.outtype=outtypes.outtype) AND\r\n"
			+ "			(users.active=1)\r\n"
			+ "			ORDER BY displayname ASC, outlen ASC", nativeQuery = true)
	public List<WhosOutInfo> getwhosinf();

}

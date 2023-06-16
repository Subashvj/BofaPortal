package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.UserDataInfo;
@Repository
public interface UserDataInfoRepo extends JpaRepository<UserDataInfo, Integer>{
	@Query(nativeQuery = true , value = "SELECT "
			+ "users.userid as value, "
			+ "users.displayname as text "
			+ "FROM users WHERE users.active = 1 "
			+ "ORDER BY "
			+ "users.displayname ASC")
			public List<UserDataInfo> restrieveUserInfoData();
}

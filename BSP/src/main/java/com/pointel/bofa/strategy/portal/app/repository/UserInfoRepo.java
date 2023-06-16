package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{
	@Query(value = "select users.displayname,users.email from users where users.userid=?1",nativeQuery = true)
	UserInfo getUserInfos(String userId);
	

}

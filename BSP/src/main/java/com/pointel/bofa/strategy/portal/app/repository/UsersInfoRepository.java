package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.UsersInfo;
@Repository
public interface UsersInfoRepository extends JpaRepository<UsersInfo, Integer>{
	@Query(value="select distinct count(strat_to_install.install_id) as tot,\r\n"
			+ "users.displayname from strat_to_install\r\n"
			+ "inner join strat_members on strat_to_install.strat_id = strat_members.strat_id\r\n"
			+ "inner join users on strat_members.username = users.userid\r\n"
			+ "where install_id = 1 group by users.displayname", nativeQuery = true)
	List<UsersInfo> usersInfos (int installId);

}

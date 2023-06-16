package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.dto.UserPrefsinfo;

@Repository
public interface UserPrefRepository extends JpaRepository<UserPrefsinfo, Integer> {
	@Query (value=" select user_preferences_list.iduser_pref_id,\r\n"
			+ "		case when\r\n"
			+ "		a.user_pref_value is null or a.user_pref_value = 1 then 0 else 1\r\n"
			+ "		end as user_pref_value from user_preferences_list\r\n"
			+ "		left join( select user_perferences.userid, user_perferences.user_pref_id,\r\n"
			+ "		user_perferences.user_pref_value from user_perferences where\r\n"
			+ "		user_perferences.userid = ?1) a on user_preferences_list.iduser_pref_id = a.user_pref_id", nativeQuery = true)
	public List<UserPrefsinfo> userPrefsinfo(String username);

}

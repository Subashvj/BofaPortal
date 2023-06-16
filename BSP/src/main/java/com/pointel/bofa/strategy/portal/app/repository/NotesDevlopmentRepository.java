package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.NotesDevlopmentInfo;

@Repository
public interface NotesDevlopmentRepository extends JpaRepository<NotesDevlopmentInfo, Integer>{
	@Query(value="select notes.strat_id, notes.note, notes.add_date, installs.install_title, users.displayname from notes\r\n"
			+ "inner join installs on notes.install_id = installs.install_id\r\n"
			+ "inner join users on notes.userid = users.userid\r\n"
			+ "where notes.note_type = 1 and notes.strat_id = ?1 and notes.install_id in (?2) and rownum<=1\r\n"
			+ "order by notes.add_date desc, notes.install_id asc",nativeQuery = true)
	List<NotesDevlopmentInfo> devlopmentInfos (int stratId,List<Integer> installId);

}

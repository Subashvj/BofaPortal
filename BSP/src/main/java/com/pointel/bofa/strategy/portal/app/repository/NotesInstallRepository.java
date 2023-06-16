package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.NotesInstallInfo;
@Repository
public interface NotesInstallRepository extends JpaRepository<NotesInstallInfo, Integer>{
	@Query(value=" select notes.install_id from notes where notes.note_type = 3\r\n"
			+ "			and strat_id = ?1 order by notes.add_date desc", nativeQuery = true)
	List<NotesInstallInfo> notesinstallInfo( int stratId);

}

package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.News;


@Repository
public interface NewsinfoRepository extends JpaRepository<News,Integer> {
	
	@Query(value="select * from (SELECT news.news_id, news.news_title,\r\n"
			+ "	to_char(news.news_date, 'mm/dd/yyyy') as news_date  FROM news\r\n"
			+ "	WHERE news.news_state = '1' \r\n"
			+ "	ORDER BY news.news_date DESC)where rownum <= 5",nativeQuery = true)
	public List<News> getnewsin();

}

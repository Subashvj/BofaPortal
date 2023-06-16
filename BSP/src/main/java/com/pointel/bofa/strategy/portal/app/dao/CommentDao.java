package com.pointel.bofa.strategy.portal.app.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.repository.StratHistoryRepo;

@Component
public class CommentDao {
	public static Logger logger = LogManager.getLogger(CommentDao.class);
	@Autowired
	StratHistoryRepo stratHistoryRepo;
	
	public Integer saveComment(StratHistory stratHistory) throws Exception {
		logger.info("Entered into CommentDao saveComment input data : "+stratHistory.toString());
		StratHistory result = stratHistoryRepo.save(stratHistory);
		logger.info("Strat id from saveComment "+result.getStratId());
		return result.getStratId();
	}
	

}

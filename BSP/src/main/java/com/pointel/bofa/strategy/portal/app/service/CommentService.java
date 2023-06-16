package com.pointel.bofa.strategy.portal.app.service;



import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dao.CommentDao;

import com.pointel.bofa.strategy.portal.app.dto.AddCommentRequest;
import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;


@Service
public class CommentService {
	@Autowired
	CommentDao commentDao;
	@Autowired
	ResponseMessage response;
	
	


	public static Logger logger = LogManager.getLogger(CommentService.class);



	public Integer saveComment(AddCommentRequest addCommentRequest) throws Exception {
		//AddComment addComment=new AddComment();
		StratHistory stratHistory = new StratHistory();
		logger.info("Entered into  Commentservice saveComment input data :"+addCommentRequest.toString());
		Date date = new Date(); 
		java.sql.Date sqlDate= new java.sql.Date(date.getTime());
		addCommentRequest.setfDate(sqlDate);
		stratHistory.setStratId(addCommentRequest.getStratId());
		stratHistory.setComment_(addCommentRequest.getComment());
		stratHistory.setFdate(addCommentRequest.getfDate());
		stratHistory.setUserid(addCommentRequest.getUserId());
		int incomingStatusId=addCommentRequest.getNewStatusId();
		switch (incomingStatusId) {
		case 1:
			incomingStatusId=51;
			break;
		case 2:
			incomingStatusId=52;
			break;

		default:
			incomingStatusId=0;
			break;
		}
		logger.info("newStatusId after converting:"+incomingStatusId);
		stratHistory.setNewStatusId(incomingStatusId);
		Integer stratId = commentDao.saveComment(stratHistory);
		if(stratId!=0) {
			response.setSuccess(true);
			response.setMessage(MessageConstants.successMsg);
			logger.info("Comment saved succesfully");
			logger.info("Strat id from saveComment "+stratId);
			
		}
		else
		{
			response.setSuccess(false);
			response.setMessage(MessageConstants.failureMsg);
			logger.info("Failed to save comment");
			
		}
		
		return stratId;
	}

}

package com.pointel.bofa.strategy.portal.app.service;


import java.util.Date;

import javax.transaction.Transactional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.controller.AddInstallationCommentControllerImpl;
import com.pointel.bofa.strategy.portal.app.entity.AddComment;
import com.pointel.bofa.strategy.portal.app.dto.RequestCommentData;
import com.pointel.bofa.strategy.portal.app.repository.AddCommentRepository;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class AddInstallationCommentServiceImpl {
	public static Logger logger = LogManager.getLogger(AddInstallationCommentServiceImpl.class);
	
	@Value("${userid}")
	private String userId; 
	
	@Autowired
	AddCommentRepository addCommentRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Transactional
	public ResponseMessage addComment(RequestCommentData requestCommentData) throws Exception{
		logger.info("[BSP]:addComment() - Service Insertion Process Started");
		AddComment addComment = new AddComment();
		addComment.setInstallId(requestCommentData.getInstallId());
		addComment.setComment_(requestCommentData.getComment());
		addComment.setUserid(userId);
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		addComment.setFdate(sqldate);
		addCommentRepository.save(addComment);
		responseMessage.setSuccess(true);;
		logger.info("[BSP]:addComment() - Service Insertion Process Ended");
		return responseMessage;	
	}
}

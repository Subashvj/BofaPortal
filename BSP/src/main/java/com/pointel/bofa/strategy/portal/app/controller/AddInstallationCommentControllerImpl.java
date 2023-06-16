package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.RequestCommentData;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.AddInstallationCommentServiceImpl;
import com.pointel.bofa.strategy.portal.app.service.AddInstallationCommentServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/installation")
public class AddInstallationCommentControllerImpl {
	
	public static Logger logger = LogManager.getLogger(AddInstallationCommentControllerImpl.class);
	
	@Autowired
	AddInstallationCommentServiceImpl addInstallationServiceImpl;

	@Autowired
   TraceLogger traceLogger;
	
	@Autowired
	ResponseMessage responseMessage;
	
	@PostMapping(path="/addComment",consumes = {"application/json"})
	public ResponseEntity<?> addComment(@RequestBody RequestCommentData requestCommentData) throws Exception{
		logger.info("[BSP]:addComment() - Insertion Process Started");
		try {
			responseMessage = addInstallationServiceImpl.addComment(requestCommentData);
		}catch(Exception e) {
			responseMessage.setSuccess(false);
			logger.error("[BSP]:addComment() - Exception:{}",e);
			traceLogger.writeStackTrace(e);
		}
		logger.info("[BSP]:addComment() - Insertion Process Ended");
		return ResponseEntity.ok().body(responseMessage);
	}
}

package com.pointel.bofa.strategy.portal.app.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.AddCommentRequest;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.service.CommentService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects")
public class CommentController {
	public static Logger logger = LogManager.getLogger(CommentController.class);
	@Autowired
	CommentService commentService;
	@Autowired
	ResponseMessage response;
	@PostMapping("/saveComment")
	public ResponseEntity<?> saveComment(@RequestBody AddCommentRequest addCommentRequest) {
		
		try {
			logger.info("Entered into Comment Controller saveComment");
			logger.info("Input Data addCommentDto "+addCommentRequest.toString());
			Integer stratId = commentService.saveComment(addCommentRequest);
			logger.info("Comment added successfully by  "+stratId);
			return ResponseEntity.ok().body(response);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in Comment Controller saveComment");
			return ResponseEntity.ok().body(response);
		}
	}

}

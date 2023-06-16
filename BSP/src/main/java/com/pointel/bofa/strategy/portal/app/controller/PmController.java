package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pointel.bofa.strategy.portal.app.dto.ProjectPmRequest;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.PmService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects")
public class PmController {
	
	public static Logger logger = LogManager.getLogger(PmController.class);
	
	@Autowired
	PmService pmService;
	
	@Autowired
    TraceLogger pointelTraceLogger;
	
	@Autowired
	ResponseMessage responseMessage;
	
	@PostMapping(path="/updatePm",consumes = {"application/json"})
	public ResponseEntity<?> updatePm(@RequestBody ProjectPmRequest projectPmRequest){
		logger.info("[BSP]:updatePm() - Update Process Started");
		try {
			responseMessage = pmService.updatePm(projectPmRequest);
		}catch(Exception e) {
			responseMessage.setSuccess(false);
			logger.error("[BSP]:updatePm() - Exception:{}",e);
			pointelTraceLogger.writeStackTrace(e);
		}
		logger.info("[BSP]:updatePm() - Updation Process Ended");
		return ResponseEntity.ok().body(responseMessage);
		
	}
}

package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.RequestUpdateInstallationOverview;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.InstallationOverviewService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/installation")
public class InstallationOverviewController {
	
	public static Logger logger = LogManager.getLogger(InstallationOverviewController.class);
	
	@Autowired
	TraceLogger traceLogger;
	
	@Autowired
	ResponseMessage responseMessage;
	@Autowired
	InstallationOverviewService installationOverviewService;
	
	@PostMapping(path="/updateInstallationOverview",consumes = {"application/json"})
	public ResponseEntity<?> updateInstallationOverview(@RequestBody RequestUpdateInstallationOverview 
			request) throws Exception{
		logger.info("[BSP]:updateInstallationOverview() - Insertion Process Started");
		try {
			responseMessage = installationOverviewService.updateInstallationOverview(request);
		}catch(Exception e) {
			responseMessage.setSuccess(false);
			logger.error("[BSP]:updateInstallationOverview() - Exception:{}",e);
			traceLogger.writeStackTrace(e);
		}
		logger.info("[BSP]:updateInstallationOverview() - Insertion Process Ended");
		return ResponseEntity.ok().body(responseMessage);	
	}
}

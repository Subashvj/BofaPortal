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
import com.pointel.bofa.strategy.portal.app.dto.RequestInstallationFileLink;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.InstallationFileLinkService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/installation")
public class InstallationFileLinkController {

	public static Logger logger = LogManager.getLogger(InstallationFileLinkController.class);
	
	@Autowired
	TraceLogger traceLogger;
	
	@Autowired
	InstallationFileLinkService installationFileLinkService;
	
	@Autowired
	ResponseMessage responseMessage;
	
	@PostMapping(path="/addFileLink",consumes = {"application/json"})
	public ResponseEntity<?> addFileLink(@RequestBody RequestInstallationFileLink requestInstallationFileLink) throws Exception{
		logger.info("[BSP]:addFileLink() - Insertion Process Started");
		try {
			responseMessage = installationFileLinkService.addFileLink(requestInstallationFileLink);
		}catch(Exception e) {
			responseMessage.setSuccess(false);
			logger.error("[BSP]:addFileLink() - Exception:{}",e);
			traceLogger.writeStackTrace(e);
		}
		logger.info("[BSP]:addFileLink() - Insertion Process Ended");
		return ResponseEntity.ok().body(responseMessage);
	}
}

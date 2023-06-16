package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateTechComponentRequest;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.TechComponentServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects/techcomponent")
public class TechComponentController {
	private static Logger logger = LogManager.getLogger(TeamMembersController.class);
	@Autowired
	TechComponentServiceImpl techComponentServiceImpl;
	@Autowired
	TraceLogger traceLogger;
	
	@GetMapping("/getTechComponentEditList/{stratId}")
	public ResponseEntity<?> getTechcomponentEdit(@PathVariable int stratId){	
	try {
		List<TechComponentsEditInfo> componentEditInfos = techComponentServiceImpl.getTechcomponentEditInfo(stratId);
		logger.info("Result from getApprovals "+componentEditInfos);
		return ResponseEntity.ok().body(componentEditInfos);
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in getTechcomponentEdit");
		return ResponseEntity.ok().body(error);
	}
 }
	@PostMapping("/updateImpactedComponents")
	public ResponseEntity<?> updateImpactedComponents(@RequestBody UpdateTechComponentRequest request){	
	try {
		ResponseMessage responseMessage = techComponentServiceImpl.UpdateTechComponent(request);
		logger.info("Result from getApprovals "+responseMessage);
		return ResponseEntity.ok().body(responseMessage);
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in getTechcomponentEdit");
		return ResponseEntity.ok().body(error);
	}
	}
}

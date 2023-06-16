package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.UpdateRoleRequest;
import com.pointel.bofa.strategy.portal.app.dto.UpdateScopeRequest;
import com.pointel.bofa.strategy.portal.app.entity.Strategies2;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.ScopeServiceImpl;

@RestController
@RequestMapping("/api/v1/projects")
public class ScopeController {
	public static Logger logger = LogManager.getLogger(ScopeController.class);
	@Autowired
	TraceLogger traceLogger;
	@Autowired
	ScopeServiceImpl scopeServiceImpl;
	
	@PutMapping("/updateScope")
	public ResponseEntity<?> UpdateScope(@RequestBody UpdateScopeRequest request) throws Exception {
	
			Strategies2 strategies= null;
			try {
				
				strategies = scopeServiceImpl.UpdateScopeType(request);
				return ResponseEntity.ok().body(strategies);
				
			} catch (Exception e) {
				logger.error("Error occured in getUpdateTeamMembersRole"+e);
				traceLogger.writeStackTrace(e);
				ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
				logger.error("Error occured in getUpdateTeamMembersRole"+e);
				return ResponseEntity.ok().body(error);
			}
			
}
}
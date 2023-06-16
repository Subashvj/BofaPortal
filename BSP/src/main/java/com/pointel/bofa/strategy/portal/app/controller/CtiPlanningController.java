package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pointel.bofa.strategy.portal.app.dto.CtiPlanningRequest;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.service.CtiPlanningService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects/ctiplanning")
public class CtiPlanningController {
	public static Logger logger = LogManager.getLogger(CtiPlanningController.class);
	@Autowired
	CtiPlanningService ctiPlanningService;
	@Autowired
	ResponseMessage response;
	
	@PostMapping("/adddeletectiplanning")
	@ResponseBody
	public ResponseEntity<?> addDeleteCtiPlanning(@RequestBody CtiPlanningRequest ctiPlanningRequest) throws JsonProcessingException {
		try {
			logger.info("Entered into CtiPlanningController addDeleteCtiPlanning");
			logger.info("Input data strat id"+ctiPlanningRequest.toString());
			ctiPlanningService.addDeleteCtiPlanning(ctiPlanningRequest);
		return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in CtiPlanningController addDeleteCtiPlanning");
			return ResponseEntity.ok().body(response);
			
		}
		
	}

}

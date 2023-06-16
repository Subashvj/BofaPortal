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

import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateImpactedProductsRequest;
import com.pointel.bofa.strategy.portal.app.dto.UpdateTechComponentRequest;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.ImpactedProductServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects/impactedproducts")
public class ImpactedProductController {
	private static Logger logger = LogManager.getLogger(TeamMembersController.class);

	@Autowired
	ImpactedProductServiceImpl impactedComponentServiceImpl;
	@Autowired
	TraceLogger traceLogger;

	@GetMapping("/getImpactedProductsEditList/{stratId}")
	public ResponseEntity<?> getImpactedProducts(@PathVariable int stratId) {
		try {
			List<ImpactedComponentsEditInfo> impactcomponentsEditInfos = impactedComponentServiceImpl
					.getImpactedComponents(stratId);
			return ResponseEntity.ok().body(impactcomponentsEditInfos);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getImpactedProducts");
			return ResponseEntity.ok().body(error);
		}
	}
	@PostMapping("/updateImpactedProducts")
	public ResponseEntity<?> updateImpactedProducts(@RequestBody UpdateImpactedProductsRequest request){	
	try {
		ResponseMessage responseMessage = impactedComponentServiceImpl.updateProduct(request);
		logger.info("Result from getApprovals "+responseMessage);
		return ResponseEntity.ok().body(responseMessage);
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in updateImpactedProducts");
		return ResponseEntity.ok().body(error);
	}
	}
}

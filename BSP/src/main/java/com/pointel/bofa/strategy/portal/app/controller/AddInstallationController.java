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
import com.pointel.bofa.strategy.portal.app.dto.InstallEnvironmentInfo;
import com.pointel.bofa.strategy.portal.app.dto.RequestAddInstall;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.entity.InstallTypesInfo;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.AddInstallationServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/installtion/addNewInstallation")
public class AddInstallationController {
	public static Logger logger = LogManager.getLogger(TeamMembersController.class);
	@Autowired
	AddInstallationServiceImpl addInstallionServiceImpl;
	@Autowired
	TraceLogger traceLogger;
	@Autowired
	ResponseMessage responseMessage;

	
	@GetMapping("/getInstallEnvironment")
	public ResponseEntity<?> getInstallEnvironment() throws Exception {
	logger.info("[BSP]:getInstallEnvironment() - controller method call Started");
	List<InstallEnvironmentInfo> installtionenvironmet=null;
	try {
		installtionenvironmet=addInstallionServiceImpl.getInstalltionEnvironmetInfo();
	return ResponseEntity.ok().body(installtionenvironmet) ;
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in getInstallEnvironment");
		return ResponseEntity.ok().body(error);
	}
	}
	@GetMapping("/getInstallType")
	public ResponseEntity<?> getInstallTypes() throws Exception {
	logger.info("[BSP]:getInstallEnvironment() - controller method call Started");
	List<InstallTypesInfo> installYpes=null;
	try {
		installYpes=addInstallionServiceImpl.getInstallTypeInfo();
	return ResponseEntity.ok().body(installYpes) ;
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in getInstallEnvironment");
		return ResponseEntity.ok().body(error);
	}
	}
	@PostMapping(path="/addNewInstallation",consumes = {"application/json"})
	public ResponseEntity<?> addInstallation(@RequestBody RequestAddInstall requestAddInstall) throws Exception{
		logger.info("[BSP]:addInstallation() - Insertion Process Started");
		try {
			responseMessage = addInstallionServiceImpl.addInstallation(requestAddInstall);
		}catch(Exception e) {
			responseMessage.setSuccess(false);
			logger.error("[BSP]:addComment() - Exception:{}",e);
			traceLogger.writeStackTrace(e);
		}
		logger.info("[BSP]:addInstallation() - Insertion Process Ended");
		return ResponseEntity.ok().body(responseMessage);
	}
}

package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.RequestUpdateAndDeleteInstallation;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.InstallHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratToInstallRepo;
import com.pointel.bofa.strategy.portal.app.service.ProjectLinkedInstalltionServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;


@RestController
@RequestMapping("/api/v1/projects")
public class ProjectLinkedInstalltion {
	public static Logger logger = LogManager.getLogger(ProjectLinkedInstalltion.class);
	@Autowired
	ProjectLinkedInstalltionServiceImpl linkedInstalltionServiceImpl;
	@Autowired
	TraceLogger traceLogger;
	@Autowired
	StratToInstallRepo stratToInstallRepo;
	
	@Autowired
	StratHistoryRepo stratHistoryRepo;
	
	@Autowired
	InstallHistoryRepo installHistoryRepo;
	
	@Autowired
	ResponseMessage responseMessage;
	
	
	@GetMapping("/getLinkedInstallEditList/{stratId}")
	public ResponseEntity<?> getlinkedinstallEdit(@PathVariable int stratId){
		logger.info("Entered into ProjectDetailsController getlinkedinstallEdit");
		logger.info("input data "+stratId);
	try {
		List<LinkedInstalltionEditInfo> installtionEditInfos = linkedInstalltionServiceImpl.getLinkedInstallEdit(stratId);
		 logger.info("Result from getApprovals "+installtionEditInfos);
			return ResponseEntity.ok().body(installtionEditInfos);
	} catch (Exception e) {
		traceLogger.writeStackTrace(e);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in getlinkedinstallEdit");
		return ResponseEntity.ok().body(error);
	}
}
    @PutMapping(path="/attachToAnInstallation")
    public ResponseEntity<?> updateAndDeleteInstallation(@RequestBody RequestUpdateAndDeleteInstallation requestUpdateAndDeleteInstallation) throws Exception{
            logger.info("[BSP]:updateAndDeleteInstallation() - Insertion Process Started");
            try {
                    responseMessage = linkedInstalltionServiceImpl.updateAndDeleteInstallation(requestUpdateAndDeleteInstallation);
            }catch(Exception e) {
                    responseMessage.setSuccess(false);
                    logger.error("[BSP]:updateAndDeleteInstallation() - Exception:{}",e);
                    traceLogger.writeStackTrace(e);
            }
            logger.info("[BSP]:updateAndDeleteInstallation() - Insertion Process Ended");
            return ResponseEntity.ok().body(responseMessage);
    }
}
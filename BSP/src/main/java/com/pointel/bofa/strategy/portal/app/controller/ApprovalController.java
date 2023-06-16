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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pointel.bofa.strategy.portal.app.dto.ProjectNameInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactTypeInfo;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.service.ApprovalService;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("api/v1/projects")
public class ApprovalController {
	
	public static Logger logger = LogManager.getLogger(ApprovalController.class);
	
	
	@Autowired
	ApprovalService approvalService;
	@Autowired
	ResponseMessage response;

	@GetMapping("getProjectNameInfo/{stratId}")
	public ResponseEntity<?> getProjectNameInfo(@PathVariable int stratId){
		try {
			logger.info("Entered into ApprovalController getProjectNameInfo");
			logger.info("Input data stratId "+stratId);
			
			List<ProjectNameInfo> result = approvalService.getProjectNameInfoStratId(stratId);
			logger.info("Result from  getProjectNameInfo "+result);
			return ResponseEntity.ok().body(result);

		}catch(Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in getProjectNameInfo");
			return ResponseEntity.ok().body(error);
		}

	}
	
	
	@GetMapping("getProjectNameInfo/{stratId}/{keyword}")
	@ResponseBody
	public ResponseEntity<?> getProjectNameInfo(@PathVariable int stratId,@PathVariable String keyword){
		try {
			logger.info("Entered into ApprovalController getProjectNameInfo");
			logger.info("Input data stratId "+stratId);
			logger.info("Input data Keyword "+keyword);
			
			List<ProjectNameInfo> result = approvalService.getProjectNameInfoSuggestion(stratId,keyword);
			logger.info("Result from  getProjectNameInfo "+result);
			return ResponseEntity.ok().body(result);

		}catch(Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in getProjectNameInfo");
			return ResponseEntity.ok().body(error);
		}

	}
	@GetMapping("getArtifactTypeInfo")
	public ResponseEntity<?> getArtifactTypeInfo(){
		try {
			logger.info("Entered into ApprovalController getArtifactTypeInfo");
			List<ArtifactTypeInfo> result = approvalService.getArtifactTypeInfo();
			logger.info("Result from  getArtifactTypeInfo "+result);
			return ResponseEntity.ok().body(result);

		}catch(Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in getArtifactTypeInfo");
			return ResponseEntity.ok().body(error);
		}

	}
	@GetMapping("getArtifactTypeInfo/{keyword}")
	@ResponseBody
	public ResponseEntity<?> getArtifactTypeInfo(@PathVariable String keyword){
		try {
			logger.info("Entered into ApprovalController getArtifactTypeInfo");
			logger.info("Input data Keyword "+keyword);
			List<ArtifactTypeInfo> result = approvalService.getArtifactTypeInfoSuggestion(keyword);
			logger.info("Result from  getArtifactTypeInfo "+result);
			return ResponseEntity.ok().body(result);

		}catch(Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in getArtifactTypeInfo");
			return ResponseEntity.ok().body(error);
		}

	}
	@GetMapping("getStratMemberInfo/{stratId}")
	public ResponseEntity<?> getStratMemberInfo(@PathVariable int stratId){
		try {
			logger.info("Entered into ApprovalController getStratMemberInfo");
			logger.info("Input data stratId "+stratId);
			List<StratMemberInfo> result=approvalService.getStratMemberInfo(stratId);
			logger.info("Result from  getStratMemberInfo "+result);
			return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in getStratMemberInfo");
			return ResponseEntity.ok().body(error);
			
			
		}
		
	}
	/*
	
	@PostMapping("addApprovals")
	public ResponseEntity<?> addApprovals(@RequestBody AddArtifactsRequest addArtifactsRequest){
		try {
			logger.info("Entered into ApprovalController addApprovals");
			logger.info("Input data addArtifactsRequest "+addArtifactsRequest.toString());
			System.out.println("Result getArtifactDue "+addArtifactsRequest.getArtifactDue());
			approvalService.saveArtifacts(addArtifactsRequest);
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.info("Error Occured in addApprovals");
			return ResponseEntity.ok().body(response);
		}
		
	}
	
	*/
	
	
	
	

}







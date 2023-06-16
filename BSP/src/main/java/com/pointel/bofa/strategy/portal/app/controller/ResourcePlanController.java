package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dto.DevPlanningRequest;
import com.pointel.bofa.strategy.portal.app.dto.FolderChangesdto;
import com.pointel.bofa.strategy.portal.app.dto.Resources;
import com.pointel.bofa.strategy.portal.app.dto.StratMembersDto;
import com.pointel.bofa.strategy.portal.app.repository.ResourcePlanMasterDataRepo;
import com.pointel.bofa.strategy.portal.app.service.ResourcePlanServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("api/v1/projects")
public class ResourcePlanController {
	public static Logger logger = LogManager.getLogger(ResourcePlanController.class);
	
	@Autowired
	ResourcePlanServiceImpl resourcePlanServiceImpl;
	
	@Autowired
	ResponseMessage response;
	
	@PostMapping("/addDeleteDevPlanning")  //from sasi
	public ResponseEntity<?> addDeleteDevPlanning(@RequestBody DevPlanningRequest devPlanningRequest){
		try { 
			System.out.println("input data "+devPlanningRequest.toString());
		logger.info("Entered into DevPlanningController addDeleteDevPlanning");
		logger.info("Input data devPlanningDto "+devPlanningRequest.toString());
		
		resourcePlanServiceImpl.addDeleteDevPlanning(devPlanningRequest);
		return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			logger.error("Error occured in DevPlanningController addDeleteDevPlanning");
			return ResponseEntity.ok().body(response);
		}
	}
	
	
	@GetMapping("/getResources/{stratId}")
	public ResponseEntity<?> getResources(@PathVariable int stratId) {
		logger.info("Entered into ResourcePlanController getResourcePlanMasterData");
		logger.info("input data "+stratId);
		
		try {
			
			List<Resources> result = resourcePlanServiceImpl.getResources(stratId);  
			logger.info("Result from ResourcePlanController  getResourcePlanMasterData "+result);
			return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("Failed to save data");
			logger.error("Error occured in ResourcePlanController getResourcePlanMasterData");
			return ResponseEntity.ok().body(response);
		}
		
	}
	
	@GetMapping("/getResources/{stratId}/{displayName}")
	public ResponseEntity<?> getResourcesLikeDisplayName(@PathVariable int stratId ,@PathVariable String displayName ) {
		logger.info("Entered into ResourcePlanController getResourcesLikeDisplayName");
		logger.info("input data "+stratId + displayName);
		
		try {
			
			List<StratMembersDto> result  = resourcePlanServiceImpl.getResourcesLikeDisplayName(stratId,displayName);
			logger.info("Result from ResourcePlanController  getResourcesLikeDisplayName ");
			return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("Failed to get data");
			logger.error("Error occured in ResourcePlanController getResourcesLikeDisplayName");
			return ResponseEntity.ok().body(response);
		}
	}
	
	
	@PutMapping("/updateResources")
	public ResponseEntity<?> updateResources(@RequestBody FolderChangesdto folderdto) {
		logger.info("Entered into ResourcePlanController updateResources");
		logger.info("input data "+folderdto.toString());
		
		try {
			System.out.println("folderdto "+folderdto.toString());
			int stratId = resourcePlanServiceImpl.updateResources(folderdto);
			logger.info("Result from ResourcePlanController  updateResources "+stratId);
			response.setSuccess(true);
			response.setMessage("Data updated Successfully");
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("Failed to update data");
			logger.error("Error occured in ResourcePlanController updateResources");
			return ResponseEntity.ok().body(response);
		}
		
		
	}
	
	
	
	
	
	@Autowired
	ResourcePlanMasterDataRepo repo;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() throws JsonProcessingException {
		
		List<Resources> result  = repo.retrieveResourcePlanMasterData(7031);
		
		System.out.println("result "+new ObjectMapper().writeValueAsString(result));
		return ResponseEntity.ok().body(result);
	}

}

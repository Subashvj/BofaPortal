package com.pointel.bofa.strategy.portal.app.controller;

import java.math.BigInteger;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dto.EditTaskDto;
import com.pointel.bofa.strategy.portal.app.dto.TaskBean;
import com.pointel.bofa.strategy.portal.app.dto.MasterData;
import com.pointel.bofa.strategy.portal.app.entity.StratTasks;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.repository.MilestoneInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.PhaseInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratTasksRepository;
import com.pointel.bofa.strategy.portal.app.repository.UserInfoRepo;
import com.pointel.bofa.strategy.portal.app.service.TaskServiceImpl;

import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;


@RestController
@RequestMapping("/api/v1/projects")
public class TaskController {
	
	public static Logger logger = LogManager.getLogger(TaskController.class);
	
	@Autowired
	TaskServiceImpl taskService;
	
	@Autowired
	ResponseMessage response;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	@Autowired
	PhaseInfoRepo phaseInfoRepo;
	
	@Autowired
	MilestoneInfoRepo milestoneInfoRepo;
	
	@Autowired
	MasterData masterData;
	
	@Autowired
	StratTasksRepository testRepo;
	
	@PostMapping("/saveTask")
	@ResponseBody
	public ResponseEntity<?> saveTask(@RequestBody StratTasks stratTask) {
		logger.info("Entered into TaskController saveTask");
		logger.info("input data "+stratTask.toString());
		
		try {
			//System.out.println("result "+ new ObjectMapper().writeValueAsString(stratTask));
			System.out.println("input data "+stratTask.toString());
			BigInteger userId = taskService.saveTask(stratTask);
			response.setSuccess(true);
			response.setMessage("Data saved succesfully");
			
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("Failed to save data");
			logger.error("Error occured in TaskController saveTask");
			return ResponseEntity.ok().body(response);
		}
	}
	

	
	@GetMapping("/getMasterData")
	public ResponseEntity<?> getMasterData() throws JsonProcessingException {
		logger.info("Entered into TaskController getMasterData");
		try {
			
			MasterData result =	taskService.getMasterData();
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
		e.printStackTrace();
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
		logger.error("Error occured in TaskController getMasterData");
		return ResponseEntity.ok().body(error);
		}
	}
	
	@PutMapping("/editTask")
	@ResponseBody
	public ResponseEntity<?> editTask(@RequestBody EditTaskDto startTask) throws JsonProcessingException {
		logger.info("Entered into TaskController editTask");
		logger.info("input data "+startTask.toString());
		try {
			BigInteger stratId = taskService.editTask(startTask);
			return ResponseEntity.ok().body(stratId);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in TaskController editTask");
			return ResponseEntity.ok().body(error);
		}
		
		
	}
	
	@GetMapping("/getTaskDetails/{stratId}")
	public ResponseEntity<?> getTask(@PathVariable int stratId){
		logger.info("Entered into TaskController editTask");
		logger.info("input data "+stratId);
		try {
			System.out.println("stratId "+stratId);
			List<TaskBean> result = taskService.getTask(stratId);
			
			System.out.println("result "+new ObjectMapper().writeValueAsString(result));
			return ResponseEntity.ok().body(result);
		}catch(Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getTask");
			return ResponseEntity.ok().body(error);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}












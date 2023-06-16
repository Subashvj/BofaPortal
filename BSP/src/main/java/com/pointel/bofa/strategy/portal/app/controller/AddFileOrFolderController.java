package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.AddFileOrFolder;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.service.AddFileOrFolderService;

@RestController
@RequestMapping("api/v1/projects")
public class AddFileOrFolderController {

	public static Logger logger = LogManager.getLogger(AddFileOrFolderController.class);

	@Autowired
	AddFileOrFolderService addFileOrFolderService;

	@GetMapping("/getAddFileOrFolder")
	public ResponseEntity<?> getAddFileOrFolder(){
		logger.info("Entered into AddFileOrFolderController getAddFileOrFolder");
		try {
			List<AddFileOrFolder> result=addFileOrFolderService.getAddFileOrFolder();
			logger.info("Result from getAddFileOrFolder "+result);
			return ResponseEntity.ok().body(result);
		}catch(Exception e) {
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in AddFileOrFolderController getAddFileOrFolder");

			return ResponseEntity.ok().body(error);
		}
	}
	
	@GetMapping("/getAddFileOrFolder/{keyword}")
	@ResponseBody
	public ResponseEntity<?> getAddFileOrFolder(@PathVariable String keyword){
		
		logger.info("Entered into AddFileOrFolderController getAddFileOrFolder");
		logger.info("Input data keyword"+keyword);
		
		try {
			
			List<AddFileOrFolder> result=addFileOrFolderService.getAddFileOrFolderSuggestion(keyword);
			
			logger.info("Result from getAddFileOrFolderSuggestion "+result);
			
			return ResponseEntity.ok().body(result);
			
		}catch(Exception e) {
			
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in AddFileOrFolderController getAddFileOrFolderSuggestion");

			return ResponseEntity.ok().body(error);
		}
		
	}

}

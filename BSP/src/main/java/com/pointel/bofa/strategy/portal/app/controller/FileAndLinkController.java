package com.pointel.bofa.strategy.portal.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dto.AttachmentsDto;
import com.pointel.bofa.strategy.portal.app.dto.FileAttachments;
import com.pointel.bofa.strategy.portal.app.entity.Attachments;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.service.FileAndLinkServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects")
public class FileAndLinkController {

	public static Logger logger = LogManager.getLogger(FileAndLinkController.class);
	
	@Autowired
	FileAndLinkServiceImpl fileAndLinkServiceImpl;
	
	@Autowired
	ResponseMessage response;
	
	@PostMapping("/saveFileLink")
	public ResponseEntity<?> saveFileLink(@RequestBody AttachmentsDto linkRequest) {
		
		logger.info("Entered into FileAndLinkController saveFileLink");
		logger.info("input data "+linkRequest.toString());
		try {
			System.out.println("entered saveFileLink "+new ObjectMapper().writeValueAsString(linkRequest));
			
		int filetAttId =	fileAndLinkServiceImpl.saveLinkRequest(linkRequest);
		response.setSuccess(true);
		response.setMessage("Data saved succesfully");
		
		return ResponseEntity.ok().body(response);
			
		}catch(Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			response.setSuccess(false);
			response.setMessage("Failed to save data");
			logger.error("Error occured in saveFileLink");
			return ResponseEntity.ok().body(response);
		}
		
		}
	
	
	@PostMapping("/saveFile")
	public ResponseEntity<?> saveFile(@RequestParam("file") MultipartFile file, @RequestParam("attachments") String fileAttachments) throws JsonProcessingException {
		
		logger.info("Entered into FileAndLinkController saveFile");
		logger.info("input data "+fileAttachments);
		System.out.println("entered test "+file.toString());
		
		System.out.println("entered test file attachments  "+fileAttachments);
		
		FileAttachments attachments  = new ObjectMapper().readValue(fileAttachments, FileAttachments.class);
		
		System.out.println("result   "+new ObjectMapper().writeValueAsString(attachments));
		
		
		
		String upfile;
		try {
			upfile = fileAndLinkServiceImpl.saveFile(file,attachments);
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("")
//	                .path(upfile)
//	                .toUriString();
	        
	        //return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(upfile,fileDownloadUri,"File uploaded with success!"));  // just send to data saved successfully.
	        response.setSuccess(true);
			response.setMessage("Data saved succesfully");
	        return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			response.setSuccess(false);
			response.setMessage("Failed to save data");
			logger.error("Error occured in saveFile");
			return ResponseEntity.ok().body(response);
		}


        
       
		
	}
	}


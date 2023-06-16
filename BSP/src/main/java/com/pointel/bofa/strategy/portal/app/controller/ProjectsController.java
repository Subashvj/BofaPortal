package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.pointel.bofa.strategy.portal.app.dto.ProjectListInfo;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.pagination.PageService;
import com.pointel.bofa.strategy.portal.app.pagination.PagingRequest;
import com.pointel.bofa.strategy.portal.app.pagination.PagingResponse;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;


@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {
	public static Logger logger = LogManager.getLogger(ProjectsController.class);
	
	@Autowired
	PageService pageService;
	

	
	@PostMapping(path="/projectlist")
	public ResponseEntity<Object> search(@RequestBody PagingRequest request) throws Exception{
		logger.info("[BSP]:search() - method call Started");
		PagingResponse pagingResponse = pageService.getPage(request);
		logger.info("[BSP]:search() - method call Ended");
		return new ResponseEntity<>(pagingResponse,HttpStatus.OK);
	}
	
}

package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.controller.ResourcePlanController;
import com.pointel.bofa.strategy.portal.app.dao.ResourcePlanDao;
import com.pointel.bofa.strategy.portal.app.dto.DevPlanningPk;
import com.pointel.bofa.strategy.portal.app.dto.DevPlanningRequest;
import com.pointel.bofa.strategy.portal.app.dto.FolderChangesdto;
import com.pointel.bofa.strategy.portal.app.dto.Resources;
import com.pointel.bofa.strategy.portal.app.dto.StratMembersDto;
import com.pointel.bofa.strategy.portal.app.entity.Attachments;
import com.pointel.bofa.strategy.portal.app.entity.DevPlanning;
import com.pointel.bofa.strategy.portal.app.repository.AttachmentsRepo;

@Service
public class ResourcePlanServiceImpl implements ResourcePlanService  {
	
	public static Logger logger = LogManager.getLogger(ResourcePlanController.class);
	
	@Autowired
	ResourcePlanDao resourcePlanDao;
	
	@Autowired
	AttachmentsRepo attachmentsRepo;

//	@Override
//	public void saveResourcePlan(DevPlanning stratTask) throws Exception {
//		
//		
//		logger.info("Entered into ResourcePlanServiceImpl saveResourcePlan");
//		logger.info("input data "+stratTask.toString());
//		
//		
//		int hours = stratTask.getDevHour()*8;
//		stratTask.setDevHour(hours);
//
//			resourcePlanDao.deleteAndSaveDevPlanningData(stratTask);
//
//		
//		
//	}
	
	@Override
	public void addDeleteDevPlanning(DevPlanningRequest devPlanningRequest) throws Exception{
		logger.info("Entered into DevPlanningService addDeleteDevPlanning input data "+devPlanningRequest.toString());
		logger.info("Input data "+devPlanningRequest.toString());
		DevPlanning devPlanning = new DevPlanning();
		DevPlanningPk devPlanningpk = new DevPlanningPk();
		devPlanningpk.setStratId(devPlanningRequest.getStratIds());
		devPlanningpk.setDevUser(devPlanningRequest.getDevUsers());
		devPlanningpk.setDevMonth(devPlanningRequest.getDevMonths());
		devPlanningpk.setDevYear(devPlanningRequest.getDevYears());
		devPlanning.setDevHours(devPlanningRequest.getDevHourss()*8);
		devPlanning.setDevPlanningPk(devPlanningpk);
		System.out.println("result2 "+ new ObjectMapper().writeValueAsString(devPlanning));
		resourcePlanDao.addDeleteDevPlanning(devPlanning);
	}

	@Override
	public List<Resources> getResources(int stratId) throws Exception {
		logger.info("Entered into ResourcePlanServiceImpl getResources");
		logger.info("input data "+stratId);
		
		List<Resources> result = resourcePlanDao.getResourcePlanMasterData(stratId);
		logger.info("Result from  into getResources "+result.toString());

		return result;
	}

	@Override
	public int updateResources(FolderChangesdto folderChangesdto) throws Exception {
		logger.info("Entered into ResourcePlanServiceImpl updateResources");
		logger.info("input data "+folderChangesdto.toString());
		
		Attachments attachments = resourcePlanDao.getAttachmentsById(folderChangesdto.getAttachmentId());
		System.out.println("attachments  result "+new ObjectMapper().writeValueAsString(attachments));
		attachments.setFolderId(folderChangesdto.getFolderId());
		
		Attachments updatedAttachments = attachmentsRepo.save(attachments);
		

		return updatedAttachments.getFolderId();
		
	}
	
	@Override
	public List<StratMembersDto> getResourcesLikeDisplayName(int stratId, String displayName) {
		
		logger.info("Entered into ResourcePlanServiceImpl updateResources");
		logger.info("stratId "+stratId);
		logger.info("displayName "+displayName);
		List<StratMembersDto> result = resourcePlanDao.getResourcesLikeDisplayName( stratId, displayName);
		return result;
	}



}

















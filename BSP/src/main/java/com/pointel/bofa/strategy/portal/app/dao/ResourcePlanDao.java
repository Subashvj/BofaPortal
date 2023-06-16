package com.pointel.bofa.strategy.portal.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.pointel.bofa.strategy.portal.app.dto.DevPlanningPk;
import com.pointel.bofa.strategy.portal.app.dto.Resources;
import com.pointel.bofa.strategy.portal.app.dto.StratMembersDto;
import com.pointel.bofa.strategy.portal.app.entity.Attachments;
import com.pointel.bofa.strategy.portal.app.entity.DevPlanning;
import com.pointel.bofa.strategy.portal.app.repository.AttachmentsRepo;
import com.pointel.bofa.strategy.portal.app.repository.DevPlanningRepo;
import com.pointel.bofa.strategy.portal.app.repository.ResourcePlanMasterDataRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratMembersDtoRepo;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Repository
public class ResourcePlanDao {
	
	public static Logger logger = LogManager.getLogger(ResourcePlanDao.class);
	
	@Autowired
	DevPlanningRepo devPlanningRepo;
	
	@Autowired
	ResourcePlanMasterDataRepo resourcePlanMasterDataRepo;
	
	@Autowired
	AttachmentsRepo attachmentsRepo;
	
	@Autowired
	StratMembersDtoRepo stratMembersDtoRepo;
	

//	public void deleteAndSaveDevPlanningData(DevPlanning stratTask) {
//		devPlanningRepo.deleteAndSaveDevPlanningData(stratTask.getStratId() , stratTask.getDevMonth() , stratTask.getDevYear() , stratTask.getDevUser() , stratTask.getDevHour());
//	}
	
//	@Autowired
//	DevPlanningRepo devPlanningRepo;
	@Autowired
	ResponseMessage response;
	
	@Transactional
	public void addDeleteDevPlanning(DevPlanning incDevPlanning){
		
		logger.info("Entered into DevPlanningDao checkDevPlannning input data ");
		logger.info("Input data incDevPlanning "+incDevPlanning.toString());
		
		DevPlanningPk devPlanningPk=incDevPlanning.getDevPlanningPk();
		
		if(incDevPlanning.getDevHours()==0) {
			devPlanningRepo.deleteDevPlanning(devPlanningPk.getStratId(), devPlanningPk.getDevMonth(), devPlanningPk.getDevYear(), devPlanningPk.getDevUser());
			response.setSuccess(true);
			response.setMessage(MessageConstants.delMsg);
			logger.info("Entered into DevPlanningDao addDeleteDevPlanning and invoked delete method");
		}
		else 
		{
			DevPlanning devPlanning=devPlanningRepo.checkDevPlanning(devPlanningPk.getStratId(), devPlanningPk.getDevMonth(), devPlanningPk.getDevYear(), devPlanningPk.getDevUser());
		
			if(devPlanning!=null) {
				devPlanning.setDevHours(incDevPlanning.getDevHours());
				devPlanningRepo.save(devPlanning);
				response.setSuccess(true);
				response.setMessage(MessageConstants.updateMsg);
				logger.info("Entered into DevPlanningDao addDeleteDevPlanning and invoked update method");
			}
			else
			{
				devPlanningRepo.save(incDevPlanning);
				response.setSuccess(true);
				response.setMessage(MessageConstants.addMsg);
				logger.info("Entered into DevPlanningDao addDeleteDevPlanning and invoked save method");
			}
		
		}
		
		
	}


	public List<Resources> getResourcePlanMasterData(int stratId) {
		List<Resources> result = resourcePlanMasterDataRepo.retrieveResourcePlanMasterData(stratId);
		return result;
		
	}
	
	public Attachments getAttachmentsById(int attachmentId) {
		return attachmentsRepo.getById(attachmentId);
	}


	public List<StratMembersDto> getResourcesLikeDisplayName(int stratId, String displayName) {
		
		return stratMembersDtoRepo.retrieveStratMembersData(stratId, displayName);
	}
}








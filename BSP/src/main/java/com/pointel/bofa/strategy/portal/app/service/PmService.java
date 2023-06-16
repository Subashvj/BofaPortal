package com.pointel.bofa.strategy.portal.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.MessageCodeFormatter;

import com.pointel.bofa.strategy.portal.app.dto.ProjectPmRequest;
import com.pointel.bofa.strategy.portal.app.entity.StratToGroup;
import com.pointel.bofa.strategy.portal.app.entity.StratToGroupPk;
import com.pointel.bofa.strategy.portal.app.entity.Strategies;
import com.pointel.bofa.strategy.portal.app.entity.Strategies1;
import com.pointel.bofa.strategy.portal.app.repository.StratToGroupRepo;
import com.pointel.bofa.strategy.portal.app.repository.Strategies1Repo;
import com.pointel.bofa.strategy.portal.app.repository.StrategiesRepository;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class PmService {

	public static Logger logger = LogManager.getLogger(PmService.class);
	
	@Autowired
	ResponseMessage responseMessage;
	
	@Autowired
	Strategies1Repo strategies1Repo;
	
	@Autowired
	StratToGroupRepo stratToGroupRepo;
	
	@Autowired
	StrategiesRepository strategiesRepository;
	
	@Transactional
	public ResponseMessage updatePm(ProjectPmRequest request) throws Exception {
		logger.info("[BSP]:updatePm() - Service Insertion Process Started");
		
		Strategies1 strategies1 = strategies1Repo.findByStratId(request.getStratId());
		System.out.println("strategies1:"+strategies1.toString());
		
		logger.info("[BSP]:updatePm() - update to Strategies1 table  Process Started");
		if(strategies1 != null) {
			strategies1.setSharepointLink(request.getSharepointLink());
			strategies1.setProjuid(request.getProjuid());
			strategies1.setPriorityRequest(request.getPriorityRequest());
			strategies1.setResourcePlan(request.getResourcePlan());
			strategies1.setPmChangeNotes(request.getPmChangeNotes());
			strategies1.setTestNotes(request.getTestNotes());
			strategies1.setFundingSource(request.getFundingSource());
			strategies1.setParentClarity(request.getParentClarity());
			strategies1.setChildClarity(request.getChildClarity());
			strategies1.setNexusId(request.getNexusId());
			strategies1.setProjReg(request.getProjreg());
			strategies1.setRisks(request.getRisks());
			strategies1.setIssues(request.getIssues());
			strategies1.setGotogreen(request.getGotogreen());
			strategies1.setGppid(request.getGppid());
			strategies1.setFundingType(request.getFundingType());
			strategies1.setQcNum(request.getQcNum());
			strategies1.setCmStatus(request.getCmStatus());
			strategies1.setKickoffDate(request.getKickOffDate());
			strategies1.setPetNum(request.getPetNum());
			strategies1.setSwagReq(request.getSwagReq());
			strategies1.setSwagDue(request.getSwagDue());
			strategies1.setSwagComplete(request.getSwagComplete());
			strategies1.setGcApproveDate(request.getGcApproveDate());
			strategies1.setLobApproval(request.getLobApproval());
			strategies1.setSizingDue(request.getSizingDue());
			strategies1.setPir85Due(request.getPer85Due());
			strategies1.setPir100Due(request.getPer100Due());
			strategies1.setSwagNote(request.getSwagNote());
			strategies1Repo.save(strategies1);
		}
		logger.info("[BSP]:updatePm() - update to Strategies1 table  Process Ended");
		
		logger.info("[BSP]:updatePm() - update to strat_to_group table  Process Started");
		//List<StratToGroup> stratToGroup = stratToGroupRepo.findAllByStratId(request.getStratId());
		//System.out.println("stratToGroup:"+stratToGroup.toString());
		
		stratToGroupRepo.deleteStratToGroup(request.getStratId());;
			
		List<Integer> usergroups = request.getUsergroup();
		System.out.println("usergroups:"+usergroups.toString());
		List<StratToGroup> stratToGroupList = new ArrayList<>();
		for(int usergroup:usergroups) {
			StratToGroupPk stratToGroupPk = new StratToGroupPk();
			stratToGroupPk.setStratId(request.getStratId());
			stratToGroupPk.setUsergroup(usergroup);
			StratToGroup stratToGroup = new StratToGroup();
			stratToGroup.setStratToGroupPk(stratToGroupPk);
			stratToGroupList.add(stratToGroup);
		}
		stratToGroupRepo.saveAll(stratToGroupList);
		logger.info("[BSP]:updatePm() - update to strat_to_group table  Process Ended");	
			
		Strategies strategies = strategiesRepository.findByStratId(request.getStratId());
		System.out.println("strategies:"+strategies.toString());
		
		logger.info("[BSP]:updatePm() - update to Strategies table  Process Started");
		if(strategies != null) {
			strategies.setExecview(request.getExecview());
		}
		logger.info("[BSP]:updatePm() - update to Strategies1 table  Process Ended");
		
		responseMessage.setSuccess(true);;
		responseMessage.setMessage(MessageConstants.successMsg);
		return responseMessage;
		
	}
}

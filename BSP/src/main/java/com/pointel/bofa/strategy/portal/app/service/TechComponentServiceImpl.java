package com.pointel.bofa.strategy.portal.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateTechComponentRequest;
import com.pointel.bofa.strategy.portal.app.entity.StratToComponent;
import com.pointel.bofa.strategy.portal.app.entity.StratToComponentPK;
import com.pointel.bofa.strategy.portal.app.repository.StratToComponentRepo;
import com.pointel.bofa.strategy.portal.app.repository.TechcomponentsEditRepository;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;
@Service
public class TechComponentServiceImpl implements TechComponentService {
	private static Logger logger = LogManager.getLogger(TechComponentServiceImpl.class);
	
	@Autowired
	TechcomponentsEditRepository techcomponentsEditRepository;
	
	
	@Autowired
	StratToComponentRepo stratToComponentRepo;
	
	@Override
	public List<TechComponentsEditInfo> getTechcomponentEditInfo(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getApprovals input data :" + stratId);
		List<TechComponentsEditInfo> edidInfos = techcomponentsEditRepository.componentsEditinfos(stratId);
		logger.info("getTechComponents result  data :" + edidInfos.toString());
		return edidInfos;
	}

	@Override
	@Transactional
	public ResponseMessage UpdateTechComponent(UpdateTechComponentRequest request) throws Exception{
		logger.info("Entered into ProjectDetailsServiceimpl getApprovals input data :" + request.getStratId());
		stratToComponentRepo.stratToComponent(request.getStratId());
		ResponseMessage responseMessage = new ResponseMessage();
		List<Integer> componentIds = request.getComponentId();
		List<StratToComponent> stratToComponentList = new ArrayList<>();
		for(int componentId:componentIds) {
			StratToComponentPK stratToComponentPK = new StratToComponentPK();
			
			StratToComponent stratToComponent = new StratToComponent();
		
			stratToComponentPK.setStratId(request.getStratId());
			stratToComponentPK.setComponentId(componentId);
			stratToComponent.setStratToComponentPK(stratToComponentPK);
			stratToComponentList.add(stratToComponent);
			
			
		}
		stratToComponentRepo.saveAll(stratToComponentList);
		responseMessage.setSuccess(true);
		responseMessage.setMessage(MessageConstants.successMsg);
		logger.info("Method ended");
		return (responseMessage) ;
	}
}

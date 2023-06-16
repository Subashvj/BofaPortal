package com.pointel.bofa.strategy.portal.app.service;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pointel.bofa.strategy.portal.app.dao.CtiPlanningDao;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanning;

import com.pointel.bofa.strategy.portal.app.dto.CtiPlanningRequest;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanningPk;



@Service
public class CtiPlanningService {
	public static Logger logger = LogManager.getLogger(CtiPlanningService.class);
	
	
	@Autowired
	CtiPlanningDao ctiPlanningDao;
	
	
	public void addDeleteCtiPlanning(CtiPlanningRequest ctiPlanningRequest) throws JsonProcessingException {
		
		logger.info("Entered into CtiPlanningService addDeleteCtiPlanning");
		logger.info("Input Data ctiPlanningDto "+ctiPlanningRequest.toString());
		CtiPlanning ctiPlanning=new CtiPlanning();
		CtiPlanningPk ctiPlanningPk=new CtiPlanningPk();
		ctiPlanningPk.setStratId(ctiPlanningRequest.getStratId());
		ctiPlanningPk.setEstimateGrp(ctiPlanningRequest.getEstimateGrp());
		ctiPlanningPk.setCtiMonth(ctiPlanningRequest.getCtiMonth());
		ctiPlanningPk.setCtiYear(ctiPlanningRequest.getCtiYear());
		ctiPlanning.setCtiHours(ctiPlanningRequest.getCtiHours()*8);
		ctiPlanning.setCtiPlanningPk(ctiPlanningPk);//new
		ctiPlanningDao.addDeleteCtiPlanning(ctiPlanning);
		
	}

}

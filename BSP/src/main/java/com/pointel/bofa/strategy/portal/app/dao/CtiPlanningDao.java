package com.pointel.bofa.strategy.portal.app.dao;

import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanning;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanningPk;
import com.pointel.bofa.strategy.portal.app.repository.CtiPlanningRepo;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;


@Component
public class CtiPlanningDao {
	public static Logger logger = LogManager.getLogger(CtiPlanningDao.class);

	@Autowired
	CtiPlanningRepo ctiPlanningRepo;
	@Autowired
	ResponseMessage response;
	
	

	@Transactional
	public void addDeleteCtiPlanning(CtiPlanning incctiPlanning) throws JsonProcessingException{
		logger.info("Entered into CtiPlanningDao addDeleteCtiPlanning");
		logger.info("Input data incctiPlanning "+incctiPlanning.toString());
		

		CtiPlanningPk ctiPlanningPk=incctiPlanning.getCtiPlanningPk();


		if(incctiPlanning.getCtiHours()==0) {
			ctiPlanningRepo.deleteCtiPlanning(ctiPlanningPk.getStratId(), ctiPlanningPk.getCtiMonth(), ctiPlanningPk.getCtiYear(), ctiPlanningPk.getEstimateGrp());
			response.setSuccess(true);
			response.setMessage(MessageConstants.delMsg);
			logger.info("Entered into CtiPlanningDao addDeleteCtiPlanning and invoked delete method");
			

		}
		else {
			CtiPlanning ctiPlanning=ctiPlanningRepo.checkCtiPlanning(ctiPlanningPk.getStratId(), ctiPlanningPk.getCtiMonth(), ctiPlanningPk.getCtiYear(), ctiPlanningPk.getEstimateGrp());
			if(ctiPlanning!=null){
				
				ctiPlanning.setCtiHours(incctiPlanning.getCtiHours());

				ctiPlanningRepo.save(ctiPlanning);
				response.setSuccess(true);
				response.setMessage(MessageConstants.updateMsg);
				logger.info("Entered into CtiPlanningDao addDeleteCtiPlanning and invoked update method");

			}
			else
			{
				ctiPlanningRepo.save(incctiPlanning);
				response.setSuccess(true);
				response.setMessage(MessageConstants.addMsg);
				logger.info("Entered into CtiPlanningDao addDeleteCtiPlanning and invoked save method");


			}

		}

	}

}

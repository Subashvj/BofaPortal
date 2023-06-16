package com.pointel.bofa.strategy.portal.app.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dto.TaskBean;
import com.pointel.bofa.strategy.portal.app.dto.MasterData;
import com.pointel.bofa.strategy.portal.app.dto.MilestoneInfo;
import com.pointel.bofa.strategy.portal.app.dto.PhaseInfo;
import com.pointel.bofa.strategy.portal.app.entity.StratTasks;
import com.pointel.bofa.strategy.portal.app.dto.UserDataInfo;
import com.pointel.bofa.strategy.portal.app.repository.MilestoneInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.PhaseInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratTasksRepository;
import com.pointel.bofa.strategy.portal.app.repository.TaskBeanRepo;
import com.pointel.bofa.strategy.portal.app.repository.UserDataInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.UserInfoRepo;

@Repository
public class TaskDao {
	
	public static Logger logger = LogManager.getLogger(TaskDao.class);
	
	@Autowired
	StratTasksRepository stratTasksRepository;
	
	@Autowired
	UserDataInfoRepo userDataInfoRepo;
	
	@Autowired
	PhaseInfoRepo phaseInfoRepo;
	
	@Autowired
	MilestoneInfoRepo milestoneInfoRepo;
	
	@Autowired
	MasterData masterData;
	
	@Autowired
	TaskBeanRepo taskBeanRepo;
	
	
	public BigInteger saveTask(StratTasks stratTask) throws Exception {
		logger.info("Entered into TaskDao saveTask input data : "+stratTask.toString());
		StratTasks result = stratTasksRepository.save(stratTask);
		System.out.println("Task dao "+result.getTaskId());
		return result.getTaskId();
	}


	public BigInteger editTask(StratTasks newTask) {
		
		logger.info("Entered into TaskDao editTask input data : "+newTask.toString());
		
		StratTasks oldTask = stratTasksRepository.getById(newTask.getTaskId());
		oldTask.setTaskStrat(newTask.getTaskStrat());
		oldTask.setTaskDue(newTask.getTaskDue());
		oldTask.setTaskPercent(newTask.getTaskPercent());
		oldTask.setTaskStatusId(newTask.getTaskStatusId()); 
		oldTask.setMileStoneId(newTask.getMileStoneId());
		oldTask.setStratPhaseId(newTask.getStratPhaseId());
		oldTask.setTaskNotes(newTask.getTaskNotes());
		logger.info("Modified task data "+oldTask.toString());
		StratTasks result = stratTasksRepository.save(oldTask);
		
		return result.getTaskId();
		
	}


	public MasterData getMasterData() throws JsonProcessingException {
		
		logger.info("Entered into TaskDao getMasterData input data : ");
		
		List<UserDataInfo> userData = userDataInfoRepo.restrieveUserInfoData();
		logger.info("UserDataInfo data : "+userData);
		
		List<PhaseInfo> phaseResult =  phaseInfoRepo.restrievePhaseInfoData();
		logger.info("PhaseInfo data : "+phaseResult);
		
		List<MilestoneInfo> milestoneResult = milestoneInfoRepo.restrieveMilestoneInfoData();
		logger.info("MilestoneInfo data : "+milestoneResult);
		
		
		masterData.setUserData(userData);
		masterData.setPhaseInfo(phaseResult);
		masterData.setMilestoneData(milestoneResult);
		
		
		System.out.println("user result "+ new ObjectMapper().writeValueAsString(userData) );
		
		System.out.println("pahse result "+ new ObjectMapper().writeValueAsString(phaseResult) );
		
		System.out.println("milestone result "+ new ObjectMapper().writeValueAsString(milestoneResult) );
		
		return masterData;
	}


	public List<TaskBean> getTask(int stratId) {
		
		logger.info("Entered into TaskDao getTask input data : "+stratId);
		List<TaskBean> result = taskBeanRepo.retrieveTaskBeanData(stratId);
		logger.info("Result from getTask : "+result.toString());
		return result;
	}

}

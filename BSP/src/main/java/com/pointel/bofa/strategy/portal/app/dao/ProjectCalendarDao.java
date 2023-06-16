package com.pointel.bofa.strategy.portal.app.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pointel.bofa.strategy.portal.app.dto.HolidaycalInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.OnCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.ProjectCalInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratCallInfo;
import com.pointel.bofa.strategy.portal.app.repository.HolidaycallInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.InstallCallInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.OnCallInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.ProjectCalInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratCallInfoRepo;

@Component
public class ProjectCalendarDao {
	
	public static Logger logger = LogManager.getLogger(ProjectCalendarDao.class);
	
	@Autowired
	private ProjectCalInfoRepo projectCallInfoRepo;
	
	@Autowired
	private OnCallInfoRepo onCallInfoRepo;
	
	@Autowired
	private HolidaycallInfoRepo holidaycallInfoRepo;
	
	@Autowired
	private InstallCallInfoRepo InstallCallInfoRepo;
	
	@Autowired
	private StratCallInfoRepo StratCallInfoRepo;
	
	
	public List<ProjectCalInfo> getProjectCallInfo(String startDate,String endDate){
		logger.info("Entered into ProjectCalendarDao getProjectCallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);
		List<ProjectCalInfo> result = projectCallInfoRepo.retrieveProjectCalData(startDate, endDate);
		logger.info("getProjectCallInfo result data "+result );
		
		return result;
	}
	
	public List<OnCallInfo> getOncallInfo(String startDate , String endDate){
		logger.info("Entered into ProjectCalendarDao getOncallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);
		List<OnCallInfo> result = onCallInfoRepo.retrieveOncallInfoData(startDate, endDate);
		logger.info("getOncallInfo result data "+result );
		
		return result; 
	}

	public List<HolidaycalInfo> getHolidaycallInfo(String startDate,String endDate){
		logger.info("Entered into ProjectCalendarDao getHolidaycallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);
		List<HolidaycalInfo> result = holidaycallInfoRepo.retrieveHolidaycallInfoData(startDate,endDate);
		logger.info("getHolidaycallInfo result data "+result );
		
		return result; 
		
	}
	
	public List<InstallCallInfo> getInstallCallInfo(String startDate,String endDate){
		logger.info("Entered into ProjectCalendarDao getInstallCallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);
		List<InstallCallInfo> result  = InstallCallInfoRepo.retrieveInstallCallInfoData(startDate, endDate);
		logger.info("getInstallCallInfo result data "+result );
		
		return result;
		
	}
	

	public List<StratCallInfo> getStratCallInfo(String startDate , String endDate){
		logger.info("Entered into ProjectCalendarDao getStratCallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);
		
		List<StratCallInfo> result  = StratCallInfoRepo.retrieveInstallCallInfoData(startDate,endDate);
		logger.info("getStratCallInfo result data "+result );
		
		return result; 
	}

}

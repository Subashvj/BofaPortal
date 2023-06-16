package com.pointel.bofa.strategy.portal.app.dao;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pointel.bofa.strategy.portal.app.dto.HolidaycalInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.UserCalInfo;
import com.pointel.bofa.strategy.portal.app.repository.HolidaycallInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.InstallCallInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.UserCalInfoRepo;


@Component
public class ProjectDao {
	public static Logger logger = LogManager.getLogger(ProjectDao.class);
	@Autowired
	private UserCalInfoRepo userCalInfoRepo;
	
	
	@Autowired
	private HolidaycallInfoRepo holidaycallInfoRepo;
	
	@Autowired
	private InstallCallInfoRepo InstallCallInfoRepo;
	
	
	public List<HolidaycalInfo> getHolidaycallInfo(String startDate,String endDate){
		logger.info("Entered into ProjectDao getHolidaycallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data start date "+endDate);
		List<HolidaycalInfo> result = holidaycallInfoRepo.retrieveHolidaycallInfoData(startDate,endDate);
		logger.info("getHolidaycallInfo result data "+result );
		
		return result;
		
	}
	
	public List<InstallCallInfo> getInstallCallInfo(String startDate,String endDate){
		logger.info("Entered into ProjectDao getInstallCallInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data start date "+endDate);
		List<InstallCallInfo> result = InstallCallInfoRepo.retrieveInstallCallInfoData(startDate, endDate);
		logger.info("getInstallCallInfo result data "+result );
		
		return result;
		
	}
	
	public List<UserCalInfo> getUserCalInfo(String startDate,String endDate){
		logger.info("Entered into ProjectDao getUserCalInfo");
		logger.info("Input data start date "+startDate);
		logger.info("Input data start date "+endDate);
		List<UserCalInfo> result = userCalInfoRepo.retrieveUserCalInfoData(startDate, endDate);
		logger.info("getInstallCallInfo result data "+result );
		
		return result; 
		
	}
	
	

}

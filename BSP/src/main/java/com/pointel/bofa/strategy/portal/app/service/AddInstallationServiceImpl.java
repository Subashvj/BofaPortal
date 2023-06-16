package com.pointel.bofa.strategy.portal.app.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.controller.TeamMembersController;
import com.pointel.bofa.strategy.portal.app.dto.InstallEnvironmentInfo;
import com.pointel.bofa.strategy.portal.app.dto.RequestAddInstall;
import com.pointel.bofa.strategy.portal.app.entity.AddInstallation;
import com.pointel.bofa.strategy.portal.app.entity.InstallTypesInfo;
import com.pointel.bofa.strategy.portal.app.repository.AddInstallationRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallEnvironmentRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallionTypeRepository;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;
@Service
public class AddInstallationServiceImpl implements AddInstallationService{
	public static Logger logger = LogManager.getLogger(AddInstallationServiceImpl.class);
	@Autowired
	InstallEnvironmentRepository installEnvironmentRepository;
	@Autowired
	InstallionTypeRepository installionTypeRepository;
	@Autowired
	AddInstallationRepository addInstallationRepository;
	@Autowired
	ResponseMessage responseMessage;
	@Value("${userid}")
	private String userId;
	@Override
	public List<InstallEnvironmentInfo> getInstalltionEnvironmetInfo() {
		logger.info("[BSP]:getInstalltionEnvironmetInfo() - Service Insertion Process Started");
		List<InstallEnvironmentInfo> installEnvironmentInfos = installEnvironmentRepository.environmentInfo();
		logger.info("[BSP]:getInstalltionEnvironmetInfo() - Service Insertion Process Ended");
;		return installEnvironmentInfos;
	}


	@Override
	public List<InstallTypesInfo> getInstallTypeInfo() {
		logger.info("[BSP]:getInstallTypeInfo() - Service Insertion Process Started");
		List<InstallTypesInfo> typesInfos = installionTypeRepository.findAll();
		logger.info("[BSP]:getInstallTypeInfo() - Service Insertion Process Ended");
		return typesInfos;
	}

	
	@Transactional
	public ResponseMessage addInstallation(RequestAddInstall requestAddInstall) throws Exception {
		logger.info("[BSP]:addInstallation() - Service Insertion Process Started");
		AddInstallation addInstallation = new AddInstallation();

		String[] startTime = (requestAddInstall.getStartTime()).split(":");
		int startHoursAndMinutes = (Integer.parseInt(startTime[0]) * 60) + Integer.parseInt(startTime[1]);
		String[] endTime = (requestAddInstall.getEndTime()).split(":");
		int endHoursAndMinutes = (Integer.parseInt(endTime[0]) * 60) + Integer.parseInt(endTime[1]);
		System.out.println("startHoursAndMinutes" + startHoursAndMinutes);
		System.out.println("endHoursAndMinutes" + endHoursAndMinutes);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		String installDateTextone = requestAddInstall.getInstallationDate();
		Date one = format.parse(installDateTextone);
		LocalDateTime startTime1 = one.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				.plusMinutes(startHoursAndMinutes);
		Date installDate = Date.from(startTime1.atZone(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqldate= new java.sql.Date(installDate.getTime());
		System.out.println("Date_Start:" + installDate);

		LocalDateTime endTime1 = one.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				.plusMinutes(endHoursAndMinutes);
		Date installEnd = Date.from(endTime1.atZone(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqlEnd= new java.sql.Date(installEnd.getTime());
		System.out.println("Date_Start:" + installEnd);

		addInstallation.setInstallDate(sqldate);
		addInstallation.setInstallEnd(sqlEnd);
		addInstallation.setCreateDate(new Date());
		addInstallation.setInstallOwner(userId);
		addInstallation.setInstallTitle(requestAddInstall.getTitle());
		addInstallation.setCabNum(requestAddInstall.getCabNum());
		addInstallation.setCabStatus(0);
		addInstallation.setBundleName("");
		addInstallation.setInstallStatusId(1);
		addInstallation.setInstEnvId(requestAddInstall.getEnvironment());
		addInstallation.setInstallType(requestAddInstall.getInstallationType());

		addInstallationRepository.save(addInstallation);
		responseMessage.setSuccess(true);
		logger.info("[BSP]:addInstallation() - Service Insertion Process Ended");
		return responseMessage;
	}
}

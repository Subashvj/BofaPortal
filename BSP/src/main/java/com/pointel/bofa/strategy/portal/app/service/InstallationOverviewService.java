package com.pointel.bofa.strategy.portal.app.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.entity.Installs;
import com.pointel.bofa.strategy.portal.app.dto.RequestUpdateInstallationOverview;
import com.pointel.bofa.strategy.portal.app.repository.InstallsRepo;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class InstallationOverviewService {

	public static Logger logger = LogManager.getLogger(InstallationOverviewService.class);
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Autowired
	InstallsRepo installsRepo;
	
	@Transactional
	public ResponseMessage updateInstallationOverview(RequestUpdateInstallationOverview 
			request) throws Exception{
		logger.info("[BSP]:updateInstallationOverview() - Service Insertion Process Started");
		int installId = request.getInstallId();
		
		Installs installs = installsRepo.findById(installId).orElse(null);
		logger.info("[BSP]:updateInstallationOverview(): Installs Entity {}",installs.toString());
		if(installs != null) {
			installs.setInstallTitle(request.getInstallTitle());
			installs.setInstallDate(request.getInstallDate());
			installs.setInstallStatusId(request.getInstallStatusId());
			installs.setInstallType(request.getInstallType());
			installs.setInstEnvId(request.getInstEnvId());
			installs.setInstallOwnergroup(request.getInstallOwnergroup());
			installs.setCabNum(request.getCabNum());
			installs.setCabStatus(request.getCabStatus());
			installs.setCabApprovalDate(request.getCabApprovalDate());
			installsRepo.save(installs);
			responseMessage.setSuccess(true);;
			logger.info("[BSP]:updateInstallationOverview() - Data updated Successfully for InstallId:{}",installId);
		}else {
			logger.info("[BSP]:updateInstallationOverview() - Data not found for InstallId:{}",installId);
			responseMessage.setSuccess(false);;
		}
		return responseMessage;
		
	}
}

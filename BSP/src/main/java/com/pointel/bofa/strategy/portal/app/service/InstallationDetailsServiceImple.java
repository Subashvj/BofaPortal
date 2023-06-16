package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dto.InstallFilesInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallHistoryInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallLinked;
import com.pointel.bofa.strategy.portal.app.dto.InstallMilestoneInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallProductInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallTechInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallTypes;
import com.pointel.bofa.strategy.portal.app.dto.InstallationMilestone;
import com.pointel.bofa.strategy.portal.app.dto.InstallationOverview;
import com.pointel.bofa.strategy.portal.app.dto.InstallationTasks;
import com.pointel.bofa.strategy.portal.app.dto.UsersInfo;
import com.pointel.bofa.strategy.portal.app.entity.CabStatus;
import com.pointel.bofa.strategy.portal.app.entity.EstimateGroups;
import com.pointel.bofa.strategy.portal.app.entity.InstallEnvironments;
import com.pointel.bofa.strategy.portal.app.entity.InstallStatuses;
import com.pointel.bofa.strategy.portal.app.repository.CabStatusInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.EstimateGroupsInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.InstallFilesRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallHistoryRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallLinkedRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallMilestoneRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallProductRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallStatusesInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.InstallTechRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallTypesRepo;
import com.pointel.bofa.strategy.portal.app.repository.InstallationMilestoneRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallationOverviewRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallationTasksRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstalltionsEnvironmentsInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.UsersInfoRepository;
@Service
public class InstallationDetailsServiceImple implements InstallationDetailsService{
	private static final Logger logger = LogManager.getLogger(InstallationDetailsServiceImple.class);
	@Autowired
	InstallMilestoneRepository installMilestoneRepository;
	@Autowired
	InstallTechRepository installTechRepository;
	@Autowired 
	InstallProductRepository installProductRepository;
	@Autowired
	InstallFilesRepository installFilesRepository;
	@Autowired
	UsersInfoRepository  usersInfoRepository;
	
	@Autowired
	InstallationOverviewRepository installationOverviewRepository;
	
	@Autowired
	InstallLinkedRepository installLinkedRepository;
	
	@Autowired
	InstallationTasksRepository installationTasksRepository;
	
	@Autowired
	InstallationMilestoneRepository installationMilestoneRepository;
	@Autowired
	InstallHistoryRepository installHistoryRepository;
	@Autowired
	InstallTypesRepo installTypesRepo;
	
	@Autowired
	InstallStatusesInfoRepo installStatusesInfoRepo;
	
	@Autowired 
	InstalltionsEnvironmentsInfoRepo installEnvironmentinfosRepo;
	
	@Autowired
	EstimateGroupsInfoRepo estimateGroupsInfoRepo;
	
	@Autowired
	CabStatusInfoRepo cabStatusInfoRepo;
	
	@Override
	public List<InstallMilestoneInfo> getInstallMilestoneInfo(int installId) {
		logger.info("[BSP]:InstallMilestoneInfo() - Method call started");
		logger.info("Input data :"+installId);
		List<InstallMilestoneInfo> installmilestoneInfos = null;
		installmilestoneInfos = installMilestoneRepository.installMilestoneInfos(installId);
		logger.info("[BSP]:InstallMilestoneInfo() - Method call ended");
		return installmilestoneInfos;
	}

	@Override
	public List<InstallTechInfo> getInstallTechInfo(int installId) throws Exception {
		logger.info("[BSP]:getInstallTechInfo() - Method call started");
		logger.info("Input data :"+installId);
		List<InstallTechInfo> installTechinfo=null;
		installTechinfo = installTechRepository.techInfos(installId);
		logger.info("[BSP]:getInstallTechInfo() - Method call ended");
		return installTechinfo;
	}

	@Override
	public List<InstallProductInfo> getInstallProductInfo(int installId) throws Exception {
		logger.info("[BSP]:getInstallProductInfo() - Method call started");
		logger.info("Input data :"+installId);
		List<InstallProductInfo> installProductinfo = null;
		installProductinfo = installProductRepository.productInfos(installId);
		logger.info("[BSP]:getInstallProductInfo() - Method call ended");
		return installProductinfo;
	}

	@Override
	public List<InstallFilesInfo> getInstallFileinfo(int typeId) throws Exception {
		logger.info("[BSP]:getInstallFileinfo() - Method call started");
		logger.info("Input data :typeId:"+typeId);
		List<InstallFilesInfo> installFilesinfo = installFilesRepository.filesInfos( typeId);
		logger.info("[BSP]:getInstallFileinfo() - Method call ended");
		return installFilesinfo;
	}

	@Override
	public List<UsersInfo> getUsersInfo(int installId) throws Exception {
		logger.info("[BSP]:getUsersInfo() - Method call started");
		logger.info("Input data : installId : "+installId);
		List<UsersInfo> usersinf = usersInfoRepository.usersInfos(installId);
		logger.info("[BSP]:getUsersInfo() - Method call ended");
		return usersinf;
	}
	
	//jayakumar
	@Override
	public List<InstallationOverview> getInstallationOverview(int installId) throws Exception{
		logger.info("[BSP]:getInstallationOverviewInfo() - Service method call Started");
		logger.info("[BSP]:getInstallationOverviewInfo() - Input Data Install_Id:{}",installId);
		List<InstallationOverview> installationOverview = 
				installationOverviewRepository.getInstallationOverviewInfo(installId);
		logger.info("[BSP]:getInstallationOverviewInfo() - Service method call Ended");
		return installationOverview;
	}
	
	@Override
	public List<InstallLinked> getInstallLinked(int installId) throws Exception{
		logger.info("[BSP]:getInstallLinked() - Service method call Started");
		logger.info("[BSP]:getInstallLinked() - Input Data Install_Id:{}",installId);
		List<InstallLinked> installLinked = installLinkedRepository.getInstallLinked(installId);
		logger.info("[BSP]:getInstallLinked() - Service method call Ended");
		return installLinked;	
	}
	
	@Override
	public List<InstallationTasks> getInstallationTasks(int installId) throws Exception{
		logger.info("[BSP]:getInstallationTasks() - Service method call Started");
		logger.info("[BSP]:getInstallationTasks() - Input Data Install_Id:{}",installId);
		List<InstallationTasks> installationTasks = installationTasksRepository.getInstallTasksInfo(installId);
		logger.info("[BSP]:getInstallationTasks() - Service method call Ended");
		return installationTasks;	
	}
	
	@Override
	public List<InstallationMilestone> getInstallationMilestone(int installId) throws Exception{
		logger.info("[BSP]:getInstallationMilestone() - Service method call Started");
		logger.info("[BSP]:getInstallationMilestone() - Input Data Install_Id:{}",installId);
		List<InstallationMilestone> installationMilestone = 
				installationMilestoneRepository.getInstallationMilestoneInfo(installId);
		logger.info("[BSP]:getInstallationMilestone() - Service method call Ended");
		return installationMilestone;	
	}

	@Override
	public List<InstallHistoryInfo> getInstallHistory(int installId) throws Exception {
		logger.info("[BSP]:getInstallationMilestone() - Service method call Started");
		logger.info("[BSP]:getInstallationMilestone() - Input Data Install_Id:{}",installId);
		List<InstallHistoryInfo> installahistoryInf = 
				installHistoryRepository.historyInfos(installId);
		logger.info("[BSP]:getInstallationMilestone() - Service method call Ended");
		return installahistoryInf;	
	}

	@Override
	public List<InstallTypes> getInstallTypesInfo() throws Exception {
		logger.info("[BSP]:getInstallTypesInfo()");
		List<InstallTypes> installTypesInf = installTypesRepo.typesInfos();
		logger.info("[BSP]:getInstallationMilestone() - Service method call Ended");
		return installTypesInf;	
	}

	@Override
	public List<InstallStatuses> getInstallationStauts() throws Exception{
		logger.info("[BSP]:getInstallationStauts() - Service method call Started");
		List<InstallStatuses> installStatuses = installStatusesInfoRepo.findAll();
		logger.info("[BSP]:getInstallationStauts() - Service method call Ended");
		return installStatuses;	
	}
	
	@Override
	public List<InstallTypes> getInstallationTypes() throws Exception{
	  logger.info("[BSP]:getInstallationTypes() - Service method call Started");
	  List<InstallTypes> installTypes=installTypesRepo.findAll();
	  logger.info("[BSP]:getInstallationTypes() - Service method call Ended");
	  return installTypes;
	}
	
	@Override
	public List<InstallEnvironments> getInstallEnvironments() throws Exception{
		logger.info("[BSP]:getInstallationTypes() - Service method call Started");
		 List<InstallEnvironments> installEnvironments =installEnvironmentinfosRepo.findByInstEnvVisible(1); 
		 logger.info("[BSP]:getInstallationTypes() - Service method call Ended");
		 return installEnvironments;	 
	}
	
	@Override
	public List<EstimateGroups> getTechOwner() throws Exception{
		logger.info("[BSP]:getTechOwner() - Service method call Started");
		List<EstimateGroups> estimateGroups = estimateGroupsInfoRepo.getEstimateGrp();
		logger.info("[BSP]:getTechOwner() - Service method call Ended");
		return estimateGroups;
	}
	
	@Override
	public List<CabStatus> getCabStatus() throws Exception{
		logger.info("[BSP]:getCabStatus() - Service method call Started");
		List<CabStatus> cabStatus = cabStatusInfoRepo.getCabStatus();
		logger.info("[BSP]:getCabStatus() - Service method call Ended");
		return cabStatus;	
	}
	

}
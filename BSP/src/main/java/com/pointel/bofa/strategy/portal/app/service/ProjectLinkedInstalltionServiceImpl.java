package com.pointel.bofa.strategy.portal.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.repository.CurrentInstallationIdRepo;
import com.pointel.bofa.strategy.portal.app.repository.DeleteStratToInstallRepository;
import com.pointel.bofa.strategy.portal.app.repository.InstallHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratToInstallRepo;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.RequestUpdateAndDeleteInstallation;
import com.pointel.bofa.strategy.portal.app.entity.CurrentInstallationId;
import com.pointel.bofa.strategy.portal.app.entity.InstallHistory;
import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.entity.StratToInstall;
import com.pointel.bofa.strategy.portal.app.repository.LinkedInstallEditRepository;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;
@Service
public class ProjectLinkedInstalltionServiceImpl implements ProjectlinkedInstalltionService {
	private static final Logger logger = LogManager.getLogger(ProjectLinkedInstalltionServiceImpl.class);
	@Autowired
	LinkedInstallEditRepository linkedInstallEditRepository;
	@Autowired
	StratToInstallRepo stratToInstallRepo;
	
	@Autowired
	StratHistoryRepo stratHistoryRepo;
	@Autowired
	ResponseMessage responseMessage;
	
	@Autowired
	CurrentInstallationIdRepo currentInstallationIdRepo;
	@Autowired
	DeleteStratToInstallRepository deleteStratToInstallRepository;
	
	@Autowired
	InstallHistoryRepo installHistoryRepo;
	@Value("${userid}")
	private String userId;
	
	
	@Override
	public List<LinkedInstalltionEditInfo> getLinkedInstallEdit(int stratId) {
		logger.info("Entered into ProjectDetailsServiceimpl getApprovals input data :" + stratId);
		List<LinkedInstalltionEditInfo> infos = linkedInstallEditRepository.editInfos(stratId);
		logger.info("getTechComponents result  data :" + infos.toString());
		return infos;
	}
	@Transactional
	public ResponseMessage updateAndDeleteInstallation(
			RequestUpdateAndDeleteInstallation requestUpdateAndDeleteInstallation) throws Exception {
		logger.info("[BSP]:updateAndDeleteInstallation() - Service Insertion Process Started");
		CurrentInstallationId currentInstallationId = null;
		int stratId = requestUpdateAndDeleteInstallation.getStratId();
		int[] newArray = requestUpdateAndDeleteInstallation.getNewInstall();
		logger.info("[BSP]: updateAndDeleteInstallation() - new InstallId fromRequest:{}",newArray.toString());
		currentInstallationId = currentInstallationIdRepo.retrieveCurrentInstallationId(stratId);
		String[] installIdTotal = currentInstallationId.getInstallId().split(",");

		List<Integer> installId =new ArrayList<>();
		for (String installid : installIdTotal) {
			installId.add(Integer.parseInt(installid));
		}
		System.out.println("installId" + installId.toString());
		logger.info("[BSP]: updateAndDeleteInstallation() - Already Stored InstallId:{}",installId.toString());
		
		//update - InstallId
		List<Integer> updateInst = new ArrayList<>();
		for (int insId : newArray) {
			if (!(installId.contains(insId))) {
				updateInst.add(insId);
			}
		}
		System.out.println("updateInst:" + updateInst);
		logger.info("[BSP]:updateAndDeleteInstallation() - install Id to Update:{}",updateInst.toString());

		//Insert data to strat_to_install table.
		List<StratToInstall> startToInstallList = new ArrayList<>();
		for (int inst : updateInst) {
			StratToInstall stratToInstall = new StratToInstall();
			stratToInstall.setInstallId(inst);
			stratToInstall.setStratId(stratId);
			Date date = new Date();
			java.sql.Date sqldate= new java.sql.Date(date.getTime());
			stratToInstall.setLinkDate(sqldate);
			stratToInstall.setLinkBy(userId);
			startToInstallList.add(stratToInstall);
		}
		stratToInstallRepo.saveAll(startToInstallList);
		
		//Insert data to strat_History table.
		List<StratHistory> stratHistoryListUpdate = new ArrayList<>();
		for(int inst:updateInst) {
			StratHistory  stratHistory = new StratHistory();
			stratHistory.setComment_(
					"<span class='text-danger text-uppercase'>Removed </span> from installation #<a href='install_details.php?install_id='"
							+ String.valueOf(inst) + "'target='_blank''>" + String.valueOf(inst) + "</a>");
			stratHistory.setNewStatusId(11);
			Date date = new Date();
			java.sql.Date sqldate= new java.sql.Date(date.getTime());
			stratHistory.setFdate(sqldate);
			stratHistory.setStratId(stratId);
			stratHistory.setUserid(userId);
			stratHistoryListUpdate.add(stratHistory);
		}
		stratHistoryRepo.saveAll(stratHistoryListUpdate);
		
		//Insert data to Install_History table.
		List<InstallHistory> installHistoryListUpdate = new ArrayList<>();
		for(int inst:updateInst) {
			InstallHistory installHistory = new InstallHistory();
			installHistory.setComment_(
					"<span class='text-danger text-uppercase'>Removed </span> project #<a href='project_details.php?proj_id='"
							+ String.valueOf(stratId) + "'target='_blank''>" + String.valueOf(stratId)
							+ "</a> from this installation.");
			installHistory.setNewStatusId(12);
			Date date = new Date();
			java.sql.Date sqldate= new java.sql.Date(date.getTime());
			installHistory.setFdate(sqldate);
			installHistory.setUserid(userId);
			installHistory.setInstallId(inst);
			installHistoryListUpdate.add(installHistory);
		}
		installHistoryRepo.saveAll(installHistoryListUpdate);

		// delete-installId
		List<Integer> deletedOne = new ArrayList<>();
		for (int ins : newArray) {
			if (installId.contains(ins)) {
				deletedOne.add(ins);
			}
		}
		installId.removeAll(deletedOne);
		System.out.println("deletedInst:" + installId);
		logger.info("[BSP]:updateAndDeleteInstallation() - install Id to Delete:{}",installId.toString());

		//Delete Install Ids from strat_to_install table. 
		for (int inst : installId) {
			deleteStratToInstallRepository.deleteUpdateInstalltionInfo(stratId, inst);
			System.out.println("installId:" + inst);
		}
		
		System.out.println("InstallIdList:" + installId);
		System.out.println("InstallIdList:" + installId.size());
		
		//Insert data to strat_History table.
		List<StratHistory> stratHistoryList = new ArrayList<>();
		for (int inst : installId) {
			StratHistory  stratHistory = new StratHistory();
			stratHistory.setComment_(
					"<span class='text-danger text-uppercase'>Removed </span> from installation #<a href='install_details.php?install_id='"
							+ String.valueOf(inst) + "'target='_blank''>" + String.valueOf(inst) + "</a>");
			stratHistory.setNewStatusId(11);
			Date date = new Date();
			java.sql.Date sqldate= new java.sql.Date(date.getTime());
			stratHistory.setFdate(sqldate);
			stratHistory.setStratId(stratId);
			stratHistory.setUserid(userId);
			stratHistoryList.add(stratHistory);
		}
		stratHistoryRepo.saveAll(stratHistoryList);

		//Insert data to Install_History table.
		List<InstallHistory> installHistoryList = new ArrayList<>();
		for (int inst : installId) {
			InstallHistory installHistory = new InstallHistory();
			installHistory.setComment_(
					"<span class='text-danger text-uppercase'>Removed </span> project #<a href='project_details.php?proj_id='"
							+ String.valueOf(stratId) + "'target='_blank''>" + String.valueOf(stratId)
							+ "</a> from this installation.");
			installHistory.setNewStatusId(12);
			Date date = new Date();
			java.sql.Date sqldate= new java.sql.Date(date.getTime());
			installHistory.setFdate(sqldate);
			installHistory.setUserid(userId);
			installHistory.setInstallId(inst);
			installHistoryList.add(installHistory);
		}
		installHistoryRepo.saveAll(installHistoryList);

		responseMessage.setSuccess(true);
		logger.info("[BSP]:updateAndDeleteInstallation() - Service Insertion Process Ended");
		return responseMessage;

	}
}

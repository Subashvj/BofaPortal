package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

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

public interface InstallationDetailsService {
 
	List<InstallMilestoneInfo> getInstallMilestoneInfo(int installId)throws Exception;
	List<InstallTechInfo> getInstallTechInfo(int installId)throws Exception;
	List<InstallProductInfo> getInstallProductInfo(int installId)throws Exception;
	List<InstallFilesInfo> getInstallFileinfo(int typeId)throws Exception;
	List<UsersInfo> getUsersInfo(int installId)throws Exception;
	List<InstallHistoryInfo>getInstallHistory(int installId)throws Exception;
	List<InstallTypes> getInstallTypesInfo()throws Exception; 
	
	//jayakumar
	public List<InstallationOverview> getInstallationOverview(int installId) throws Exception;
	public List<InstallLinked> getInstallLinked(int installId) throws Exception;
	public List<InstallationTasks> getInstallationTasks(int installId) throws Exception;
	public List<InstallationMilestone> getInstallationMilestone(int installId) throws Exception;
	
	public List<InstallStatuses> getInstallationStauts() throws Exception;
	public List<InstallTypes> getInstallationTypes() throws Exception;
	public List<InstallEnvironments> getInstallEnvironments() throws Exception;
	public List<EstimateGroups> getTechOwner() throws Exception;
	public List<CabStatus> getCabStatus() throws Exception;
}

package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;
import java.util.Map;

import com.pointel.bofa.strategy.portal.app.dao.OverviewInfo;
import com.pointel.bofa.strategy.portal.app.dto.ApprovalsCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.Cti;
import com.pointel.bofa.strategy.portal.app.dto.HistoryInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedProducts;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstallation;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.LobsInfo;
import com.pointel.bofa.strategy.portal.app.dto.Milestones;
import com.pointel.bofa.strategy.portal.app.dto.NotesDevlopmentInfo;
import com.pointel.bofa.strategy.portal.app.dto.NotesTestInfo;
import com.pointel.bofa.strategy.portal.app.dto.PmInfo;
import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.ResourcePlan;
import com.pointel.bofa.strategy.portal.app.dto.Rminfo;
import com.pointel.bofa.strategy.portal.app.dto.ScopeResponse;
import com.pointel.bofa.strategy.portal.app.dto.StatusInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratPhases;
import com.pointel.bofa.strategy.portal.app.dto.TasksInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMembers;
import com.pointel.bofa.strategy.portal.app.dto.TechComponents;
import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.Typesinfo;

public interface ProjectDetailsService {

	List<HistoryInfo> getHistoryInfo(int stratId)throws Exception;
	List<Rminfo> getRmInfo(int stratId) throws Exception;
	List<OverviewInfo> getOverviewInfo(int stratId)throws Exception;
	List<NotesDevlopmentInfo> getDevelopmentNotesInfo(int stratId)throws Exception;
	List<NotesTestInfo> getTestNotes(int stratId)throws Exception;
	List<Typesinfo> getTypesinfo() throws Exception;
	List<StatusInfo> getStatusinfo()throws Exception;
	List<StratPhases> getStratPhasesinfo()throws Exception;
	List<LobsInfo> getLobsList()throws Exception;
   
	
	//jayakumar
	public List<TasksInfo> getTasks(int StratId) throws Exception;
	public ScopeResponse getScope(int StratId) throws Exception;
	public List<PmInfo> getPm(int StratId,String userId) throws Exception;
	public Map getFiles(int typeId) throws Exception;
	
	//Aravindh
	public List<LinkedInstallation> getLinkedInstallation(int stratId) throws Exception;
	public List<TeamMembers> getTeamMembers(int stratId) throws Exception;
	public List<Milestones> getMileStones(int stratId) throws Exception;
	public List<ImpactedProducts> getProduct(int stratId) throws Exception;
	public List<RecommendedMembers> getMembers(int stratId) throws Exception;
	public List<TechComponents> getTechComponents(int stratId) throws Exception;
	public List<ApprovalsCallInfo> getApprovals(int stratId) throws Exception;
	public List<ResourcePlan> getResourcePlan(int strat_id) throws Exception;
	public List<Cti> getCti(int strat_id) throws Exception;
	
}

package com.pointel.bofa.strategy.portal.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.pointel.bofa.strategy.portal.app.controller.ProjectDetailsControllerImple;
import com.pointel.bofa.strategy.portal.app.dao.OverviewInfo;
import com.pointel.bofa.strategy.portal.app.dao.ProjectDetailsDao;
import com.pointel.bofa.strategy.portal.app.dto.ApprovalsCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactProgress;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactProgressUsers;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactResponse;
import com.pointel.bofa.strategy.portal.app.dto.Cti;
import com.pointel.bofa.strategy.portal.app.dto.Files;
import com.pointel.bofa.strategy.portal.app.dto.HistoryInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedProducts;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstallation;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.LobsInfo;
import com.pointel.bofa.strategy.portal.app.dto.Milestones;
import com.pointel.bofa.strategy.portal.app.dto.Notes;
import com.pointel.bofa.strategy.portal.app.dto.NotesDevlopmentInfo;
import com.pointel.bofa.strategy.portal.app.dto.NotesInstallInfo;
import com.pointel.bofa.strategy.portal.app.dto.NotesTestInfo;
import com.pointel.bofa.strategy.portal.app.dto.PmInfo;
import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.RecusersInfo;
import com.pointel.bofa.strategy.portal.app.dto.ResourcePlan;
import com.pointel.bofa.strategy.portal.app.dto.Rminfo;
import com.pointel.bofa.strategy.portal.app.dto.ScopeAnalytics;
import com.pointel.bofa.strategy.portal.app.dto.ScopeDesign;
import com.pointel.bofa.strategy.portal.app.dto.ScopeResponse;
import com.pointel.bofa.strategy.portal.app.dto.ScopeTesting;
import com.pointel.bofa.strategy.portal.app.dto.StatusInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratPhases;
import com.pointel.bofa.strategy.portal.app.dto.TasksInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMembers;
import com.pointel.bofa.strategy.portal.app.dto.TechComponents;
import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.Typesinfo;
import com.pointel.bofa.strategy.portal.app.entity.StratToInstall;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactProgressRepository;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactProgressUsersRepository;
import com.pointel.bofa.strategy.portal.app.repository.FilesRepository;
import com.pointel.bofa.strategy.portal.app.repository.HistoryInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.ImpactedComponentsRepository;
import com.pointel.bofa.strategy.portal.app.repository.LinkedInstallEditRepository;
import com.pointel.bofa.strategy.portal.app.repository.LobsRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyTasksRepository;
import com.pointel.bofa.strategy.portal.app.repository.NotesDevlopmentRepository;
import com.pointel.bofa.strategy.portal.app.repository.NotesInstallRepository;
import com.pointel.bofa.strategy.portal.app.repository.NotesRepository;
import com.pointel.bofa.strategy.portal.app.repository.NotesTestRepository;
import com.pointel.bofa.strategy.portal.app.repository.OverviewRepository;
import com.pointel.bofa.strategy.portal.app.repository.PmRepository;
import com.pointel.bofa.strategy.portal.app.repository.RecusersListRepository;
import com.pointel.bofa.strategy.portal.app.repository.RecusersRepository;
import com.pointel.bofa.strategy.portal.app.repository.RmInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.ScopeAnalyticsRepository;
import com.pointel.bofa.strategy.portal.app.repository.ScopeDesignRepository;
import com.pointel.bofa.strategy.portal.app.repository.ScopeTestingRepository;
import com.pointel.bofa.strategy.portal.app.repository.StatusRepository;
import com.pointel.bofa.strategy.portal.app.repository.StratMembersInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.StratPhasesRepository;
import com.pointel.bofa.strategy.portal.app.repository.TechcomponentsEditRepository;
import com.pointel.bofa.strategy.portal.app.repository.TypesRepo;

@Service
public class ProjectDetailsServiceImple implements ProjectDetailsService {
	@Value("${userid}")
	private String userId;
	private static final Logger logger = LogManager.getLogger(ProjectDetailsServiceImple.class);
	@Autowired
	HistoryInfoRepo historyInfoRepo;
	@Autowired
	RmInfoRepository rmInfoRepository;
	@Autowired
	OverviewRepository overviewRepository;
	@Autowired
	NotesInstallRepository notesInstallRepository;
	@Autowired
	NotesDevlopmentRepository notesDevlopmentRepository;
	@Autowired
	NotesRepository notesRepository;
	@Autowired
	NotesTestRepository notesTestRepository;

	@Autowired
	MyTasksRepository myTasksRepository;

	@Autowired
	ScopeDesignRepository scopeDesignRepository;

	@Autowired
	ScopeTestingRepository scopeTestingRepository;

	@Autowired
	ScopeAnalyticsRepository scopeAnalyticsRepository;

	@Autowired
	PmRepository pmRepository;

	@Autowired
	ProjectDetailsDao projectDetailsDao;

	@Autowired
	FilesRepository filesRepository;

	@Autowired
	ArtifactProgressRepository artifactProgressRepository;

	@Autowired
	ArtifactProgressUsersRepository artifactProgressUsersRepository;
	@Autowired
	LinkedInstallEditRepository linkedInstallEditRepository;

	@Autowired
	TechcomponentsEditRepository techcomponentsEditRepository;

	@Autowired
	ImpactedComponentsRepository impactedComponentsRepository;
	@Autowired
	StratMembersInfoRepository stratMembersInfoRepository;

	@Autowired
	RecusersListRepository recusersListRepository;

	@Autowired
	RecusersRepository recuserRespository;
	@Autowired
     TypesRepo typesRepo;
	@Autowired
	StatusRepository statusRepository;
	@Autowired
    StratPhasesRepository stratPhasesRepository;
	@Autowired
	LobsRepository lobsRepository;

	@Override
	public List<HistoryInfo> getHistoryInfo(int stratId) {
		// TODO Auto-generated method stub
		logger.info("[BSP]:getRm() - Method call started");
		logger.info("Input data :" + stratId);
		List<HistoryInfo> historyInfos = null;
		historyInfos = historyInfoRepo.historyinfos( stratId);
		logger.info("getHistoryInfo result  data :" + historyInfos.toString());
		logger.info("[BSP]:getHistorys() - Method call  Ended");
		return historyInfos;
	}

	@Override
	public List<Rminfo> getRmInfo(int stratId) {
		// TODO Auto-generated method stub
		logger.info("[BSP]:getRm() - Method call started");
		logger.info("Input data :" + stratId);
		List<Rminfo> rminfo = rmInfoRepository.rmInfo(stratId);
		logger.info("getRmInfo result  data :" + rminfo.toString());
		logger.info("[BSP]:getRm() - Method call Ended");
		return rminfo;
	}

	@Override
	public List<OverviewInfo> getOverviewInfo(int stratId) {
		logger.info("[BSP]:getOverviewInfo() - Service method call Started");
		logger.info("Input data :" + stratId, userId);
		String username = userId;
		List<OverviewInfo> overviewinfos = overviewRepository.overviewinf(stratId, username);
		logger.info("getOverviewInfo result  data :" + overviewinfos.toString());
		logger.info("[BSP]:getOverviewInfo() - Service method call Ended");
		return overviewinfos;
	}

	@Override
	public List<NotesDevlopmentInfo> getDevelopmentNotesInfo( int stratId) {
		logger.info("[BSP]:getnotesDevelopmentInfo() - Service method call Started");
		logger.info("Input data :" +stratId);
		List<NotesInstallInfo> installInfos = notesInstallRepository.notesinstallInfo(stratId);
		List<Integer> notesValue = new ArrayList<Integer>();
		for (int i = 0; i < installInfos.size(); i++) {
			int note = installInfos.get(i).getInstallId();
			notesValue.add(note);
			logger.info("[BSP]:notesvalue are :" + note);
		}
		List<NotesDevlopmentInfo> notesDevlopmentInfos = notesDevlopmentRepository.devlopmentInfos(stratId,notesValue);
		logger.info("[BSP]:getnotesDevelopmentInfo() - Service method call Ended");
		return notesDevlopmentInfos;
	}

	@Override
	public List<NotesTestInfo> getTestNotes( int StratId) {
		logger.info("[BSP]:getNoteTest() - Service method call Started");
		logger.info("Input data :" + StratId);
		List<Notes> notes = notesRepository.getNotesInfo(StratId);
		List<Integer> listOfInstallIds = new ArrayList<Integer>();
		for (int i = 0; i < notes.size(); i++) {
			int note = notes.get(i).getInstallId();
			listOfInstallIds.add(note);
			logger.info("[BSP]:listOfInstallIds are :" + note);
		}
		List<NotesTestInfo> notesTest = notesTestRepository.getNotesTestInfo( StratId, listOfInstallIds);
		logger.info("[BSP]:getNoteTest() - Service method call Ended");
		return notesTest;
	}

	// jayakumar

	@Override
	public List<TasksInfo> getTasks(int StratId) throws Exception {
		logger.info("[BSP]:getTasks() - Service method call Started");
		logger.info("Input data :" + StratId);
		List<TasksInfo> taskInfo = myTasksRepository.getTaskInfo(StratId);
		logger.info("[BSP]:getTasks() - Service method call Ended");
		return taskInfo;
	}

	@Override
	public ScopeResponse getScope(int StratId) throws Exception {
		logger.info("[BSP]:getScope() - Service method call Started");
		logger.info("Input data :" + StratId);
		ScopeResponse scopeResponse = new ScopeResponse();
		List<ScopeDesign> scopeDesign = scopeDesignRepository.getScopeDesign(StratId);
		List<ScopeTesting> scopeTesting = scopeTestingRepository.getScopeTesting(StratId);
		List<ScopeAnalytics> scopeAnalytics = scopeAnalyticsRepository.getScopeAnalytics(StratId);
		scopeResponse.setScopeDesign(scopeDesign);
		scopeResponse.setScopeTesting(scopeTesting);
		scopeResponse.setScopeAnalytics(scopeAnalytics);
		logger.info("[BSP]:getScope() - Service method call Ended");
		return scopeResponse;
	}

	@Override
	public List<PmInfo> getPm(int StratId, String userId) throws Exception {
		logger.info("[BSP]:getPm() - Service method call Started");
		logger.info("Input data :" + StratId, userId);
		List<PmInfo> pmInfo = pmRepository.getPmInfo(StratId, userId);
		logger.info("[BSP]:getPm() - Service method call Ended");
		return pmInfo;
	}

	@Override
	public Map getFiles(int typeId) throws Exception {
		logger.info("[BSP]:getFiles() - Service method call Started");
		logger.info("Input TypeId:{}", typeId);
		ArtifactResponse artifactResponse = new ArtifactResponse();
		List<Files> files = filesRepository.getFilesInfo(typeId);
		Map<String, List<Files>> map = new HashMap<>();
		
		for(Files file:files) {
			System.out.println("file name:"+file.getArtifactTypeDesc());
		}
		List<String> uniqueNames = files.stream().map(Files::getArtifactTypeDesc).distinct()
				.collect(Collectors.toList());
		for (String names : uniqueNames) {
			System.out.println("names:" + names);
		}

		for (String name : uniqueNames) {
			List<Files> fileDesc = new ArrayList<>();
			List<Files> home = new ArrayList<>();
			for (Files file : files) {
				if (file.getArtifactTypeDesc() != null) {
					if (file.getArtifactTypeDesc().equalsIgnoreCase(name)) {
						fileDesc.add(file);
					}
				} else {
					home.add(file);
				}
			}
			if (name == null) {
				map.put("HOME", home);
			} else {
				map.put(name, fileDesc);
			}
		}

		List<Integer> artifactId = files.stream().map(Files::getArtifactId).distinct().collect(Collectors.toList());

		Map<String, ArtifactResponse> artifactMap = new HashMap<>();
		for (int id : artifactId) {
			List<ArtifactProgress> artifactProgress = artifactProgressRepository.getArtifactProgress(id);
			List<ArtifactProgressUsers> artifactProgressUsers = artifactProgressUsersRepository
					.getArtifactProgressUsers(id);
			artifactResponse.setArtifactProgress(artifactProgress);
			artifactResponse.setArtifactProgressUsers(artifactProgressUsers);
			artifactMap.put("artifact_Id:" + String.valueOf(id), artifactResponse);
		}
		Map finalResponse = new HashMap();
		finalResponse.putAll(artifactMap);
		finalResponse.putAll(map);
		logger.info("[BSP]:getFiles() - Service method call Ended");
		return finalResponse;

	}

	// Aravindh

	@Override
	public List<LinkedInstallation> getLinkedInstallation(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getLinkedInstallation input data :" + stratId);
		List<LinkedInstallation> LinkedInstallationResList = projectDetailsDao.getinkedInstallation(stratId);
		logger.info("getLinkedInstallation result  data :" + LinkedInstallationResList.toString());
		return LinkedInstallationResList;
	}

	@Override
	public List<TeamMembers> getTeamMembers(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getTeamMembers input data :" + stratId);
		List<TeamMembers> result = projectDetailsDao.getTeamMembers(stratId);
		logger.info("getTeamMembers result  data :" + result.toString());
		return result;
	}

	@Override
	public List<Milestones> getMileStones(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getMileStones input data :" + stratId);
		List<Milestones> result = projectDetailsDao.getMileStones(stratId);
		logger.info("getMileStones result  data :" + result.toString());
		return result;
	}

	// from sasi

	@Override
	public List<ImpactedProducts> getProduct(int stratId) throws Exception {
		// return impactedProductsRepo.getProduct(stratId);
		logger.info("Entered into ProjectDetailsServiceimpl getProduct input data :" + stratId);
		List<ImpactedProducts> result = projectDetailsDao.getProduct(stratId);
		logger.info("getProduct result  data :" + result.toString());
		return result;
	}

	@Override
	public List<RecommendedMembers> getMembers(int stratId) throws Exception {
		// return recommendedMembersRepo.getMembers(stratId);
		logger.info("Entered into ProjectDetailsServiceimpl getMembers input data :" + stratId);
		List<RecommendedMembers> result = projectDetailsDao.getMembers(stratId);
		logger.info("getMembers result  data :" + result.toString());
		return result;
	}

	@Override
	public List<TechComponents> getTechComponents(int stratId) throws Exception {
		// return techComponentsRepo.getComponents(stratId);
		logger.info("Entered into ProjectDetailsServiceimpl getTechComponents input data :" + stratId);
		List<TechComponents> result = projectDetailsDao.getTechComponents(stratId);
		logger.info("getTechComponents result  data :" + result.toString());
		return result;
	}

	@Override
	public List<Cti> getCti(int strat_id) throws Exception {

		logger.info("Entered into ProjectDetailsServiceimpl getCti input data :" + strat_id);
		List<Cti> result = projectDetailsDao.getCti(strat_id);
		logger.info("getCti result  data :" + result.toString());
		return result;
	}

	@Override
	public List<ResourcePlan> getResourcePlan(int strat_id) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getResourcePlan input data :" + strat_id);
		List<ResourcePlan> result = projectDetailsDao.getResourcePlan(strat_id);
		logger.info("getResourcePlan result  data :" + result.toString());
		return result;
	}

	// end
	@Override
	public List<ApprovalsCallInfo> getApprovals(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getApprovals input data :" + stratId);
		List<ApprovalsCallInfo> result = projectDetailsDao.getApprovals(stratId);
		logger.info("getTechComponents result  data :" + result.toString());
		return result;
	}

	@Override
	public List<Typesinfo> getTypesinfo() throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getTypesinfo" );
		List<Typesinfo> types = typesRepo.typesinfos();
		logger.info("getTechComponents result  data :" + types.toString());
		return types;
	}

	@Override
	public List<StatusInfo> getStatusinfo() throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getTypesinfo" );
		List<StatusInfo> status = statusRepository.statusList();
		logger.info("getTechComponents result  data :" + status.toString());
		return status;
	}

	@Override
	public List<StratPhases> getStratPhasesinfo() throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getTypesinfo" );
		List<StratPhases> stratPhases = stratPhasesRepository.getStratPhasesList();
		logger.info("getTechComponents result  data :" + stratPhases.toString());
		return stratPhases;
	}

	@Override
	public List<LobsInfo> getLobsList() throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getLobsList" );
		List<LobsInfo> Lobsinf = lobsRepository.getLobsList();
		logger.info("getTechComponents result  data :" + Lobsinf.toString());
		return Lobsinf;
	}
	


}

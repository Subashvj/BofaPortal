package com.pointel.bofa.strategy.portal.app.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dao.ProjectCalendarDao;
import com.pointel.bofa.strategy.portal.app.dao.ProjectDao;
import com.pointel.bofa.strategy.portal.app.dto.HolidaycalInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponseWithAll;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskResponse;

import com.pointel.bofa.strategy.portal.app.dto.MyTeamProjectsInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyWeeksAllocationInfo;
import com.pointel.bofa.strategy.portal.app.dto.MytaskPastInfo;
import com.pointel.bofa.strategy.portal.app.dto.NewestProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.News;
import com.pointel.bofa.strategy.portal.app.dto.OnCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.ProjectCalInfo;
import com.pointel.bofa.strategy.portal.app.dto.ProjectCalendarResList;
import com.pointel.bofa.strategy.portal.app.dto.ProjectResult;
import com.pointel.bofa.strategy.portal.app.dto.StratCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpComingInstallationInfo;
import com.pointel.bofa.strategy.portal.app.dto.UserCalInfo;
import com.pointel.bofa.strategy.portal.app.dto.UserPrefsinfo;
import com.pointel.bofa.strategy.portal.app.dto.WhosOutInfo;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.MyProjectInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyTaskInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyTaskPastRepository;

import com.pointel.bofa.strategy.portal.app.repository.MyTeamTaskInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyWeeksAllocationInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.MyteamprojectRepository;
import com.pointel.bofa.strategy.portal.app.repository.NewestProjectInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.NewsinfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.TeamRepository;
import com.pointel.bofa.strategy.portal.app.repository.UpComingInstallationInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.UserPrefRepository;
import com.pointel.bofa.strategy.portal.app.repository.WhosRepository;

@Service
public class HomePageServiceImpl implements HomePageService {

	public static Logger logger = LogManager.getLogger(HomePageServiceImpl.class);
	
	@Value("${userid}")
	private String userId;
	
	@Autowired
	TraceLogger traceLogger;
	
	@Autowired
	private MyTaskInfoRepository myTaskInfoRepository;

	@Autowired
	private MyTeamTaskInfoRepository myTeamTaskInfoRepository;

	@Autowired
	private UpComingInstallationInfoRepo upComingInstallationInfoRepo;

	@Autowired
	private NewestProjectInfoRepo newestProjectInfoRepo;

	@Autowired
	private MyWeeksAllocationInfoRepo myWeeksAllocationInfoRepo;


	@Autowired
	private MyProjectInfoRepository myProjectInfoRepository;
	
	@Autowired
	private NewsinfoRepository newsinfoRepository;
	@Autowired
	private WhosRepository whosRepository;
	
	@Autowired
	private MyTaskPastRepository myTaskPastInfo;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	MyteamprojectRepository myteamprojectRepository;
	
	@Autowired
	UserPrefRepository userPrefRepository;
	
	//Aravindh
	@Autowired
	private ProjectCalendarResList ProjectCalendarResultList;
	
	@Autowired
	ProjectCalendarDao ProjectCalendarRes;
	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	ProjectResult projectResult;



	@Override
	public List<NewestProjectInfo> getNewestProjectInfo() throws Exception {
		try {
			logger.info("[POINTEL]:getNewestProjectInfo() - Service method call Started");
			List<NewestProjectInfo> newestProjectInfoList = null;
			newestProjectInfoList = newestProjectInfoRepo.getNewestProjectInfo();
			logger.info("[POINTEL]:getNewestProjectInfo() - Service method call Ended");
			return newestProjectInfoList;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getNewestProjectInfo");
		}
		
	}

	@Override
	public List<UpComingInstallationInfo> getUpComingInstallationInfos() throws Exception {
		try {
			logger.info("[POINTEL]:getUpComingInstallationInfos() - Service method call Started");
			List<UpComingInstallationInfo> upComingInstallationInfoList = null;

			upComingInstallationInfoList = upComingInstallationInfoRepo.getUpComingInsatallations();
			logger.info("[POINTEL]:getUpComingInstallationInfos() - Service method call Ended");
			return upComingInstallationInfoList;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getUpComingInstallationInfos");
		}
		
	}
	@Override
	public List<MyWeeksAllocationInfo> getMyWeeksAllocationInfo( Date date) throws Exception {
		try {
			logger.info("[POINTEL]:getMyWeeksAllocationInfo() - Service method call Started");
			List<MyWeeksAllocationInfo> myWeeksAllocationInfoList = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
			String dateString = dateFormat.format(date);
			System.out.println("Format : " + dateString);
			myWeeksAllocationInfoList = myWeeksAllocationInfoRepo
					.retriveMyWeeksAllocationInfo(userId, dateString);
			
			for (MyWeeksAllocationInfo myWeeksAllocationInfo : myWeeksAllocationInfoList) {

				logger.info("myWeeksAllocationInfo Data :" + myWeeksAllocationInfo.toString());
			}

			logger.info("[POINTEL]:getMyWeeksAllocationInfo() - Service method call Ended");
			return myWeeksAllocationInfoList;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getMyWeeksAllocationInfo");
		}

	}
//
//	@Override
//	public List<MyTeamProjectInfo> getMyTeamProjectInfo() throws Exception {
//		try {
//			logger.info("[POINTEL]:getMyTeamProjectInfo() - Service method call Started");
//			List<MyTeamProjectInfo> myTeamProjectInfoList = null;
//			String mgrId= userId;
//			myTeamProjectInfoList = myTeamProjectInfoRepository.retriveMyTeamProjects(mgrId);
//			if (myTeamProjectInfoList.isEmpty()) {
//				logger.error("[POINTEL]:getMyTeamProjectInfo() - Service method ,No Records Found,{} for this MgrId",mgrId);
//				throw new RecordsNotFoundException("Records Not Found","getMyTeamProjectInfo()");
//			}
//			for (MyTeamProjectInfo myTeamProjectInfo : myTeamProjectInfoList) {
//
//				System.out.println(myTeamProjectInfo.toString());
//			}
//			logger.info("[POINTEL]:getMyTeamProjectInfo() - Service method call Ended");
//			return myTeamProjectInfoList;
//			
//		}catch(RecordsNotFoundException notFound) {
//			throw new RecordsNotFoundException("No Records Found","getMyTeamProjectInfo");
//		}catch(Exception e) {
//			traceLogger.writeStackTrace(e);
//			throw new FailedToFullfillRequest("Operation Failed","getMyTeamProjectInfo");
//		}
		
	//}

	@Override
	public List<News> getnewsinfo() throws Exception {
		//List<News> myNewsinfolist;
		try {
			logger.info("[POINTEL]:getMyTeamProjectInfo() - Service method call Started");
			List<News> myNewsinfolist= null;
			myNewsinfolist= newsinfoRepository.getnewsin();
			logger.info("[BSP]:getnewsinfo() - Service method call Ended");
			return myNewsinfolist;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getnewsinfo");
		}
		
	}
	@Override
	public List<WhosOutInfo> getWhosOutInfo() throws Exception{
		// TODO Auto-generated method stub
		try
		{
		logger.info("[BSP]:getwhosinfo() - Service method call Started");
		List<WhosOutInfo> mywhosbeaninfo =null;
		mywhosbeaninfo = whosRepository.getwhosinf();
		logger.info("[BSP]:getwhosinfo() - Service method call Ended");
		return mywhosbeaninfo;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getwhosinfo");
		}
	}

	@Override
	public List<MyTaskResponse> getMyTaskInfo()throws Exception {
		try {
			logger.info("[BSP]:getTaskPastInfo() - Service method call Started");
			MyTaskResponse mytaskpastbean = new MyTaskResponse();
			logger.info("mytaskpastbean input data : " + userId);
		    List<MyTaskResponse> taskpastbean = new ArrayList<>();
			// TODO Auto-generated method stub
			List<MytaskPastInfo> mytaskpastinfo = null;
			String username = userId;
			mytaskpastinfo = myTaskPastInfo.getTaskPastin(username);
			List<MyTaskInfo> myTaskInfos = myTaskInfoRepository.getMyTaskInfo(username)  ;
			mytaskpastbean.setMyTaskInfo(myTaskInfos);
			mytaskpastbean.setMytaskPastInfo(mytaskpastinfo);
			taskpastbean.add(mytaskpastbean);
			logger.info("[BSP]:getTaskPastInfo() - Service method call Ended");
			return taskpastbean;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getTaskPastInfo");
		}	
	}
	@Override
	public List<MyTeamProjectsInfo> getMyTeamProjectInfo() throws Exception {
		try {
			logger.info("[BSP]:getmyteambeaninfo() - Service method call Started");
			List<TeamInfo> myTeamBean = teamRepository.teaminforepo(userId);
			String users = "";
			for(int i=0;i<myTeamBean.size();i++) {
				if(i==myTeamBean.size()-1) {
					users +=myTeamBean.get(i).getUserid();
				}else {
					users +=myTeamBean.get(i).getUserid()+",";
				}			
			}
			logger.info("teambean input data : " + users);
			List<MyTeamProjectsInfo> myteamprojectBeans = myteamprojectRepository.teamprojectinf(users);	
			logger.info("[BSP]:getmyteambeaninfo() - Service method call Ended");
			return myteamprojectBeans;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getmyteambeaninfo");
		}
		
	}

	@Override
	public List<MyTeamTaskResponse> getMyTeamTaskinfo() throws Exception {
		try {
			logger.info("[BSP]:getMyTeamTaskinfo() - Service method call Started");
			MyTeamTaskResponse myTeamTaskResponse= new MyTeamTaskResponse();
			List<MyTeamTaskResponse> taskpastresponse = new ArrayList<>();
			String username = userId;
			List<MytaskPastInfo> mytaskpastinfo = null;
			List<MyTeamTaskInfo> myTeamTaskInfos = null;
			mytaskpastinfo = myTaskPastInfo.getTaskPastin(userId);
			List<TeamInfo> myTeamBean = teamRepository.teaminforepo(username);
			String users="";
			for(int i=0;i<myTeamBean.size();i++) {
				if(i==myTeamBean.size()-1) {
					users +=myTeamBean.get(i).getUserid();
				}else {
					users +=myTeamBean.get(i).getUserid()+",";
				}			
			}	
			logger.info ("myTeamBean input data : " + users);
			myTeamTaskInfos = myTeamTaskInfoRepository.retriveMyTeamTask(users, username);	
			myTeamTaskResponse.setMytaskPastInfo(mytaskpastinfo);
			myTeamTaskResponse.setTeamTaskInfos(myTeamTaskInfos);
			taskpastresponse.add(myTeamTaskResponse);
			logger.info("[BSP]:getMyTeamTaskinfo() - Service method call Ended");
			return taskpastresponse;
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getMyTeamTaskinfo");
		}
		
	}


	@Override
	public List<MyProjectResponse> getMyProjectinf() throws Exception{
			try {
				logger.info("[BSP]:getMyProjectinf() - Service method call Started");
				MyProjectResponse myProjectResponse = new MyProjectResponse();
				logger.info("MyProjectResponseWithAll data are : "+myProjectResponse.toString());
				logger.info("myProjectResponse input data : " + userId);
				List<MyProjectResponse> projectResponses =new ArrayList<>();
				List<MyProjectInfo> myProjectinfs = null;
				String username = userId;
				 myProjectinfs = myProjectInfoRepository.myProjectInf(username);
				 myProjectResponse.setMyProjectInfos(myProjectinfs);				
				List<UserPrefsinfo> prefsinfo = userPrefRepository.userPrefsinfo(username);	
				myProjectResponse.setUserPrefsinfos(prefsinfo);	
				projectResponses.add(myProjectResponse);
				logger.info("[BSP]:getMyProjectinf() - Service method call Ended");
				return projectResponses;
			}catch(Exception e) {
				traceLogger.writeStackTrace(e);
				throw new FailedToFullfillRequest("Operation Failed","getMyProjectinf");
			}
		
		}
	@Override
	public List<MyProjectResponseWithAll> getMyProjectInfo(String showAll) throws Exception{
			try {
				logger.info("[BSP]:getMyProjectinfo() - Service method call Started");
				MyProjectResponseWithAll myProjectResponse = new MyProjectResponseWithAll();
				logger.info("MyProjectResponseWithAll data are : "+myProjectResponse.toString());
				logger.info("myProjectResponse input data : " + userId);
				List<MyProjectResponseWithAll> myprojectResponses =new ArrayList<>();
				String username= userId;
				List<MyProjectInfo>	myProjectinfo = myProjectInfoRepository.retriveMyProjectInfo(username);
				myProjectResponse.setMyProjectInfos(myProjectinfo);								
				List<UserPrefsinfo> prefsinfo = userPrefRepository.userPrefsinfo(username);	
				myProjectResponse.setUserPrefsinfos(prefsinfo);	
				myprojectResponses.add(myProjectResponse);
				logger.info("[BSP]:getMyProjectinfo() - Service method call Ended");
				return myprojectResponses;
			}catch(Exception e) {
				traceLogger.writeStackTrace(e);
				throw new FailedToFullfillRequest("Operation Failed","getMyProjectinfo");
			}
		
		}
	
	//Aravindh
	
	@Override
	public ProjectCalendarResList getProjectCalendarRes(String startDate, String endDate)throws Exception {
		
		logger.info("Entered into getProjectCalendarRes HomePageServiceImpl :");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);

			List<ProjectCalInfo> ProjectCallResList = ProjectCalendarRes.getProjectCallInfo(startDate, endDate);
			logger.info("ProjectCallResList data "+ProjectCallResList.toString());
			List<OnCallInfo> OncallResList = ProjectCalendarRes.getOncallInfo(startDate, endDate);
			logger.info("OncallResList data "+OncallResList.toString());
			List<HolidaycalInfo> HolidaycallResList = ProjectCalendarRes.getHolidaycallInfo(startDate, endDate);
			logger.info("HolidaycallResList data "+HolidaycallResList.toString());
			List<InstallCallInfo> InstallCallResList = ProjectCalendarRes.getInstallCallInfo(startDate, endDate);
			logger.info("InstallCallResList data "+InstallCallResList.toString());
			List<StratCallInfo> StratCallResList = ProjectCalendarRes.getStratCallInfo(startDate, endDate);
			logger.info("StratCallResList data "+StratCallResList.toString());			
		ProjectCalendarResultList.setProjectCalInfo(ProjectCallResList);
		ProjectCalendarResultList.setOnCallInfo(OncallResList);
		ProjectCalendarResultList.setHolidaycalInfo(HolidaycallResList);
		ProjectCalendarResultList.setInstallCallInfo(InstallCallResList);
		ProjectCalendarResultList.setStratCallInfo(StratCallResList);
		
		return ProjectCalendarResultList;
	}

	@Override
	public ProjectResult getProjectRes(String startDate, String endDate) throws Exception {
		
		
		logger.info("Entered into getProjectRes HomePageServiceImpl :");
		logger.info("Input data start date "+startDate);
		logger.info("Input data end date "+endDate);

		
	List<UserCalInfo> UserCallResList = projectDao.getUserCalInfo(startDate, endDate);
	logger.info("UserCallResList data :"+UserCallResList.toString());
	
	List<HolidaycalInfo> HolidaycallResList = projectDao.getHolidaycallInfo(startDate, endDate);
	logger.info("HolidaycallResList data :"+HolidaycallResList.toString());
	
	List<InstallCallInfo> InstallCallResList = projectDao.getInstallCallInfo(startDate, endDate);
	logger.info("InstallCallResList data :"+InstallCallResList.toString());
	
		projectResult.setUserCalInfo(UserCallResList);
		projectResult.setHolidaycalInfo(HolidaycallResList);
		projectResult.setInstallCallInfo(InstallCallResList);
		return projectResult;
	}
	
	
	
}

package com.pointel.bofa.strategy.portal.app.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.MyProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponseWithAll;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskResponse;

import com.pointel.bofa.strategy.portal.app.dto.MyTeamProjectsInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyWeeksAllocationInfo;
import com.pointel.bofa.strategy.portal.app.dto.NewestProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.News;
import com.pointel.bofa.strategy.portal.app.dto.ProjectCalendarResList;
import com.pointel.bofa.strategy.portal.app.dto.ProjectResult;
import com.pointel.bofa.strategy.portal.app.dto.TeamInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpComingInstallationInfo;
import com.pointel.bofa.strategy.portal.app.dto.UserPrefsinfo;
import com.pointel.bofa.strategy.portal.app.dto.WhosOutInfo;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.UserPrefRepository;
import com.pointel.bofa.strategy.portal.app.service.HomePageServiceImpl;

@RestController
@RequestMapping("/api/v1/projects")
public class HomePageControllerImpl implements HomePageController{
	public static Logger logger = LogManager.getLogger(HomePageControllerImpl.class);
	@Autowired
	HomePageServiceImpl homePageServiceImpl;
	
	@Autowired
	TraceLogger traceLogger;
	
	

	@Override
	@GetMapping("/getNewestProjects")
	public ResponseEntity<?> getNewestProjects() throws Exception {
		List<NewestProjectInfo> newestProjectInfos =null;
		try {
			logger.info("[BSP]:getNewestProjects() - Method call started");
			newestProjectInfos =	homePageServiceImpl.getNewestProjectInfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getNewestProjects()");
		}
		return ResponseEntity.ok().body(newestProjectInfos);
		
	}

	@Override
	@GetMapping("/getUpComingInstallations")
	public ResponseEntity<?> getUpComingInstallations() throws Exception {
		List<UpComingInstallationInfo> upComingInstallationInfos =null;
		try {
			logger.info("[BSP]:getUpComingInstallations() - Method call started");
			upComingInstallationInfos =homePageServiceImpl.getUpComingInstallationInfos();
		}catch (Exception e) 
		{traceLogger.writeStackTrace(e);
		throw new FailedToFullfillRequest("Operation Failed","getUpComingInstallations()");
		}
		return ResponseEntity.ok().body(upComingInstallationInfos);
	}

	
	@Override
	@GetMapping("/getMyWeeksAllocationInfo/{date}")
	public ResponseEntity <?> getMyWeeksAllocationInfo(@PathVariable("date") @DateTimeFormat(pattern = "mm-dd-yyyy") Date date) throws Exception {
		List<MyWeeksAllocationInfo> myWeeksAllocationInfos =null;
		try {
			logger.info("[BSP]:getMyWeeksAllocationInfo() - Method call started");
			myWeeksAllocationInfos = homePageServiceImpl.getMyWeeksAllocationInfo(date);
		} catch (Exception e){
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getUpComingInstallations()");
		}
		
		return ResponseEntity.ok().body(myWeeksAllocationInfos);
	}

	@Override
	@GetMapping("/getNews")
	public ResponseEntity <?> getNews() throws Exception{
		List<News> news= null;
		try {
			logger.info("[BSP]:getNews() - Method call started");
			news = homePageServiceImpl.getnewsinfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getNews()");
		}
		return ResponseEntity.ok().body(news);
	}

	@Override
	@GetMapping("/getWhosOut")
	public  ResponseEntity <?> getWhosOut() throws Exception {
		 List<WhosOutInfo> whosOutInfos =null;
		 try {
			 logger.info("[BSP]:getWhosOut() - Method call started");
			 whosOutInfos =  homePageServiceImpl.getWhosOutInfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getWhosOut()");
		}
		
		return ResponseEntity.ok().body(whosOutInfos);
	}

	@Override
	@GetMapping("/getMyTask")
	public ResponseEntity <?>  getTaskPast()throws Exception {
		List<MyTaskResponse> taskResponses = null;
		try {
			 logger.info("[BSP]:getTaskPast() - Method call started");
			taskResponses = homePageServiceImpl.getMyTaskInfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getTaskPast()");
		}
		return ResponseEntity.ok().body(taskResponses);
	}

	@Override
	@GetMapping("/getMyTeamProject")
	public ResponseEntity <?>  getMyTeamProject() throws Exception {
		// TODO Auto-generated method stub
		List<MyTeamProjectsInfo> teamProjectsInfos= null;
		try {
			 logger.info("[BSP]:getMyTeamProject() - Method call started");
			teamProjectsInfos = homePageServiceImpl.getMyTeamProjectInfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getMyTeamProject()");
		}
		return ResponseEntity.ok().body(teamProjectsInfos);
	}

	@Override
	@GetMapping("/getMyTeamTask")
	public ResponseEntity <?> getTaskResponses() throws Exception{
		 List<MyTeamTaskResponse> teamTaskResponses = null;
		 try {
			 logger.info("[BSP]:getTaskResponses() - Method call started");
			 teamTaskResponses = homePageServiceImpl.getMyTeamTaskinfo();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getTaskResponses()");
		}
		return ResponseEntity.ok().body(teamTaskResponses);
	}

	@Override
	@GetMapping("/getMyProjectList/{showAll}")
	public ResponseEntity <?> getMyProjectResponseAll(@PathVariable String showAll) throws Exception{
		List<MyProjectResponseWithAll> myProjectResponseWithall = null;
		try {
			 logger.info("[BSP]:getMyProjectResponseAll() - Method call started");
			myProjectResponseWithall = homePageServiceImpl.getMyProjectInfo(showAll);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getMyProjectResponseAll()");
		}
		return ResponseEntity.ok().body(myProjectResponseWithall);
	}
	@Override
	@GetMapping("/getMyProjectList")
	public ResponseEntity <?> getMyProjectResponse() throws Exception{
		 List<MyProjectResponse> myProjectResponses =null;
		 try {
			 logger.info("[BSP]:getMyProjectResponse() - Method call started");
			 myProjectResponses = homePageServiceImpl.getMyProjectinf();
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getMyProjectResponse()");
		}
		return ResponseEntity.ok().body(myProjectResponses);
	}
	//Aravindh
	@Override
	@GetMapping("/getProjectCalendar/{startDate}/{endDate}")
	@ResponseBody
	public ResponseEntity<?> getProjectCalendarRes(@PathVariable String startDate,@PathVariable String endDate) throws Exception  {
		
		logger.info("Entered into HomePageControllerImpl getProjectCalendarRes");
		
		logger.info("Input data strat date "+startDate);
		logger.info("Input data end date "+endDate);
		
		try {
		//SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd"); MM-dd-yyyy
		SimpleDateFormat oldFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date sd =  oldFormat.parse(startDate);
		Date ed =  oldFormat.parse(endDate);
		
		 SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String parsedStartDate = newFormat.format(sd);
		String ParseedEndDate = newFormat.format(ed);
		System.out.println("result "+parsedStartDate);
		ProjectCalendarResList result =	homePageServiceImpl.getProjectCalendarRes(parsedStartDate, ParseedEndDate);
		logger.info("Result from getProjectCalendarRes "+result);
		return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getProjectCalendarRes");
			return ResponseEntity.ok().body(error);
		}
	}
	
	
	@Override
	@GetMapping("/getProject/{startDate}/{endDate}")
	@ResponseBody
	public  ResponseEntity<?> getProjectRes(@PathVariable String startDate,@PathVariable String endDate) throws Exception {
			logger.info("Entered into HomePageControllerImpl getProjectRes");
			
			logger.info("Input data strat date "+startDate);
			logger.info("Input data end date "+endDate);
		try {
				SimpleDateFormat oldFormat = new SimpleDateFormat("MM-dd-yyyy");
				Date sd =  oldFormat.parse(startDate);
				Date ed =  oldFormat.parse(endDate);				
				 SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd"); 
				String parsedStartDate = newFormat.format(sd);
				String ParseedEndDate = newFormat.format(ed);
				ProjectResult result = homePageServiceImpl.getProjectRes(parsedStartDate, ParseedEndDate);
				logger.info("Result from getProjectRes "+result);
		return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getProjectRes");
			return ResponseEntity.ok().body(error);
		}
	}
	
}
package com.pointel.bofa.strategy.portal.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.repository.UserPrefRepository;

public interface HomePageController {

	public ResponseEntity<?>  getNewestProjects() throws Exception;
	public ResponseEntity<?> getUpComingInstallations() throws Exception;
	public ResponseEntity<?> getMyWeeksAllocationInfo( Date date) throws Exception;
	//public List<MyTeamProjectInfo> getMyTeamProject() throws Exception;
	public ResponseEntity<?> getNews() throws Exception;
	public ResponseEntity<?> getWhosOut()throws Exception;
	public ResponseEntity<?> getTaskPast()throws Exception;
	//public List<TeamInfo> getTeambean() throws Exception;
	public ResponseEntity<?> getMyTeamProject() throws Exception;
	public ResponseEntity<?> getTaskResponses() throws Exception;
	public ResponseEntity<?> getMyProjectResponse() throws Exception;
	public ResponseEntity<?> getMyProjectResponseAll(String showAll) throws Exception;
	//Aravindh

	
	
	public ResponseEntity<?> getProjectCalendarRes(String startDate , String endDate) throws Exception;
	public ResponseEntity<?> getProjectRes(String startDate , String endDate) throws Exception;

	
}

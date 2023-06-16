package com.pointel.bofa.strategy.portal.app.service;

import java.util.Date;
import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyProjectResponseWithAll;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamProjectsInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskResponse;
import com.pointel.bofa.strategy.portal.app.dto.MyWeeksAllocationInfo;
import com.pointel.bofa.strategy.portal.app.dto.NewestProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.News;
import com.pointel.bofa.strategy.portal.app.dto.ProjectCalendarResList;
import com.pointel.bofa.strategy.portal.app.dto.ProjectResult;
import com.pointel.bofa.strategy.portal.app.dto.TeamInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpComingInstallationInfo;
import com.pointel.bofa.strategy.portal.app.dto.WhosOutInfo;

public interface HomePageService {

	public List<NewestProjectInfo> getNewestProjectInfo() throws Exception;
	public List<UpComingInstallationInfo> getUpComingInstallationInfos() throws Exception;
	public List<MyWeeksAllocationInfo> getMyWeeksAllocationInfo(Date date) throws Exception;
	//public List<MyTeamProjectInfo> getMyTeamProjectInfo() throws Exception;
	public List<News> getnewsinfo() throws Exception;
	public List<WhosOutInfo> getWhosOutInfo()throws Exception;
	public List<MyTaskResponse> getMyTaskInfo()throws Exception;
	//public List<TeamInfo> getTeaminfo() throws Exception;
	public List<MyTeamProjectsInfo> getMyTeamProjectInfo() throws Exception;
	public List<MyTeamTaskResponse> getMyTeamTaskinfo() throws Exception;
	public List<MyProjectResponse> getMyProjectinf() throws Exception;
	public List<MyProjectResponseWithAll> getMyProjectInfo(String showAll) throws Exception;
	public ProjectCalendarResList getProjectCalendarRes(String startDate , String endDate) throws Exception;
	public ProjectResult getProjectRes(String startDate , String endDate) throws Exception;
	
	
	
	
}

package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectCalendarResList {
	
	@Override
	public String toString() {
		return "ProjectCalendarRes [projectCalInfo=" + projectCalInfo + ", onCallInfo=" + onCallInfo
				+ ", holidaycalInfo=" + holidaycalInfo + ", InstallCallInfo=" + InstallCallInfo + ", StratCallInfo="
				+ StratCallInfo + "]";
	}

	public List<ProjectCalInfo> getProjectCalInfo() {
		return projectCalInfo;
	}

	public void setProjectCalInfo(List<ProjectCalInfo> projectCalInfo) {
		this.projectCalInfo = projectCalInfo;
	}

	public List<OnCallInfo> getOnCallInfo() {
		return onCallInfo;
	}

	public void setOnCallInfo(List<OnCallInfo> onCallInfo) {
		this.onCallInfo = onCallInfo;
	}

	public List<HolidaycalInfo> getHolidaycalInfo() {
		return holidaycalInfo;
	}

	public void setHolidaycalInfo(List<HolidaycalInfo> holidaycalInfo) {
		this.holidaycalInfo = holidaycalInfo;
	}

	public List<InstallCallInfo> getInstallCallInfo() {
		return InstallCallInfo;
	}

	public void setInstallCallInfo(List<InstallCallInfo> installCallInfo) {
		InstallCallInfo = installCallInfo;
	}

	public List<StratCallInfo> getStratCallInfo() {
		return StratCallInfo;
	}

	public void setStratCallInfo(List<StratCallInfo> stratCallInfo) {
		StratCallInfo = stratCallInfo;
	}

	private List<ProjectCalInfo> projectCalInfo;
	
	private List<OnCallInfo> onCallInfo;
	
	private List<HolidaycalInfo> holidaycalInfo;
	
	private List<InstallCallInfo> InstallCallInfo;
	
	private List<StratCallInfo> StratCallInfo;

}

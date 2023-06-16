package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ProjectResult {
	
	private List<UserCalInfo> userCalInfo;
	
	private List<HolidaycalInfo> holidaycalInfo;
	
	public List<UserCalInfo> getUserCalInfo() {
		return userCalInfo;
	}

	public void setUserCalInfo(List<UserCalInfo> userCalInfo) {
		this.userCalInfo = userCalInfo;
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

	private List<InstallCallInfo> InstallCallInfo;

}

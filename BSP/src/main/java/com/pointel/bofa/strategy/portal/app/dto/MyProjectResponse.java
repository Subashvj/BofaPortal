package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class MyProjectResponse {
	private List<MyProjectInfo> myProjectInfos;
	private List<UserPrefsinfo> userPrefsinfos;
	public List<MyProjectInfo> getMyProjectInfos() {
		return myProjectInfos;
	}
	public void setMyProjectInfos(List<MyProjectInfo> myProjectInfos) {
		this.myProjectInfos = myProjectInfos;
	}
	public List<UserPrefsinfo> getUserPrefsinfos() {
		return userPrefsinfos;
	}
	public void setUserPrefsinfos(List<UserPrefsinfo> userPrefsinfos) {
		this.userPrefsinfos = userPrefsinfos;
	}

}

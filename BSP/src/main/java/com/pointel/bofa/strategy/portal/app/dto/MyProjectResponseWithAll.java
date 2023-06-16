package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class MyProjectResponseWithAll {

	private List<MyProjectInfo> myProjectInfos;
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
	private List<UserPrefsinfo> userPrefsinfos;
}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPrefsinfo {
	@Id
	private int iduserPrefId;
	private String userPrefValue;
	public int getIduserPrefId() {
		return iduserPrefId;
	}
	public void setIduserPrefId(int iduserPrefId) {
		this.iduserPrefId = iduserPrefId;
	}
	public String getUserPrefValue() {
		return userPrefValue;
	}
	public void setUserPrefValue(String userPrefValue) {
		this.userPrefValue = userPrefValue;
	}

}

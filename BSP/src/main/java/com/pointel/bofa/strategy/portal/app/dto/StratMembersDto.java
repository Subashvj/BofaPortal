package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StratMembersDto {
	
	@Id
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "DISPLAYNAME")
	private String displayName; 
	
	@Column(name = "USERTYPE_DESC")
	private String userTypeDesc;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserTypeDesc() {
		return userTypeDesc;
	}

	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}

	@Override
	public String toString() {
		return "StratMembersDto [userName=" + userName + ", displayName=" + displayName + ", userTypeDesc="
				+ userTypeDesc + "]";
	}

}

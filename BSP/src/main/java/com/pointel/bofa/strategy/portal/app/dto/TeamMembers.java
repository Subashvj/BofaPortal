package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamMembers {
	
	@Id
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "ROLE_DESC")
	private String roleDesc;
	
	@Column(name = "DISPLAYNAME")
	private String displayName;
	
	@Column(name = "MGRID")
	private String mgrId;
	
	@Column(name = "ACTIVE")
	private int active;
	
	@Column(name = "CONNECTION_KEY")
	private String connectionKey;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getConnectionKey() {
		return connectionKey;
	}

	public void setConnectionKey(String connectionKey) {
		this.connectionKey = connectionKey;
	}

	
	

}

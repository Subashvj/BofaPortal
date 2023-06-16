package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyTeamProjectsInfo {
	
	@Id
	private int stratId;
	private String stratName;
	private String username;
	private String roleDesc;
	private String stratStatusDesc;
	private String fullDeploy;
	
	
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
	public String getFullDeploy() {
		return fullDeploy;
	}
	public void setFullDeploy(String fullDeploy) {
		this.fullDeploy = fullDeploy;
	}

	}
	



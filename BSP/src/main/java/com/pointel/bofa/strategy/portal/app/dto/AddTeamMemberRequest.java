package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class AddTeamMemberRequest {
	private int stratId;
	private int roleId;
	private List<String> userName;
	private int includeMe;
	
	public List<String> getUserName() {
		return userName;
	}
	public void setUserName(List<String> userName) {
		this.userName = userName;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getIncludeMe() {
		return includeMe;
	}
	public void setIncludeMe(int includeMe) {
		this.includeMe = includeMe;
	}
	
}

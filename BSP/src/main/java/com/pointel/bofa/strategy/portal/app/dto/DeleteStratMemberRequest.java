package com.pointel.bofa.strategy.portal.app.dto;

public class DeleteStratMemberRequest {
	private int stratId;
	private String userName;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

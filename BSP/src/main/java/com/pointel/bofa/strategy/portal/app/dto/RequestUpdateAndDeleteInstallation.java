package com.pointel.bofa.strategy.portal.app.dto;

public class RequestUpdateAndDeleteInstallation {

	private int stratId;
	private int[] newInstall;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int[] getNewInstall() {
		return newInstall;
	}
	public void setNewInstall(int[] newInstall) {
		this.newInstall = newInstall;
	}
	
	
}

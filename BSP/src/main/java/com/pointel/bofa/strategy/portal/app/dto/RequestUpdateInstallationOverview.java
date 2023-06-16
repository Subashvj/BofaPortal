package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

public class RequestUpdateInstallationOverview {

	private int installId;
	private String installTitle;
	private Date installDate;
	private int installStatusId;
	private int installType;
	private int instEnvId;
	private int installOwnergroup;
	private String cabNum;
	private int cabStatus;
	private Date cabApprovalDate;
	
	public int getInstallId() {
		return installId;
	}
	public void setInstallId(int installId) {
		this.installId = installId;
	}
	public String getInstallTitle() {
		return installTitle;
	}
	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	public int getInstallStatusId() {
		return installStatusId;
	}
	public void setInstallStatusId(int installStatusId) {
		this.installStatusId = installStatusId;
	}
	public int getInstallType() {
		return installType;
	}
	public void setInstallType(int installType) {
		this.installType = installType;
	}
	public int getInstEnvId() {
		return instEnvId;
	}
	public void setInstEnvId(int instEnvId) {
		this.instEnvId = instEnvId;
	}
	public int getInstallOwnergroup() {
		return installOwnergroup;
	}
	public void setInstallOwnergroup(int installOwnergroup) {
		this.installOwnergroup = installOwnergroup;
	}

	public String getCabNum() {
		return cabNum;
	}
	public void setCabNum(String cabNum) {
		this.cabNum = cabNum;
	}
	public int getCabStatus() {
		return cabStatus;
	}
	public void setCabStatus(int cabStatus) {
		this.cabStatus = cabStatus;
	}
	public Date getCabApprovalDate() {
		return cabApprovalDate;
	}
	public void setCabApprovalDate(Date cabApprovalDate) {
		this.cabApprovalDate = cabApprovalDate;
	}
	
}

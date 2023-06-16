package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallationListInfo {
	
	@Id
	private int installId;
	private String installTitle;
	private String installDate;
	private int installStatusId;
	private int installType;
	private String displayname;
	private String installStatusDesc;
	private String installTypeDesc;
	private int totallinked;
	private String statusDesc;
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
	
	public String getInstallDate() {
		return installDate;
	}
	public void setInstallDate(String installDate) {
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
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getInstallStatusDesc() {
		return installStatusDesc;
	}
	public void setInstallStatusDesc(String installStatusDesc) {
		this.installStatusDesc = installStatusDesc;
	}
	public String getInstallTypeDesc() {
		return installTypeDesc;
	}
	public void setInstallTypeDesc(String installTypeDesc) {
		this.installTypeDesc = installTypeDesc;
	}
	public int getTotallinked() {
		return totallinked;
	}
	public void setTotallinked(int totallinked) {
		this.totallinked = totallinked;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
}

package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LinkedInstalltionEditInfo {
	@Id
	private int installId;
	private String installTitle;
	private Date installDate;
	private String incl;
	private int installStatusId;
	private String installTypeDesc;
	private Date linkDate;
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
	public String getIncl() {
		return incl;
	}
	public void setIncl(String incl) {
		this.incl = incl;
	}
	public int getInstallStatusId() {
		return installStatusId;
	}
	public void setInstallStatusId(int installStatusId) {
		this.installStatusId = installStatusId;
	}
	public String getInstallTypeDesc() {
		return installTypeDesc;
	}
	public void setInstallTypeDesc(String installTypeDesc) {
		this.installTypeDesc = installTypeDesc;
	}
	public Date getLinkDate() {
		return linkDate;
	}
	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	private String  displayname;
	private String iid;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	
	

}

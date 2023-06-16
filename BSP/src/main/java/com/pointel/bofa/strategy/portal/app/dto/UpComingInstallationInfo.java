package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UpComingInstallationInfo {

	@Id
	private int installId;
	private String installTitle;
	private String installStart;
	private String installTypeDescShort;
	
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
	public String getInstallStart() {
		return installStart;
	}
	public void setInstallStart(String installStart) {
		this.installStart = installStart;
	}
	public String getInstallTypeDescShort() {
		return installTypeDescShort;
	}
	public void setInstallTypeDescShort(String installTypeDescShort) {
		this.installTypeDescShort = installTypeDescShort;
	}
	
	
	@Override
	public String toString() {
		return "UpComingInstallationInfo [installId=" + installId + ", installTitle=" + installTitle
				+ ", installStart=" + installStart + ", installTypeDescShort=" + installTypeDescShort + "]";
	}
	
	
	
	
}

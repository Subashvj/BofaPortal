package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Milestones {
	
	@Id
	@Column(name = "INST_MILE_ID")
	private int instMileId;
	
	@Column(name = "MILESTONE_DESC")
	private String milestoneDesc;
	
	@Column(name = "START_DATE")
	private String startDate;  //date
	
	@Column(name = "END_DATE")
	private String endDate; //date
	
	@Column(name = "SD")
	private String sd; //date
	
	@Column(name = "ED")
	private String ed; //date
	
	@Column(name = "INSTALL_ID")
	private int installId;

	public int getInstMileId() {
		return instMileId;
	}

	public void setInstMileId(int instMileId) {
		this.instMileId = instMileId;
	}

	public String getMilestoneDesc() {
		return milestoneDesc;
	}

	public void setMilestoneDesc(String milestoneDesc) {
		this.milestoneDesc = milestoneDesc;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public int getInstallId() {
		return installId;
	}

	public void setInstallId(int installId) {
		this.installId = installId;
	}
	
	

}

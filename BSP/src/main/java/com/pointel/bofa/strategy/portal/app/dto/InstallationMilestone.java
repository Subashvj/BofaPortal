package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallationMilestone {
	
	
	private int instMileId;
	@Id
	private String milestoneDesc;
	private String startDate;
	private Date st;
	private String endDate;
	private Date ed;
	private int instMilestoneTypeId;
	private Date sd;
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
	public Date getSt() {
		return st;
	}
	public void setSt(Date st) {
		this.st = st;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Date getEd() {
		return ed;
	}
	public void setEd(Date ed) {
		this.ed = ed;
	}
	public int getInstMilestoneTypeId() {
		return instMilestoneTypeId;
	}
	public void setInstMilestoneTypeId(int instMilestoneTypeId) {
		this.instMilestoneTypeId = instMilestoneTypeId;
	}
	public Date getSd() {
		return sd;
	}
	public void setSd(Date sd) {
		this.sd = sd;
	}	
}

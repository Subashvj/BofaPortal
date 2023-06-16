package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class InstallMilestoneInfo {
	@Id
	private int instMileId;
	private String milestoneDesc;
	private String startdate;
	public int getInstMileId() {
		return instMileId;
	}
	public void setInstMileId(int instMileId) {
		this.instMileId = instMileId;
	}
	private Date sd;
	
	public String getMilestoneDesc() {
		return milestoneDesc;
	}
	public void setMilestoneDesc(String milestoneDesc) {
		this.milestoneDesc = milestoneDesc;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public Date getSd() {
		return sd;
	}
	public void setSd(Date sd) {
		this.sd = sd;
	}
	
	public Date getEd() {
		return ed;
	}
	public void setEd(Date ed) {
		this.ed = ed;
	}
	private String enddate;
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	private Date ed;
	
	

}

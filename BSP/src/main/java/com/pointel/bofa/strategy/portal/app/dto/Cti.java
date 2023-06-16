package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cti {
	@Id
	@Column(name = "STRAT_ID")
	private int stratId;//stratId
	
	@Column(name = "CTI_MONTH")
	private int cti_Month;//cti_Month
	
	@Column(name = "CTI_YEAR")
	private int cti_Year;//cti_Year
	
	@Column(name = "CTI_HOURS")
	private int cti_Hour;//cti_Hour
	@Column(name = "GROUP_NAME")
	private String groupName;//groupName
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getCti_Month() {
		return cti_Month;
	}
	public void setCti_Month(int cti_Month) {
		this.cti_Month = cti_Month;
	}
	public int getCti_Year() {
		return cti_Year;
	}
	public void setCti_Year(int cti_Year) {
		this.cti_Year = cti_Year;
	}
	public int getCti_Hour() {
		return cti_Hour;
	}
	public void setCti_Hour(int cti_Hour) {
		this.cti_Hour = cti_Hour;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/*
	public int getSTRAT_ID() {
		return STRAT_ID;
	}
	public void setSTRAT_ID(int sTRAT_ID) {
		STRAT_ID = sTRAT_ID;
	}
	public int getCTI_MONTH() {
		return CTI_MONTH;
	}
	public void setCTI_MONTH(int cTI_MONTH) {
		CTI_MONTH = cTI_MONTH;
	}
	public int getCTI_YEAR() {
		return CTI_YEAR;
	}
	public void setCTI_YEAR(int cTI_YEAR) {
		CTI_YEAR = cTI_YEAR;
	}
	public int getCTI_HOURS() {
		return CTI_HOURS;
	}
	public void setCTI_HOURS(int cTI_HOURS) {
		CTI_HOURS = cTI_HOURS;
	}
	public String getGROUP_NAME() {
		return GROUP_NAME;
	}
	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}*/
	
	

}

package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyWeeksAllocationInfo {

	@Id
	private int stratId;
	private int hours;
	private String seconds;
	private Date weekStart;
	private String stratName;
	
	public String getSeconds() {
		return seconds;
	}
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}
	
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public Date getWeekStart() {
		return weekStart;
	}
	public void setWeekStart(Date weekStart) {
		this.weekStart = weekStart;
	}
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	
	
	
	
}

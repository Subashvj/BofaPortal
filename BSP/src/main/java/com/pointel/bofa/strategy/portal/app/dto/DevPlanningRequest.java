package com.pointel.bofa.strategy.portal.app.dto;

public class DevPlanningRequest {
	
	
	private int stratIds;
	private int devHourss;
	
	
	private int devMonths;
	
	private int devYears;
	
	private String devUsers;

	
	public int getDevHourss() {
		return devHourss;
	}

	public void setDevHourss(int devHourss) {
		this.devHourss = devHourss;
	}

	public int getStratIds() {
		return stratIds;
	}

	public void setStratIds(int stratIds) {
		this.stratIds = stratIds;
	}

	public int getDevMonths() {
		return devMonths;
	}

	public void setDevMonths(int devMonths) {
		this.devMonths = devMonths;
	}

	public int getDevYears() {
		return devYears;
	}

	public void setDevYears(int devYears) {
		this.devYears = devYears;
	}

	public String getDevUsers() {
		return devUsers;
	}

	public void setDevUsers(String devUsers) {
		this.devUsers = devUsers;
	}

	

}

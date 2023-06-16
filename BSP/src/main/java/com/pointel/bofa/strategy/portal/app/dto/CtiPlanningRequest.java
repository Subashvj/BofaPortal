package com.pointel.bofa.strategy.portal.app.dto;

public class CtiPlanningRequest {
	
	private int stratId;
	private int ctiHours;
	private int ctiMonth;
	private int ctiYear;
	private int estimateGrp;
	
	public int getCtiHours() {
		return ctiHours;
	}
	public void setCtiHours(int ctiHours) {
		this.ctiHours = ctiHours;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getCtiMonth() {
		return ctiMonth;
	}
	public void setCtiMonth(int ctiMonth) {
		this.ctiMonth = ctiMonth;
	}
	public int getCtiYear() {
		return ctiYear;
	}
	public void setCtiYear(int ctiYear) {
		this.ctiYear = ctiYear;
	}
	public int getEstimateGrp() {
		return estimateGrp;
	}
	public void setEstimateGrp(int estimateGrp) {
		this.estimateGrp = estimateGrp;
	}
	

}

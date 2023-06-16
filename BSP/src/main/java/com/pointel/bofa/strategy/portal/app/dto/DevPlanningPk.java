package com.pointel.bofa.strategy.portal.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Embeddable
public class DevPlanningPk implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Column(name = "STRAT_ID")
	private int stratId;
	@Column(name = "DEV_MONTH")
	private int devMonth;
	@Column(name = "DEV_YEAR")
	private int devYear;
	@Column(name = "DEV_USER")
	private String devUser;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getDevMonth() {
		return devMonth;
	}
	public void setDevMonth(int devMonth) {
		this.devMonth = devMonth;
	}
	public int getDevYear() {
		return devYear;
	}
	public void setDevYear(int devYear) {
		this.devYear = devYear;
	}
	public String getDevUser() {
		return devUser;
	}
	public void setDevUser(String devUser) {
		this.devUser = devUser;
	}
	@Override
	public String toString() {
		return "DevPlanningPk [stratId=" + stratId + ", devMonth=" + devMonth + ", devYear=" + devYear + ", devUser="
				+ devUser + "]";
	}
}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResourcePlan {
	@Id
	@Column(name = "USERID")
	private String userId;

	@Column(name = "SHORTNAME")
	private String shortname;

	@Column(name = "STRAT_ID")
	private int stratId;

	@Column(name = "DEV_MONTH")
	private int devMonth;

	@Column(name = "DEV_YEAR")
	private int devYear;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

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

	public int getDevHours() {
		return devHours;
	}

	public void setDevHours(int devHours) {
		this.devHours = devHours;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	@Column(name = "DEV_HOURS")
	private int devHours;

	@Column(name = "DISPLAYNAME")
	private String displayname;



}

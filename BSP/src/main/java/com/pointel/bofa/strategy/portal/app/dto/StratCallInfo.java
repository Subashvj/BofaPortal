package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StratCallInfo {
	
	@Id
	@Column(name = "STRAT_ID")
	private int startId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "STARTDATE")
	private Date startDate;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "URL")
	private String url;

	public int getStartId() {
		return startId;
	}

	public void setStartId(int startId) {
		this.startId = startId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

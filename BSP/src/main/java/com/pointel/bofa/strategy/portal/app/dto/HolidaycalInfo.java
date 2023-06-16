package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HolidaycalInfo {
	
	
	@Id
	@Column(name = "STARTDATE")
	private Date startDate;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "RENDERING")
	private String rendering;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "TEXTCOLOR")
	private String textColor;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRendering() {
		return rendering;
	}

	public void setRendering(String rendering) {
		this.rendering = rendering;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class InstallCallInfo {
	
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "INSTSTART")
	private String instStart;
	
	@Column(name = "URL")
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstStart() {
		return instStart;
	}

	public void setInstStart(String instStart) {
		this.instStart = instStart;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}

package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LinkedInstallation {
	
	@Id
	@Column(name = "INSTALL_ID")
	private int installId;
	
	@Column(name = "INSTALL_TITLE")
	private String installTitle;
	
	@Column(name = "INST_ENVIRONMENT")
	private String instEnvironment;
	
	@Column(name = "INSTDATE")
	private String instDate;
	
	@Column(name = "INSTDATE2")
	private String instDate2;

	public int getInstallId() {
		return installId;
	}

	public void setInstallId(int installId) {
		this.installId = installId;
	}

	public String getInstallTitle() {
		return installTitle;
	}

	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}

	public String getInstEnvironment() {
		return instEnvironment;
	}

	public void setInstEnvironment(String instEnvironment) {
		this.instEnvironment = instEnvironment;
	}

	public String getInstDate() {
		return instDate;
	}

	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}

	public String getInstDate2() {
		return instDate2;
	}

	public void setInstDate2(String instDate2) {
		this.instDate2 = instDate2;
	}





}

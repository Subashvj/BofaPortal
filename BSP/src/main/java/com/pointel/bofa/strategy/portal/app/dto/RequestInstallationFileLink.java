package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;

public class RequestInstallationFileLink {
	private int typeId;
	private String fileDesc;
	private String fileLink;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

}

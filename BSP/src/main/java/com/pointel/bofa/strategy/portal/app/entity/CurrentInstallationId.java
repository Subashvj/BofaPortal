package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentInstallationId {
	@Id
	private String installId;

	public String getInstallId() {
		return installId;
	}

	public void setInstallId(String installId) {
		this.installId = installId;
	}

	
}

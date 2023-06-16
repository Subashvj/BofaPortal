package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallEnvironmentInfo {

	@Id
	private int instEnvId;
	private String instEnvironment;
	public int getInstEnvId() {
		return instEnvId;
	}
	public void setInstEnvId(int instEnvId) {
		this.instEnvId = instEnvId;
	}
	public String getInstEnvironment() {
		return instEnvironment;
	}
	public void setInstEnvironment(String instEnvironment) {
		this.instEnvironment = instEnvironment;
	}
}

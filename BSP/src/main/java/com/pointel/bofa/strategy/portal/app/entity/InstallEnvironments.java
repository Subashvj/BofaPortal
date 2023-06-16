package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InstallEnvironments {

	@Id
	@SequenceGenerator(name="InstallEnvironmentsSequence",sequenceName="INSTALL_ENVIRONMENTS_INST__SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="InstallEnvironmentsSequence")
	private int instEnvId;
	private String instEnvironment;
	private int instEnvVisible;
	
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
	public int getInstEnvVisible() {
		return instEnvVisible;
	}
	public void setInstEnvVisible(int instEnvVisible) {
		this.instEnvVisible = instEnvVisible;
	}
}

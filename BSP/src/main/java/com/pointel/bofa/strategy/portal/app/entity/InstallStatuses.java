package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class InstallStatuses{
	

	@Id
	@SequenceGenerator(name="installStatusesSequence",sequenceName="INSTALL_STATUSES_INSTALL_S_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="installStatusesSequence")
	private int installStatusId;
	private String installStatusDesc;
	public int getInstallStatusId() {
		return installStatusId;
	}
	public void setInstallStatusId(int installStatusId) {
		this.installStatusId = installStatusId;
	}
	public String getInstallStatusDesc() {
		return installStatusDesc;
	}
	public void setInstallStatusDesc(String installStatusDesc) {
		this.installStatusDesc = installStatusDesc;
	}
	
	
}

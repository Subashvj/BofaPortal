package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSTALL_TYPES")
public class InstallTypesInfo {
	@Id
	@Column(name="INSTALL_TYPE")
	private int installType;
	@Column(name="INSTALL_TYPE_DESC")
	private String installTypeDesc;
	//@Column(name="INSTALL_TYPE_DESC_SHORT")
	private String installTypeDescShort;
	
	public int getInstallType() {
		return installType;
	}
	public void setInstallType(int installType) {
		this.installType = installType;
	}
	public String getInstallTypeDesc() {
		return installTypeDesc;
	}
	public void setInstallTypeDesc(String installTypeDesc) {
		this.installTypeDesc = installTypeDesc;
	}
	public String getInstallTypeDescShort() {
		return installTypeDescShort;
	}
	public void setInstallTypeDescShort(String installTypeDescShort) {
		this.installTypeDescShort = installTypeDescShort;
	}


}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InstallTypes {
	@Id
	@Column(name = "INSTALL_TYPE")
	@SequenceGenerator(name = "installTypesSequence", sequenceName = "INSTALL_TYPES_INSTALL_TYPE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "installTypesSequence")
	private int installType;
	@Column(name = "INSTALL_TYPE_DESC")
	private String installTypeDesc;
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

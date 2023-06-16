package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STRAT_TO_INSTALL")
public class StratToInstall {
	
	@Id
	private int installId;
	private int stratId;
	private Date linkDate;
	private String linkBy;
	public int getInstallId() {
		return installId;
	}
	public void setInstallId(int installId) {
		this.installId = installId;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public Date getLinkDate() {
		return linkDate;
	}
	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}
	public String getLinkBy() {
		return linkBy;
	}
	public void setLinkBy(String linkBy) {
		this.linkBy = linkBy;
	}
	
}

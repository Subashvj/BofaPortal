package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallLinked {
	
	
	private int installId;
	@Id
	private int stratId;
	private String stratName;
	private String stratCatDesc;
	private String stratStatusDesc;
	private int stratColor;
	private String lobDesc;
	private String stratPhaseDesc;
	private int stratStatusId;
	private String pmname;
	private int futureinst;
	private String addedby;
	private Date linkDate;
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
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	public String getStratCatDesc() {
		return stratCatDesc;
	}
	public void setStratCatDesc(String stratCatDesc) {
		this.stratCatDesc = stratCatDesc;
	}
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
	public int getStratColor() {
		return stratColor;
	}
	public void setStratColor(int stratColor) {
		this.stratColor = stratColor;
	}
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	public String getStratPhaseDesc() {
		return stratPhaseDesc;
	}
	public void setStratPhaseDesc(String stratPhaseDesc) {
		this.stratPhaseDesc = stratPhaseDesc;
	}
	public int getStratStatusId() {
		return stratStatusId;
	}
	public void setStratStatusId(int stratStatusId) {
		this.stratStatusId = stratStatusId;
	}
	public String getPmname() {
		return pmname;
	}
	public void setPmname(String pmname) {
		this.pmname = pmname;
	}
	public int getFutureinst() {
		return futureinst;
	}
	public void setFutureinst(int futureinst) {
		this.futureinst = futureinst;
	}
	public String getAddedby() {
		return addedby;
	}
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	public Date getLinkDate() {
		return linkDate;
	}
	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}
	
}

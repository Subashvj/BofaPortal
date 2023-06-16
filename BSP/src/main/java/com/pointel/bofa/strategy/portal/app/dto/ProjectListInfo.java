package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ProjectListInfo {

	@Id
    private int stratId;
	private String stratName;
	private String stratStatusDesc;
	private String stratCatDesc;
	private String applicationName;
	private String targetDate;
	private String fullDeploy;
	private String lobDesc;
	private String componentName;
	private String stratPhaseDesc;	
	private String platformTypeDescription;
	
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
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
	public String getStratCatDesc() {
		return stratCatDesc;
	}
	public void setStratCatDesc(String stratCatDesc) {
		this.stratCatDesc = stratCatDesc;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getStratPhaseDesc() {
		return stratPhaseDesc;
	}
	public void setStratPhaseDesc(String stratPhaseDesc) {
		this.stratPhaseDesc = stratPhaseDesc;
	}
	public String getPlatformTypeDescription() {
		return platformTypeDescription;
	}
	public void setPlatformTypeDescription(String platformTypeDescription) {
		this.platformTypeDescription = platformTypeDescription;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getFullDeploy() {
		return fullDeploy;
	}
	public void setFullDeploy(String fullDeploy) {
		this.fullDeploy = fullDeploy;
	}
	
	
	
}

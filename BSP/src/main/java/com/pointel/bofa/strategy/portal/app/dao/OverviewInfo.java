package com.pointel.bofa.strategy.portal.app.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class OverviewInfo {
	@Id
	private int stratId;	
	private String stratName;
	private String stratRequestor;
	private String stratRequestorDept;
	private String stratPhaseDesc;
	private String stratObjectives;
	private String stratBusJust;
	private String stratBenefit;
	private String stratAddedBy;
	private String addbyname;
	private int stratCategory;
	private String stratCatDesc;
	private String stratUpdate;	
    private String targetDate;	
    private String startDate;
    public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	private String analystSummary;
    private int targetFirm;   
    private Date stratStatusdate;
    private int execview;
    private String stratStatusDesc;
    private int stratStatusId;
    private String lobDesc;
    private int StratColor;
    private String execStatus;   
    private Date sizingDue;    
    private Date kickoffDate;
    private String stratReqBusArea; 
    private Date stratAdded;
    private int cast;
    private String applicationName;
    private String ivrSolutionDesc;
    private int pprt;
    private int ucra; 
    private Date fullDeploy;
    private String stratColorDesc;
    private String area;
    private String displayname;
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
	public String getStratRequestor() {
		return stratRequestor;
	}
	public void setStratRequestor(String stratRequestor) {
		this.stratRequestor = stratRequestor;
	}
	public String getStratRequestorDept() {
		return stratRequestorDept;
	}
	public void setStratRequestorDept(String stratRequestorDept) {
		this.stratRequestorDept = stratRequestorDept;
	}
	public String getStratPhaseDesc() {
		return stratPhaseDesc;
	}
	public void setStratPhaseDesc(String stratPhaseDesc) {
		this.stratPhaseDesc = stratPhaseDesc;
	}
	public String getStratObjectives() {
		return stratObjectives;
	}
	public void setStratObjectives(String stratObjectives) {
		this.stratObjectives = stratObjectives;
	}
	public String getStratBusJust() {
		return stratBusJust;
	}
	public void setStratBusJust(String stratBusJust) {
		this.stratBusJust = stratBusJust;
	}
	public String getStratBenefit() {
		return stratBenefit;
	}
	public void setStratBenefit(String stratBenefit) {
		this.stratBenefit = stratBenefit;
	}
	public String getStratAddedBy() {
		return stratAddedBy;
	}
	public void setStratAddedBy(String stratAddedBy) {
		this.stratAddedBy = stratAddedBy;
	}
	public String getAddbyname() {
		return addbyname;
	}
	public void setAddbyname(String addbyname) {
		this.addbyname = addbyname;
	}
	public int getStratCategory() {
		return stratCategory;
	}
	public void setStratCategory(int stratCategory) {
		this.stratCategory = stratCategory;
	}
	public String getStratCatDesc() {
		return stratCatDesc;
	}
	public void setStratCatDesc(String stratCatDesc) {
		this.stratCatDesc = stratCatDesc;
	}
	public String getStratUpdate() {
		return stratUpdate;
	}
	public void setStratUpdate(String stratUpdate) {
		this.stratUpdate = stratUpdate;
	}
	public String getAnalystSummary() {
		return analystSummary;
	}
	public void setAnalystSummary(String analystSummary) {
		this.analystSummary = analystSummary;
	}
	public int getTargetFirm() {
		return targetFirm;
	}
	public void setTargetFirm(int targetFirm) {
		this.targetFirm = targetFirm;
	}
	public Date getStratStatusdate() {
		return stratStatusdate;
	}
	public void setStratStatusdate(Date stratStatusdate) {
		this.stratStatusdate = stratStatusdate;
	}
	public int getExecview() {
		return execview;
	}
	public void setExecview(int execview) {
		this.execview = execview;
	}
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
	public int getStratStatusId() {
		return stratStatusId;
	}
	public void setStratStatusId(int stratStatusId) {
		this.stratStatusId = stratStatusId;
	}
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	public int getStratColor() {
		return StratColor;
	}
	public void setStratColor(int stratColor) {
		StratColor = stratColor;
	}
	public String getExecStatus() {
		return execStatus;
	}
	public void setExecStatus(String execStatus) {
		this.execStatus = execStatus;
	}
	public Date getSizingDue() {
		return sizingDue;
	}
	public void setSizingDue(Date sizingDue) {
		this.sizingDue = sizingDue;
	}
	public Date getKickoffDate() {
		return kickoffDate;
	}
	public void setKickoffDate(Date kickoffDate) {
		this.kickoffDate = kickoffDate;
	}
	public String getStratReqBusArea() {
		return stratReqBusArea;
	}
	public void setStratReqBusArea(String stratReqBusArea) {
		this.stratReqBusArea = stratReqBusArea;
	}
	public Date getStratAdded() {
		return stratAdded;
	}
	public void setStratAdded(Date stratAdded) {
		this.stratAdded = stratAdded;
	}
	public int getCast() {
		return cast;
	}
	public void setCast(int cast) {
		this.cast = cast;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getIvrSolutionDesc() {
		return ivrSolutionDesc;
	}
	public void setIvrSolutionDesc(String ivrSolutionDesc) {
		this.ivrSolutionDesc = ivrSolutionDesc;
	}
	public int getPprt() {
		return pprt;
	}
	public void setPprt(int pprt) {
		this.pprt = pprt;
	}
	public int getUcra() {
		return ucra;
	}
	public void setUcra(int ucra) {
		this.ucra = ucra;
	}
	public Date getFullDeploy() {
		return fullDeploy;
	}
	public void setFullDeploy(Date fullDeploy) {
		this.fullDeploy = fullDeploy;
	}
	public String getStratColorDesc() {
		return stratColorDesc;
	}
	public void setStratColorDesc(String stratColorDesc) {
		this.stratColorDesc = stratColorDesc;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
    
    
    
    

}

package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallationTasks {
	
	
	@Column(name="INSTALL_ID")
	private int installId;
	
	@Column(name="INSTALL_TITLE")
	private String installTitle;
	
	@Column(name="INSTALL_DATE")
	private Date installDate;
	
	@Column(name="INSTALL_END")
	private Date installEnd;
	
	@Id
	@Column(name="STRAT_ID")
	private int stratId;
	
	@Column(name="STRAT_NAME")
	private String stratName;
	
	@Column(name="TASK_ID")
	private int taskId;
	
	@Column(name="TASK_DESC")
	private String taskDesc;
	
	@Column(name="TASK_START")
	private Date taskStart;
	
	@Column(name="TASK_DUE")
	private Date taskDue;
	
	@Column(name="TASK_PERCENT")
	private int taskPercent;
	
	@Column(name="TASK_STATUS_DESC")
	private String taskStatusDesc;
	
	@Column(name="DISPLAYNAME")
	private String displayname;
	
	@Column(name="LAST_UPDATE")
	private String lastUpdate;
	
	@Column(name="MILESTONE_DESC")
	private String milestoneDesc;
	
	@Column(name="TASK_NOTES")
	private String taskNotes;
	
	@Column(name="TASK_STATUS_ID")
	private int taskStatusId;
	
	@Column(name="PASTDUE")
	private int pastdue;
	
	@Column(name="STARTED")
	private int started;
	
	@Column(name="TASK_START_F")
	private String taskStartF;
	
	@Column(name="TASK_DUE_F")
	private String taskDueF;
	
	@Column(name="BUSDAYS")
	private int busdays;
	
	@Column(name="SHOULDBE")
	private double shouldbe;
	public int getInstallId() {
		return installId;
	}
	public void setInstallId(int installId) {
		this.installId = installId;
	}
	public String getInstallTitle() {
		return installTitle;
	}
	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	public Date getInstallEnd() {
		return installEnd;
	}
	public void setInstallEnd(Date installEnd) {
		this.installEnd = installEnd;
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
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(Date taskStart) {
		this.taskStart = taskStart;
	}
	public Date getTaskDue() {
		return taskDue;
	}
	public void setTaskDue(Date taskDue) {
		this.taskDue = taskDue;
	}
	public int getTaskPercent() {
		return taskPercent;
	}
	public void setTaskPercent(int taskPercent) {
		this.taskPercent = taskPercent;
	}
	public String getTaskStatusDesc() {
		return taskStatusDesc;
	}
	public void setTaskStatusDesc(String taskStatusDesc) {
		this.taskStatusDesc = taskStatusDesc;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getMilestoneDesc() {
		return milestoneDesc;
	}
	public void setMilestoneDesc(String milestoneDesc) {
		this.milestoneDesc = milestoneDesc;
	}
	
	public String getTaskNotes() {
		return taskNotes;
	}
	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}
	public int getTaskStatusId() {
		return taskStatusId;
	}
	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	public int getPastdue() {
		return pastdue;
	}
	public void setPastdue(int pastdue) {
		this.pastdue = pastdue;
	}
	public int getStarted() {
		return started;
	}
	public void setStarted(int started) {
		this.started = started;
	}
	public String getTaskStartF() {
		return taskStartF;
	}
	public void setTaskStartF(String taskStartF) {
		this.taskStartF = taskStartF;
	}
	public String getTaskDueF() {
		return taskDueF;
	}
	public void setTaskDueF(String taskDueF) {
		this.taskDueF = taskDueF;
	}
	public int getBusdays() {
		return busdays;
	}
	public void setBusdays(int busdays) {
		this.busdays = busdays;
	}
	public double getShouldbe() {
		return shouldbe;
	}
	public void setShouldbe(double shouldbe) {
		this.shouldbe = shouldbe;
	}
	
}

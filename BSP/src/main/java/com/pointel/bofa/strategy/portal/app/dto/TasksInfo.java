package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TasksInfo {
	
	@Id
	@Column(name = "TASK_ID")
	private int taskId;
	
	@Column(name = "TASK_DESC")
	private String taskDesc;
	
	@Column(name = "TASK_START_F")
	private String taskStartF;
	
	@Column(name = "TASK_DUE_F")
	private String taskDueF;
	
	@Column(name = "TASK_START")
	private Date taskStart;
	
	@Column(name = "TASK_DUE")
	private Date taskDue;
	
	@Column(name = "TASK_PERCENT")
	private int taskPercent;
	
	@Column(name = "TASK_STATUS_DESC")
	private String taskStatusDesc;
	
	@Column(name = "DISPLAYNAME")
	private String displayname;
	
	@Column(name = "MILESTONE_DESC")
	private String milestoneDesc;
	
	@Column(name = "TASK_STATUS_ID")
	private int taskStatusId;
	
	@Column(name = "SHOULDBE")
	private double shouldbe;
	
	@Column(name = "MILESTONE_ID")
	private int milestoneId;
	
	@Column(name = "BUSDAYS")
	private int busdays;
	
	@Column(name = "STRAT_PHASE_ID")
	private int stratPhaseId;
	
	@Column(name = "ASSIGNED_TO")
	private String assignedTo;
	
	@Column(name = "TASK_NOTES")
	private String taskNotes;
	
	@Column(name = "ASSIGNEDBY")
	private String assignedby;
	
	@Column(name = "CURASSIGNBY")
	private String curassignby;
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
	public String getMilestoneDesc() {
		return milestoneDesc;
	}
	public void setMilestoneDesc(String milestoneDesc) {
		this.milestoneDesc = milestoneDesc;
	}
	public int getTaskStatusId() {
		return taskStatusId;
	}
	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	
	
	
	public double getShouldbe() {
		return shouldbe;
	}
	public void setShouldbe(double shouldbe) {
		this.shouldbe = shouldbe;
	}
	public int getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}
	public int getBusdays() {
		return busdays;
	}
	public void setBusdays(int busdays) {
		this.busdays = busdays;
	}
	public int getStratPhaseId() {
		return stratPhaseId;
	}
	public void setStratPhaseId(int stratPhaseId) {
		this.stratPhaseId = stratPhaseId;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public String getTaskNotes() {
		return taskNotes;
	}
	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}
	public String getAssignedby() {
		return assignedby;
	}
	public void setAssignedby(String assignedby) {
		this.assignedby = assignedby;
	}
	public String getCurassignby() {
		return curassignby;
	}
	public void setCurassignby(String curassignby) {
		this.curassignby = curassignby;
	}
	
	
	
}

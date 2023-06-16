package com.pointel.bofa.strategy.portal.app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TaskBean {
	
	@Id
	@Column(name = "STRAT_ID")
	private int stratId;
	
	@Column(name = "TASK_DESC")
	private String taskDesc;
	
	@Column(name = "TASK_START")
	private String taskStart;
	
	@Column(name = "TASK_DUE")
	private String taskDue;
	
	@Column(name = "TASK_PERCENT")
	private int taskPercent;
	
	@Column(name = "TASK_STATUS_ID")
	private int taskStatusId;
	
	@Column(name = "ASSIGNED_TO")
	private String assignedTo;
	
	@Column(name = "ASSIGNEDTONAME")  
	private String assignedToName;
	
	@Column(name = "ASSIGNEDBYNAME")
	private String assignedByName;
	
	@Column(name = "ASSIGNED_BY")
	private String assignedby;
	
	@Column(name = "DISPLAYNAME")
	private String displayname;
	
	@Column(name = "ADD_DATE")  
	private String addDate;
	
	@Column(name = "LAST_UPDATE")  
	private String lastUpdate;
	
	@Column(name = "MILESTONE_ID")  
	private int milestoneId;
	
	@Column(name = "TASK_NOTES")  
	private String taskNotes;
	
	@Column(name = "STRAT_PHASE_ID")  
	private int stratPhaseId;

	public int getStratId() {
		return stratId;
	}

	public void setStratId(int stratId) {
		this.stratId = stratId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}

	public String getTaskDue() {
		return taskDue;
	}

	public void setTaskDue(String taskDue) {
		this.taskDue = taskDue;
	}

	public int getTaskPercent() {
		return taskPercent;
	}

	public void setTaskPercent(int taskPercent) {
		this.taskPercent = taskPercent;
	}

	public int getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedToName() {
		return assignedToName;
	}

	public void setAssignedToName(String assignedToName) {
		this.assignedToName = assignedToName;
	}

	public String getAssignedByName() {
		return assignedByName;
	}

	public void setAssignedByName(String assignedByName) {
		this.assignedByName = assignedByName;
	}

	public String getAssignedby() {
		return assignedby;
	}

	public void setAssignedby(String assignedby) {
		this.assignedby = assignedby;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getTaskNotes() {
		return taskNotes;
	}

	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}

	public int getStratPhaseId() {
		return stratPhaseId;
	}

	public void setStratPhaseId(int stratPhaseId) {
		this.stratPhaseId = stratPhaseId;
	}
	


	
	
	
}


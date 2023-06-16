package com.pointel.bofa.strategy.portal.app.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "STRAT_TASKS")
@JsonInclude(Include.NON_NULL)
public class StratTasks {	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private BigInteger taskId;
	
	@Id
	@GeneratedValue( generator = "STRAT_TASKS_TASK_ID_SEQ",   strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "STRAT_TASKS_TASK_ID_SEQ", sequenceName = "STRAT_TASKS_TASK_ID_SEQ", allocationSize = 1)
	@Column(name ="TASK_ID")
	private BigInteger taskId;
	
	@Column(name ="STRAT_ID")
	private int stratId;
	
	@Column(name ="TASK_DESC")
	private String taskDesc;
	
	@Column(name ="TASK_START")
	private Date taskStrat;
	
	@Column(name ="TASK_DUE")
	private Date taskDue;
	
	@Column(name ="TASK_PERCENT")
	private int taskPercent;
	
	@Column(name ="TASK_STATUS_ID")
	private int taskStatusId;
	
	@Column(name ="TASK_STAT_COLOR")
	private int taskStatColor;
	
	@Column(name ="TASK_TREND_COLOR")
	private int taskTrendColor;
	
	@Column(name ="ASSIGNED_TO")
	private String assignedTo;
	
	@Column(name ="ASSIGNED_BY")
	private String assignedBy;
	
	@Column(name ="ADD_DATE")
	private String addDate;
	
	@Column(name ="LAST_UPDATE")
	private String lastUpdate;
	
	@Column(name ="MILESTONE_ID")
	private int mileStoneId;
	
	@Column(name ="TASK_NOTES")
	private String taskNotes;
	
	@Column(name ="TASK_DURATION")
	private int taskDuration;
	
	@Column(name ="STRAT_PHASE_ID")
	private int stratPhaseId;
	
//	@Transient
//	private String currentAssign;
//	
//	@Transient
//	private String currentAssignBy;

	public BigInteger getTaskId() {
		return taskId;
	}

	public void setTaskId(BigInteger taskId) {
		this.taskId = taskId;
	}

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

	public Date getTaskStrat() {
		return taskStrat;
	}

	public void setTaskStrat(Date taskStrat) {
		this.taskStrat = taskStrat;
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

	public int getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public int getTaskStatColor() {
		return taskStatColor;
	}

	public void setTaskStatColor(int taskStatColor) {
		this.taskStatColor = taskStatColor;
	}

	public int getTaskTrendColor() {
		return taskTrendColor;
	}

	public void setTaskTrendColor(int taskTrendColor) {
		this.taskTrendColor = taskTrendColor;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
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

	public int getMileStoneId() {
		return mileStoneId;
	}

	public void setMileStoneId(int mileStoneId) {
		this.mileStoneId = mileStoneId;
	}

	public String getTaskNotes() {
		return taskNotes;
	}

	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}

	public int getTaskDuration() {
		return taskDuration;
	}

	public void setTaskDuration(int taskDuration) {
		this.taskDuration = taskDuration;
	}

	public int getStratPhaseId() {
		return stratPhaseId;
	}

	public void setStratPhaseId(int stratPhaseId) {
		this.stratPhaseId = stratPhaseId;
	}

//	public String getCurrentAssign() {
//		return currentAssign;
//	}
//
//	public void setCurrentAssign(String currentAssign) {
//		this.currentAssign = currentAssign;
//	}
//
//	public String getCurrentAssignBy() {
//		return currentAssignBy;
//	}
//
//	public void setCurrentAssignBy(String currentAssignBy) {
//		this.currentAssignBy = currentAssignBy;
//	}
}

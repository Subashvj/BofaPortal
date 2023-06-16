package com.pointel.bofa.strategy.portal.app.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyTaskInfo {
	
	@Id
    private BigInteger taskId;
	
	private int stratId;
	
	private String taskDesc;
	
	private String taskDue;
	
	private String taskDueShort;
	
	
	

	public String getTaskDueShort() {
		return taskDueShort;
	}

	public void setTaskDueShort(String taskDueShort) {
		this.taskDueShort = taskDueShort;
	}

	private String stratName;

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

	public String getTaskDue() {
		return taskDue;
	}

	public void setTaskDue(String taskDue) {
		this.taskDue = taskDue;
	}

	public String getStratName() {
		return stratName;
	}

	public void setStratName(String stratName) {
		this.stratName = stratName;
	}

	@Override
	public String toString() {
		return "MyTaskInfo [taskId=" + taskId + ", stratId=" + stratId + ", taskDesc=" + taskDesc + ", taskDue="
				+ taskDue + ", taskDueShort=" + taskDueShort + ", stratName=" + stratName + "]";
	}

	
	
	
	
	
	
}

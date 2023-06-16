package com.pointel.bofa.strategy.portal.app.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyTeamTaskInfo {
	
	@Id
	private BigInteger taskId;
	private int stratId;
	private String taskDesc;
	private String taskDueShort;
	private Date taskDue;
	private String userid;
	private String displayname;
	private String shortname;
	private int taskPercent;
	private String lastUpdate;
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
	public String getTaskDueShort() {
		return taskDueShort;
	}
	public void setTaskDueShort(String taskDueShort) {
		this.taskDueShort = taskDueShort;
	}
	public Date getTaskDue() {
		return taskDue;
	}
	public void setTaskDue(Date taskDue) {
		this.taskDue = taskDue;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public int getTaskPercent() {
		return taskPercent;
	}
	public void setTaskPercent(int taskPercent) {
		this.taskPercent = taskPercent;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	
	

}

package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyProjectInfo {

	@Id
	private int stratId;
	private String stratName;
	private int stratColor;
	private String stratPhaseDesc;
	private String fulldeploy;
	private String roleDesc;
	private String stratStatusDesc;
	private String taskcount;
	
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
		
	public String getTaskcount() {
		return taskcount;
	}
	public void setTaskcount(String taskcount) {
		this.taskcount = taskcount;
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
	public int getStratColor() {
		return stratColor;
	}
	public void setStratColor(int stratColor) {
		this.stratColor = stratColor;
	}
	public String getStratPhaseDesc() {
		return stratPhaseDesc;
	}
	public void setStratPhaseDesc(String stratPhaseDesc) {
		this.stratPhaseDesc = stratPhaseDesc;
	}
	public String getFulldeploy() {
		return fulldeploy;
	}
	public void setFulldeploy(String fulldeploy) {
		this.fulldeploy = fulldeploy;
	}
	
				
}

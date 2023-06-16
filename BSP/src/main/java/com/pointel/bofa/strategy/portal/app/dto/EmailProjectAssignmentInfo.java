package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class EmailProjectAssignmentInfo {
	@Id
	private int stratId;
	private String stratName;
	private int stratStatusId;
	private String stratStatusDesc;
	private String stratObjectives;
	private String stratRequestor;
	private String stratRequestorDept;
	private String lobDesc;
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
	public int getStratStatusId() {
		return stratStatusId;
	}
	public void setStratStatusId(int stratStatusId) {
		this.stratStatusId = stratStatusId;
	}
	public String getStratStatusDesc() {
		return stratStatusDesc;
	}
	public void setStratStatusDesc(String stratStatusDesc) {
		this.stratStatusDesc = stratStatusDesc;
	}
	public String getStratObjectives() {
		return stratObjectives;
	}
	public void setStratObjectives(String stratObjectives) {
		this.stratObjectives = stratObjectives;
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
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	
}

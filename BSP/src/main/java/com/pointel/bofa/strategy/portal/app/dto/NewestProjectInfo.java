package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewestProjectInfo {
	
	@Id
	private int stratId;
	private String stratName;
	private String stratAddedBy;
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
	public String getStratAddedBy() {
		return stratAddedBy;
	}
	public void setStratAddedBy(String stratAddedBy) {
		this.stratAddedBy = stratAddedBy;
	}
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	
	@Override
	public String toString() {
		return "NewestProjectInfo [stratId=" + stratId + ", stratName=" + stratName + ", stratAddedBy=" + stratAddedBy
				+ ", lobDesc=" + lobDesc + "]";
	}
	
	
	

}

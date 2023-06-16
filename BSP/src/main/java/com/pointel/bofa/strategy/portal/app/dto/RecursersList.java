package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecursersList {

	@Id
	private int stratId;
	private int estimateGrp;
	private String groupName;
	private String owner;
	private String displayname;
	private int projRole;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getEstimateGrp() {
		return estimateGrp;
	}
	public void setEstimateGrp(int estimateGrp) {
		this.estimateGrp = estimateGrp;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public int getProjRole() {
		return projRole;
	}
	public void setProjRole(int projRole) {
		this.projRole = projRole;
	}
}

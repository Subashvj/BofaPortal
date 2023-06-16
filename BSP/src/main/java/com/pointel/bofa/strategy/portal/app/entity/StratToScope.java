package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class StratToScope {
	@Id
	private int scopeId;
	private int stratId;
	private int scopeType;
	private String scopeUserid;
	private Date scopeDate;
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getScopeType() {
		return scopeType;
	}
	public void setScopeType(int scopeType) {
		this.scopeType = scopeType;
	}
	public String getScopeUserid() {
		return scopeUserid;
	}
	public void setScopeUserid(String scopeUserid) {
		this.scopeUserid = scopeUserid;
	}
	public Date getScopeDate() {
		return scopeDate;
	}
	public void setScopeDate(Date scopeDate) {
		this.scopeDate = scopeDate;
	}

}

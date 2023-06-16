package com.pointel.bofa.strategy.portal.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Embeddable
public class StratToGroupPk implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int stratId;
	private int usergroup;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(int usergroup) {
		this.usergroup = usergroup;
	}
	@Override
	public String toString() {
		return "StratToGroup [stratId=" + stratId + ", usergroup=" + usergroup + "]";
	}
	
}

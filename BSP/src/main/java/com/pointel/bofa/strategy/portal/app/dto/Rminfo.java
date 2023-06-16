package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rminfo {
	@Id
	private int execview;
	private int priorityhide;
	private int autoSurvey;
	private int selfaudit;
	public int getExecview() {
		return execview;
	}
	public void setExecview(int execview) {
		this.execview = execview;
	}
	public int getPriorityhide() {
		return priorityhide;
	}
	public void setPriorityhide(int priorityhide) {
		this.priorityhide = priorityhide;
	}
	public int getAutoSurvey() {
		return autoSurvey;
	}
	public void setAutoSurvey(int autoSurvey) {
		this.autoSurvey = autoSurvey;
	}
	public int getSelfaudit() {
		return selfaudit;
	}
	public void setSelfaudit(int selfaudit) {
		this.selfaudit = selfaudit;
	}

}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TechComponentsEditInfo {
	@Id
	private int componentId;
	private String componentName;
	private String incl;
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public String getIncl() {
		return incl;
	}
	public void setIncl(String incl) {
		this.incl = incl;
	}
	
	
	

}

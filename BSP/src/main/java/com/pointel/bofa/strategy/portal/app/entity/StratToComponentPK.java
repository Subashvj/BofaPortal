package com.pointel.bofa.strategy.portal.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Embeddable
public class StratToComponentPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int stratId;
	private int componentId;
	
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	
	
	
}

package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class UpdateTechComponentRequest {
	
	private int stratId;
	private List<Integer> componentId;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public List<Integer> getComponentId() {
		return componentId;
	}
	public void setComponentId(List<Integer> componentId) {
		this.componentId = componentId;
	}
}

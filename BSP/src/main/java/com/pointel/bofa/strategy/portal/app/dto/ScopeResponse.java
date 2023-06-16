package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class ScopeResponse {
	
	private List<ScopeDesign> scopeDesign;
	private List<ScopeTesting> scopeTesting;
	private List<ScopeAnalytics> scopeAnalytics;
	public List<ScopeDesign> getScopeDesign() {
		return scopeDesign;
	}
	public void setScopeDesign(List<ScopeDesign> scopeDesign) {
		this.scopeDesign = scopeDesign;
	}
	public List<ScopeTesting> getScopeTesting() {
		return scopeTesting;
	}
	public void setScopeTesting(List<ScopeTesting> scopeTesting) {
		this.scopeTesting = scopeTesting;
	}
	public List<ScopeAnalytics> getScopeAnalytics() {
		return scopeAnalytics;
	}
	public void setScopeAnalytics(List<ScopeAnalytics> scopeAnalytics) {
		this.scopeAnalytics = scopeAnalytics;
	}
	
}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScopeAnalytics {
	
	@Id
	@Column(name = "IMPACT_CHAMPCHALL")
	private int impactChampchall;

	public int getImpactChampchall() {
		return impactChampchall;
	}

	public void setImpactChampchall(int impactChampchall) {
		this.impactChampchall = impactChampchall;
	}
	
}

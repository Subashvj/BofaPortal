package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StrategiesInfo {
	
	@Id
	@Column(name = "STRAT_ID") 
	private int stratId;
	
	@Column(name = "STRAT_NAME")
	private String stratName;

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

}

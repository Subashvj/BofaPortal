package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MytaskPastInfo {
	@Id
	private int pastdue;

	public int getPastdue() {
		return pastdue;
	}

	public void setPastdue(int pastdue) {
		this.pastdue = pastdue;
	}

	

	
	


}

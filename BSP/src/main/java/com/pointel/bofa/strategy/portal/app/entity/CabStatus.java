package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CabStatus {

	@Id
	private int cabStatus;
	private String cabStatusDescription;
	public int getCabStatus() {
		return cabStatus;
	}
	public void setCabStatus(int cabStatus) {
		this.cabStatus = cabStatus;
	}
	public String getCabStatusDescription() {
		return cabStatusDescription;
	}
	public void setCabStatusDescription(String cabStatusDescription) {
		this.cabStatusDescription = cabStatusDescription;
	}
	
}

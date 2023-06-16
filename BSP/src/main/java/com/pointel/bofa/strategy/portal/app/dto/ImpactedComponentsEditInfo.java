package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImpactedComponentsEditInfo {
	@Id
	private int productId;
	private String productName;
	private String incl;
	public String getIncl() {
		return incl;
	}
	public void setIncl(String incl) {
		this.incl = incl;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	

}

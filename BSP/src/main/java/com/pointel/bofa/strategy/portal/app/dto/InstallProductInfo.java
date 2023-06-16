package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class InstallProductInfo {
	@Id
	private String productName;
	private int tot;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}

}

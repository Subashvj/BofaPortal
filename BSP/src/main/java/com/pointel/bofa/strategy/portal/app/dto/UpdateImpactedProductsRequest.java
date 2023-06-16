package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class UpdateImpactedProductsRequest {
	private int stratId;
	private List<Integer> productId;
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	
	

}

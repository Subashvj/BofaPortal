package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class StratToProduct {
	@EmbeddedId
	private StratToProductPK stratToProductPK;

	public StratToProductPK getStratToProductPK() {
		return stratToProductPK;
	}

	public void setStratToProductPK(StratToProductPK stratToProductPK) {
		this.stratToProductPK = stratToProductPK;
	}

}

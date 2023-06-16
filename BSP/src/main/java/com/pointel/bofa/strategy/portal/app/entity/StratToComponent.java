package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StratToComponent {
@EmbeddedId	
	private StratToComponentPK stratToComponentPK;

	public StratToComponentPK getStratToComponentPK() {
		return stratToComponentPK;
	}

	public void setStratToComponentPK(StratToComponentPK stratToComponentPK) {
		this.stratToComponentPK = stratToComponentPK;
	}
	
}

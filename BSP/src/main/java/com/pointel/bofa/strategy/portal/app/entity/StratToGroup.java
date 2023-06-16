package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StratToGroup {
	@EmbeddedId
	private StratToGroupPk stratToGroupPk;

	public StratToGroupPk getStratToGroupPk() {
		return stratToGroupPk;
	}

	public void setStratToGroupPk(StratToGroupPk stratToGroupPk) {
		this.stratToGroupPk = stratToGroupPk;
	}

}

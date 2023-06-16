package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.pointel.bofa.strategy.portal.app.entity.CtiPlanningPk;

@Entity
@DynamicUpdate
//@Table(name = "CTI_PLANNING")
public class CtiPlanning {
	
	@Column(name = "CTI_HOURS")
	private int ctiHours;
	
	public int getCtiHours() {
		return ctiHours;
	}
	public void setCtiHours(int ctiHours) {
		this.ctiHours = ctiHours;
	}
	@EmbeddedId
	private CtiPlanningPk ctiPlanningPk;
	
	
	public CtiPlanningPk getCtiPlanningPk() {
		return ctiPlanningPk;
	}
	public void setCtiPlanningPk(CtiPlanningPk ctiPlanningPk) {
		this.ctiPlanningPk = ctiPlanningPk;
	}
	

	

}

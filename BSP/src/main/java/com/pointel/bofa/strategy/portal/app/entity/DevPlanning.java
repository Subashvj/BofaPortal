package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.pointel.bofa.strategy.portal.app.dto.DevPlanningPk;

@Entity
@DynamicUpdate
//@Table(name = "DEV_PLANNING")
public class DevPlanning {
	@Column(name="DEV_HOURS")
	private int devHours;
	
	@EmbeddedId
	private DevPlanningPk devPlanningPk;

	public int getDevHours() {
		return devHours;
	}

	public void setDevHours(int devHours) {
		this.devHours = devHours;
	}

	public DevPlanningPk getDevPlanningPk() {
		return devPlanningPk;
	}

	public void setDevPlanningPk(DevPlanningPk devPlanningPk) {
		this.devPlanningPk = devPlanningPk;
	}

}

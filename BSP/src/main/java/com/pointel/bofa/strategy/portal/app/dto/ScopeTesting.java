package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScopeTesting {
	
	@Id
	@Column(name = "IMPACT_REGRTEST")
	private int impactRegrtest;
	
	@Column(name = "IMPACT_SIT")
	private int impactSit;
	
	@Column(name = "IMPACT_FUNCTEST")
	private int impactFunctest;
	
	@Column(name = "IMPACT_PIVTEST")
	private int impactPivtest;

	public int getImpactRegrtest() {
		return impactRegrtest;
	}

	public void setImpactRegrtest(int impactRegrtest) {
		this.impactRegrtest = impactRegrtest;
	}

	public int getImpactSit() {
		return impactSit;
	}

	public void setImpactSit(int impactSit) {
		this.impactSit = impactSit;
	}

	public int getImpactFunctest() {
		return impactFunctest;
	}

	public void setImpactFunctest(int impactFunctest) {
		this.impactFunctest = impactFunctest;
	}

	public int getImpactPivtest() {
		return impactPivtest;
	}

	public void setImpactPivtest(int impactPivtest) {
		this.impactPivtest = impactPivtest;
	}
	
	
	
}

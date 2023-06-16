package com.pointel.bofa.strategy.portal.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Embeddable
public class CtiPlanningPk implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Column(name = "STRAT_ID")
	private int stratId;
	@Column(name = "CTI_MONTH")
	private int ctiMonth;
	@Column(name = "CTI_YEAR")
	private int ctiYear;
	@Column(name = "ESTIMATE_GRP")
	private int estimateGrp;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getCtiMonth() {
		return ctiMonth;
	}
	public void setCtiMonth(int ctiMonth) {
		this.ctiMonth = ctiMonth;
	}
	
	public int getEstimateGrp() {
		return estimateGrp;
	}
	public void setEstimateGrp(int estimateGrp) {
		this.estimateGrp = estimateGrp;
	}
	
	
	public int getCtiYear() {
		return ctiYear;
	}
	public void setCtiYear(int ctiYear) {
		this.ctiYear = ctiYear;
	}
	@Override
	public String toString() {
		return "CtiPlanningPk [stratId=" + stratId + ", ctiMonth=" + ctiMonth + ", ctiYear=" + ctiYear
				+ ", estimateGrp=" + estimateGrp + "]";
	}
	
	
}

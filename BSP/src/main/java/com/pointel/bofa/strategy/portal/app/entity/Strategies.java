package com.pointel.bofa.strategy.portal.app.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Strategies {
	@Id
	@GeneratedValue( generator = "STRATEGIES_STRAT_ID_SEQ",   strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "STRATEGIES_STRAT_ID_SEQ", sequenceName = "STRATEGIES_STRAT_ID_SEQ", allocationSize = 1)
	private int stratId;
	private String stratName;
	private String stratRequestor;
	private String stratRequestorDept;
	private String stratReqBusArea;
	private String stratObjectives;
	private String stratBusJust;
	private String stratBenefit;
	private String stratAddedBy;
	private int stratStatusId;
	private int stratCategory;
	private String stratUpdate;
	private int strat;
	private int stratColor;
	@DateTimeFormat(pattern="YYYY-MM-DD")
    private Date stratStatusdate;
	@DateTimeFormat(pattern="YYYY-MM-DD")
    private Date startDate;
	@DateTimeFormat(pattern="YYYY-MM-DD")
    private Date targetDate;
    private int targetFirm;
    private int execview;
    private int priorityhide;
    private int application;
    private Date stratAdded;
    private int platformId;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	public String getStratRequestor() {
		return stratRequestor;
	}
	public void setStratRequestor(String stratRequestor) {
		this.stratRequestor = stratRequestor;
	}
	public String getStratRequestorDept() {
		return stratRequestorDept;
	}
	public void setStratRequestorDept(String stratRequestorDept) {
		this.stratRequestorDept = stratRequestorDept;
	}
	public String getStratReqBusArea() {
		return stratReqBusArea;
	}
	public void setStratReqBusArea(String stratReqBusArea) {
		this.stratReqBusArea = stratReqBusArea;
	}
	public String getStratObjectives() {
		return stratObjectives;
	}
	public void setStratObjectives(String stratObjectives) {
		this.stratObjectives = stratObjectives;
	}
	public String getStratBusJust() {
		return stratBusJust;
	}
	public void setStratBusJust(String stratBusJust) {
		this.stratBusJust = stratBusJust;
	}
	public String getStratBenefit() {
		return stratBenefit;
	}
	public void setStratBenefit(String stratBenefit) {
		this.stratBenefit = stratBenefit;
	}
	public String getStratAddedBy() {
		return stratAddedBy;
	}
	public void setStratAddedBy(String stratAddedBy) {
		this.stratAddedBy = stratAddedBy;
	}
	public int getStratStatusId() {
		return stratStatusId;
	}
	public void setStratStatusId(int stratStatusId) {
		this.stratStatusId = stratStatusId;
	}
	public int getStratCategory() {
		return stratCategory;
	}
	public void setStratCategory(int stratCategory) {
		this.stratCategory = stratCategory;
	}
	public String getStratUpdate() {
		return stratUpdate;
	}
	public void setStratUpdate(String stratUpdate) {
		this.stratUpdate = stratUpdate;
	}
	public int getStrat() {
		return strat;
	}
	public void setStrat(int strat) {
		this.strat = strat;
	}
	public int getStratColor() {
		return stratColor;
	}
	public void setStratColor(int stratColor) {
		this.stratColor = stratColor;
	}
	public Date getStratStatusdate() {
		return stratStatusdate;
	}
	public void setStratStatusdate(Date stratStatusdate) {
		this.stratStatusdate = stratStatusdate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public int getTargetFirm() {
		return targetFirm;
	}
	public void setTargetFirm(int targetFirm) {
		this.targetFirm = targetFirm;
	}
	public int getExecview() {
		return execview;
	}
	public void setExecview(int execview) {
		this.execview = execview;
	}
	public int getPriorityhide() {
		return priorityhide;
	}
	public void setPriorityhide(int priorityhide) {
		this.priorityhide = priorityhide;
	}
	public int getApplication() {
		return application;
	}
	public void setApplication(int application) {
		this.application = application;
	}
	public Date getStratAdded() {
		return stratAdded;
	}
	public void setStratAdded(Date stratAdded) {
		this.stratAdded = stratAdded;
	}
	public int getPlatformId() {
		return platformId;
	}
	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}
    
    

}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtifactProgress {
	
	@Id
	@Column(name="REQUIRED_TOTAL")
	private int requiredTotal;
	
	@Column(name="OPTIONAL_TOTAL")
	private int optionalTotal;
	
	@Column(name="REQUIRED_PROGRESS")
	private int requiredProgress;
	
	@Column(name="OPTIONAL_PROGRESS")
	private int optionalProgress;
	
	@Column(name="REQUIRED_COND")
	private int requiredCond;
	
	@Column(name="OPTIONAL_COND")
	private int optionalCond;
	
	@Column(name="REQUIRED_DECL")
	private int requiredDecl;
	
	@Column(name="OPTIONAL_DECLINE")
	private int optionalDecline;

	public int getRequiredTotal() {
		return requiredTotal;
	}

	public void setRequiredTotal(int requiredTotal) {
		this.requiredTotal = requiredTotal;
	}

	public int getOptionalTotal() {
		return optionalTotal;
	}

	public void setOptionalTotal(int optionalTotal) {
		this.optionalTotal = optionalTotal;
	}

	public int getRequiredProgress() {
		return requiredProgress;
	}

	public void setRequiredProgress(int requiredProgress) {
		this.requiredProgress = requiredProgress;
	}

	public int getOptionalProgress() {
		return optionalProgress;
	}

	public void setOptionalProgress(int optionalProgress) {
		this.optionalProgress = optionalProgress;
	}

	public int getRequiredCond() {
		return requiredCond;
	}

	public void setRequiredCond(int requiredCond) {
		this.requiredCond = requiredCond;
	}

	public int getOptionalCond() {
		return optionalCond;
	}

	public void setOptionalCond(int optionalCond) {
		this.optionalCond = optionalCond;
	}

	public int getRequiredDecl() {
		return requiredDecl;
	}

	public void setRequiredDecl(int requiredDecl) {
		this.requiredDecl = requiredDecl;
	}

	public int getOptionalDecline() {
		return optionalDecline;
	}

	public void setOptionalDecline(int optionalDecline) {
		this.optionalDecline = optionalDecline;
	}
	
	
}

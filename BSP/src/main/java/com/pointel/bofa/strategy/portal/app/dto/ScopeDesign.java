package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScopeDesign {
	
	@Id
	@Column(name = "IMPACT_PROMPT")
	private int impactPrompt;
	
	@Column(name = "IMPACT_UI")
	private int impactUi;
	
	@Column(name = "IMPACT_DID")
	private int impactDid;
	
	@Column(name = "IMPACT_KVP")
	private int impactKvp;
	
	@Column(name = "IMPACT_NLU")
	private int impactNlu;
	
	@Column(name = "IMPACT_DYNMEN")
	private int impactDynmen;
	
	@Column(name = "IMPACT_DT")
	private int impactDt;
	
	@Column(name = "IMPACT_DB")
	private int impactDb;
	
	@Column(name = "IMPACT_GRAMMAR")
	private int impactGrammar;
	
	@Column(name = "IMPACT_CTI")
	private int impactCti;
	
	@Column(name = "IMPACT_CODEONLY")
	private int impactCodeonly;

	public int getImpactPrompt() {
		return impactPrompt;
	}

	public void setImpactPrompt(int impactPrompt) {
		this.impactPrompt = impactPrompt;
	}

	public int getImpactUi() {
		return impactUi;
	}

	public void setImpactUi(int impactUi) {
		this.impactUi = impactUi;
	}

	public int getImpactDid() {
		return impactDid;
	}

	public void setImpactDid(int impactDid) {
		this.impactDid = impactDid;
	}

	public int getImpactKvp() {
		return impactKvp;
	}

	public void setImpactKvp(int impactKvp) {
		this.impactKvp = impactKvp;
	}

	public int getImpactNlu() {
		return impactNlu;
	}

	public void setImpactNlu(int impactNlu) {
		this.impactNlu = impactNlu;
	}

	public int getImpactDynmen() {
		return impactDynmen;
	}

	public void setImpactDynmen(int impactDynmen) {
		this.impactDynmen = impactDynmen;
	}

	public int getImpactDt() {
		return impactDt;
	}

	public void setImpactDt(int impactDt) {
		this.impactDt = impactDt;
	}

	public int getImpactDb() {
		return impactDb;
	}

	public void setImpactDb(int impactDb) {
		this.impactDb = impactDb;
	}

	public int getImpactGrammar() {
		return impactGrammar;
	}

	public void setImpactGrammar(int impactGrammar) {
		this.impactGrammar = impactGrammar;
	}

	public int getImpactCti() {
		return impactCti;
	}

	public void setImpactCti(int impactCti) {
		this.impactCti = impactCti;
	}

	public int getImpactCodeonly() {
		return impactCodeonly;
	}

	public void setImpactCodeonly(int impactCodeonly) {
		this.impactCodeonly = impactCodeonly;
	}
}

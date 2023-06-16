package com.pointel.bofa.strategy.portal.app.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
@Entity
@DynamicUpdate
public class Strategies2 {
	@Id
    private int stratId;
	private int pm;
	private String desApproach;
	private String qaScope;
	private String qaApproach;
	private Date fullDeploy;
	private int card;
	private int vgs;
	private int bl;
	private String desScope;
	private int ivrdesign;
	private int callroute;
	private int qa;
	private int his;
	private int ins;
	private int baisi;
	private int mer;
	private int impactPrompt;
	private int impactUi;
	private int impactDynmen;
	private int impactDt;
	private int impactDb;
	private int impactGrammar;
	private int impactRegrtest;
	private int impactSit;
	private int impactFunctest;
	private int impactPivtest;
	private int impactChampchall;
	private int impactDid;
	private int impactKvp;
	private int impactCti;
	private int impactNlu;
	private int autoSurvey;
	private int selfaudit;
	private int us;
	private int usergroup;
	private int ivrSolutionId;
	private int pprt;
	private int ucra;
	private int stratRequestorDeptId;
	private int cast;
	private int castReq;
	private int impactCodeonly;

	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
	}
	public String getDesApproach() {
		return desApproach;
	}
	public void setDesApproach(String desApproach) {
		this.desApproach = desApproach;
	}
	public String getQaScope() {
		return qaScope;
	}
	public void setQaScope(String qaScope) {
		this.qaScope = qaScope;
	}
	public String getQaApproach() {
		return qaApproach;
	}
	public void setQaApproach(String qaApproach) {
		this.qaApproach = qaApproach;
	}
	public Date getFullDeploy() {
		return fullDeploy;
	}
	public void setFullDeploy(Date fullDeploy) {
		this.fullDeploy = fullDeploy;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public int getVgs() {
		return vgs;
	}
	public void setVgs(int vgs) {
		this.vgs = vgs;
	}
	public int getBl() {
		return bl;
	}
	public void setBl(int bl) {
		this.bl = bl;
	}
	public String getDesScope() {
		return desScope;
	}
	public void setDesScope(String desScope) {
		this.desScope = desScope;
	}
	public int getIvrdesign() {
		return ivrdesign;
	}
	public void setIvrdesign(int ivrdesign) {
		this.ivrdesign = ivrdesign;
	}
	public int getCallroute() {
		return callroute;
	}
	public void setCallroute(int callroute) {
		this.callroute = callroute;
	}
	public int getQa() {
		return qa;
	}
	public void setQa(int qa) {
		this.qa = qa;
	}
	public int getHis() {
		return his;
	}
	public void setHis(int his) {
		this.his = his;
	}
	public int getIns() {
		return ins;
	}
	public void setIns(int ins) {
		this.ins = ins;
	}
	public int getBaisi() {
		return baisi;
	}
	public void setBaisi(int baisi) {
		this.baisi = baisi;
	}
	public int getMer() {
		return mer;
	}
	public void setMer(int mer) {
		this.mer = mer;
	}
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
	public int getImpactChampchall() {
		return impactChampchall;
	}
	public void setImpactChampchall(int impactChampchall) {
		this.impactChampchall = impactChampchall;
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
	public int getImpactCti() {
		return impactCti;
	}
	public void setImpactCti(int impactCti) {
		this.impactCti = impactCti;
	}
	public int getImpactNlu() {
		return impactNlu;
	}
	public void setImpactNlu(int impactNlu) {
		this.impactNlu = impactNlu;
	}
	public int getAutoSurvey() {
		return autoSurvey;
	}
	public void setAutoSurvey(int autoSurvey) {
		this.autoSurvey = autoSurvey;
	}
	public int getSelfaudit() {
		return selfaudit;
	}
	public void setSelfaudit(int selfaudit) {
		this.selfaudit = selfaudit;
	}
	public int getUs() {
		return us;
	}
	public void setUs(int us) {
		this.us = us;
	}
	public int getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(int usergroup) {
		this.usergroup = usergroup;
	}
	public int getIvrSolutionId() {
		return ivrSolutionId;
	}
	public void setIvrSolutionId(int ivrSolutionId) {
		this.ivrSolutionId = ivrSolutionId;
	}
	public int getPprt() {
		return pprt;
	}
	public void setPprt(int pprt) {
		this.pprt = pprt;
	}
	public int getUcra() {
		return ucra;
	}
	public void setUcra(int ucra) {
		this.ucra = ucra;
	}
	public int getStratRequestorDeptId() {
		return stratRequestorDeptId;
	}
	public void setStratRequestorDeptId(int stratRequestorDeptId) {
		this.stratRequestorDeptId = stratRequestorDeptId;
	}
	public int getCast() {
		return cast;
	}
	public void setCast(int cast) {
		this.cast = cast;
	}
	public int getCastReq() {
		return castReq;
	}
	public void setCastReq(int castReq) {
		this.castReq = castReq;
	}
	public int getImpactCodeonly() {
		return impactCodeonly;
	}
	public void setImpactCodeonly(int impactCodeonly) {
		this.impactCodeonly = impactCodeonly;
	}

}


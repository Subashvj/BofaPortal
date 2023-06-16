package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Strategies1 {

	@Id
	private int stratId;
	private String sharepointLink;
	private String projuid;
	private int priorityRequest;
	private int resourcePlan;
	private String pmChangeNotes;
	@Column(name="TEST_NOTES")
	private String testNotes;
	private String parentClarity;
	private String childClarity;
	private String nexusId;
	private String projReg;
	private String risks;
	private int groupId;
	private String issues;
	private String gotogreen;
	private String gppid;
	private int fundingSource;
	private int fundingType;
	private String qcNum;
	private String cmStatus;
	private Date kickoffDate;
	private String petNum;
	private Date swagReq;
	private Date swagDue;
	private Date swagComplete;
	private Date gcApproveDate;
	private int lobApproval;
	private Date sizingDue;
	@Column(name="PIR_85_DUE")
	private Date pir85Due;
	@Column(name="PIR_100_DUE")
	private Date pir100Due;
	private String swagNote;
	private String cmNum;
	private int lobId;
	private String execStatus;
	private int funded;
	private int fundedAmount;
	private String analystSummary;
	private Date swagExp;
	private String swagLabor;
	private String swagCapital;
	private String swagVendorImpact;
	private String swagRecurring;
	private String swagDelivery;
	private String swagDeliveryType;
	private String swagProjDuration;
	private String swagDetailedresponse;
	private String swagMod;
	private int legacyReqnum;
	private int pilotRequired;
	private String fundingNum;
	private String intakeInscope;
	private String intakeAddlscope;
	private String intakeOutofscope;
	private String intakeTestEnv;
	private String intakeNonstndrdtest;
	private int issueCount;
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public String getSharepointLink() {
		return sharepointLink;
	}
	public void setSharepointLink(String sharepointLink) {
		this.sharepointLink = sharepointLink;
	}
	public String getProjuid() {
		return projuid;
	}
	public void setProjuid(String projuid) {
		this.projuid = projuid;
	}
	public int getPriorityRequest() {
		return priorityRequest;
	}
	public void setPriorityRequest(int priorityRequest) {
		this.priorityRequest = priorityRequest;
	}
	public int getResourcePlan() {
		return resourcePlan;
	}
	public void setResourcePlan(int resourcePlan) {
		this.resourcePlan = resourcePlan;
	}
	public String getPmChangeNotes() {
		return pmChangeNotes;
	}
	public void setPmChangeNotes(String pmChangeNotes) {
		this.pmChangeNotes = pmChangeNotes;
	}
	public String getTestNotes() {
		return testNotes;
	}
	public void setTestNotes(String testNotes) {
		this.testNotes = testNotes;
	}
	public String getParentClarity() {
		return parentClarity;
	}
	public void setParentClarity(String parentClarity) {
		this.parentClarity = parentClarity;
	}
	public String getChildClarity() {
		return childClarity;
	}
	public void setChildClarity(String childClarity) {
		this.childClarity = childClarity;
	}
	public String getNexusId() {
		return nexusId;
	}
	public void setNexusId(String nexusId) {
		this.nexusId = nexusId;
	}
	public String getProjReg() {
		return projReg;
	}
	public void setProjReg(String projReg) {
		this.projReg = projReg;
	}
	public String getRisks() {
		return risks;
	}
	public void setRisks(String risks) {
		this.risks = risks;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	public String getGotogreen() {
		return gotogreen;
	}
	public void setGotogreen(String gotogreen) {
		this.gotogreen = gotogreen;
	}
	public String getGppid() {
		return gppid;
	}
	public void setGppid(String gppid) {
		this.gppid = gppid;
	}
	public int getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(int fundingSource) {
		this.fundingSource = fundingSource;
	}
	public int getFundingType() {
		return fundingType;
	}
	public void setFundingType(int fundingType) {
		this.fundingType = fundingType;
	}
	public String getQcNum() {
		return qcNum;
	}
	public void setQcNum(String qcNum) {
		this.qcNum = qcNum;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getCmStatus() {
		return cmStatus;
	}
	public void setCmStatus(String cmStatus) {
		this.cmStatus = cmStatus;
	}
	public Date getKickoffDate() {
		return kickoffDate;
	}
	public void setKickoffDate(Date kickoffDate) {
		this.kickoffDate = kickoffDate;
	}
	public String getPetNum() {
		return petNum;
	}
	public void setPetNum(String petNum) {
		this.petNum = petNum;
	}
	public Date getSwagReq() {
		return swagReq;
	}
	public void setSwagReq(Date swagReq) {
		this.swagReq = swagReq;
	}
	public Date getSwagDue() {
		return swagDue;
	}
	public void setSwagDue(Date swagDue) {
		this.swagDue = swagDue;
	}
	public Date getSwagComplete() {
		return swagComplete;
	}
	public void setSwagComplete(Date swagComplete) {
		this.swagComplete = swagComplete;
	}
	public Date getGcApproveDate() {
		return gcApproveDate;
	}
	public void setGcApproveDate(Date gcApproveDate) {
		this.gcApproveDate = gcApproveDate;
	}
	public int getLobApproval() {
		return lobApproval;
	}
	public void setLobApproval(int lobApproval) {
		this.lobApproval = lobApproval;
	}
	public Date getSizingDue() {
		return sizingDue;
	}
	public void setSizingDue(Date sizingDue) {
		this.sizingDue = sizingDue;
	}
	
	public Date getPir85Due() {
		return pir85Due;
	}
	public void setPir85Due(Date pir85Due) {
		this.pir85Due = pir85Due;
	}
	public Date getPir100Due() {
		return pir100Due;
	}
	public void setPir100Due(Date pir100Due) {
		this.pir100Due = pir100Due;
	}
	public String getSwagNote() {
		return swagNote;
	}
	public void setSwagNote(String swagNote) {
		this.swagNote = swagNote;
	}
	public String getCmNum() {
		return cmNum;
	}
	public void setCmNum(String cmNum) {
		this.cmNum = cmNum;
	}
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public String getExecStatus() {
		return execStatus;
	}
	public void setExecStatus(String execStatus) {
		this.execStatus = execStatus;
	}
	public int getFunded() {
		return funded;
	}
	public void setFunded(int funded) {
		this.funded = funded;
	}
	public int getFundedAmount() {
		return fundedAmount;
	}
	public void setFundedAmount(int fundedAmount) {
		this.fundedAmount = fundedAmount;
	}
	public String getAnalystSummary() {
		return analystSummary;
	}
	public void setAnalystSummary(String analystSummary) {
		this.analystSummary = analystSummary;
	}
	public Date getSwagExp() {
		return swagExp;
	}
	public void setSwagExp(Date swagExp) {
		this.swagExp = swagExp;
	}
	public String getSwagLabor() {
		return swagLabor;
	}
	public void setSwagLabor(String swagLabor) {
		this.swagLabor = swagLabor;
	}
	public String getSwagCapital() {
		return swagCapital;
	}
	public void setSwagCapital(String swagCapital) {
		this.swagCapital = swagCapital;
	}
	public String getSwagVendorImpact() {
		return swagVendorImpact;
	}
	public void setSwagVendorImpact(String swagVendorImpact) {
		this.swagVendorImpact = swagVendorImpact;
	}
	public String getSwagRecurring() {
		return swagRecurring;
	}
	public void setSwagRecurring(String swagRecurring) {
		this.swagRecurring = swagRecurring;
	}
	public String getSwagDelivery() {
		return swagDelivery;
	}
	public void setSwagDelivery(String swagDelivery) {
		this.swagDelivery = swagDelivery;
	}
	public String getSwagDeliveryType() {
		return swagDeliveryType;
	}
	public void setSwagDeliveryType(String swagDeliveryType) {
		this.swagDeliveryType = swagDeliveryType;
	}
	public String getSwagProjDuration() {
		return swagProjDuration;
	}
	public void setSwagProjDuration(String swagProjDuration) {
		this.swagProjDuration = swagProjDuration;
	}
	public String getSwagDetailedresponse() {
		return swagDetailedresponse;
	}
	public void setSwagDetailedresponse(String swagDetailedresponse) {
		this.swagDetailedresponse = swagDetailedresponse;
	}
	public String getSwagMod() {
		return swagMod;
	}
	public void setSwagMod(String swagMod) {
		this.swagMod = swagMod;
	}
	public int getLegacyReqnum() {
		return legacyReqnum;
	}
	public void setLegacyReqnum(int legacyReqnum) {
		this.legacyReqnum = legacyReqnum;
	}
	public int getPilotRequired() {
		return pilotRequired;
	}
	public void setPilotRequired(int pilotRequired) {
		this.pilotRequired = pilotRequired;
	}
	public String getFundingNum() {
		return fundingNum;
	}
	public void setFundingNum(String fundingNum) {
		this.fundingNum = fundingNum;
	}
	public String getIntakeInscope() {
		return intakeInscope;
	}
	public void setIntakeInscope(String intakeInscope) {
		this.intakeInscope = intakeInscope;
	}
	public String getIntakeAddlscope() {
		return intakeAddlscope;
	}
	public void setIntakeAddlscope(String intakeAddlscope) {
		this.intakeAddlscope = intakeAddlscope;
	}
	public String getIntakeOutofscope() {
		return intakeOutofscope;
	}
	public void setIntakeOutofscope(String intakeOutofscope) {
		this.intakeOutofscope = intakeOutofscope;
	}
	public String getIntakeTestEnv() {
		return intakeTestEnv;
	}
	public void setIntakeTestEnv(String intakeTestEnv) {
		this.intakeTestEnv = intakeTestEnv;
	}
	public String getIntakeNonstndrdtest() {
		return intakeNonstndrdtest;
	}
	public void setIntakeNonstndrdtest(String intakeNonstndrdtest) {
		this.intakeNonstndrdtest = intakeNonstndrdtest;
	}
	public int getIssueCount() {
		return issueCount;
	}
	public void setIssueCount(int issueCount) {
		this.issueCount = issueCount;
	}
	@Override
	public String toString() {
		return "Strategies1 [stratId=" + stratId + ", sharepointLink=" + sharepointLink + ", projuid=" + projuid
				+ ", priorityRequest=" + priorityRequest + ", resourcePlan=" + resourcePlan + ", pmChangeNotes="
				+ pmChangeNotes + ", testNotes=" + testNotes + ", parentClarity=" + parentClarity + ", childClarity="
				+ childClarity + ", nexusId=" + nexusId + ", projReg=" + projReg + ", risks=" + risks + ", groupId="
				+ groupId + ", issues=" + issues + ", gotogreen=" + gotogreen + ", gppid=" + gppid + ", fundingSource="
				+ fundingSource + ", fundingType=" + fundingType + ", qcNum=" + qcNum + ", cmStatus=" + cmStatus
				+ ", kickoffDate=" + kickoffDate + ", petNum=" + petNum + ", swagReq=" + swagReq + ", swagDue="
				+ swagDue + ", swagComplete=" + swagComplete + ", gcApproveDate=" + gcApproveDate + ", lobApproval="
				+ lobApproval + ", sizingDue=" + sizingDue + ", pir85Due=" + pir85Due + ", pir100Due=" + pir100Due
				+ ", swagNote=" + swagNote + ", cmNum=" + cmNum + ", lobId=" + lobId + ", execStatus=" + execStatus
				+ ", funded=" + funded + ", fundedAmount=" + fundedAmount + ", analystSummary=" + analystSummary
				+ ", swagExp=" + swagExp + ", swagLabor=" + swagLabor + ", swagCapital=" + swagCapital
				+ ", swagVendorImpact=" + swagVendorImpact + ", swagRecurring=" + swagRecurring + ", swagDelivery="
				+ swagDelivery + ", swagDeliveryType=" + swagDeliveryType + ", swagProjDuration=" + swagProjDuration
				+ ", swagDetailedresponse=" + swagDetailedresponse + ", swagMod=" + swagMod + ", legacyReqnum="
				+ legacyReqnum + ", pilotRequired=" + pilotRequired + ", fundingNum=" + fundingNum + ", intakeInscope="
				+ intakeInscope + ", intakeAddlscope=" + intakeAddlscope + ", intakeOutofscope=" + intakeOutofscope
				+ ", intakeTestEnv=" + intakeTestEnv + ", intakeNonstndrdtest=" + intakeNonstndrdtest + ", issueCount="
				+ issueCount + "]";
	}
}

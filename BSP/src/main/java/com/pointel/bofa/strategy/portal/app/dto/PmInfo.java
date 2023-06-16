package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PmInfo {
	
	@Id
	private int stratId;
	private String stratName;
	private String sharepointLink;
	private String sponsorname;
	private String projuid;
	private String gppid;
	private int priorityRequest;
	private String fundDesc;
	private int resourcePlan;
	private String qcNum;
	private String pmChangeNotes;
	private String testNotes;
	private String groupsList;
	private int execview;
	private String fundingSrcDesc;
	private String fundingNum;
	private String parentClarity;
	private String childClarity;
	private String nexusId;
	private Date kickoffDate;
	private String projReg;
	private String petNum;
	private String risks;
	private String issues;
	private String gotogreen;
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
	public String getSharepointLink() {
		return sharepointLink;
	}
	public void setSharepointLink(String sharepointLink) {
		this.sharepointLink = sharepointLink;
	}
	public String getSponsorname() {
		return sponsorname;
	}
	public void setSponsorname(String sponsorname) {
		this.sponsorname = sponsorname;
	}
	public String getProjuid() {
		return projuid;
	}
	public void setProjuid(String projuid) {
		this.projuid = projuid;
	}
	public String getGppid() {
		return gppid;
	}
	public void setGppid(String gppid) {
		this.gppid = gppid;
	}
	public int getPriorityRequest() {
		return priorityRequest;
	}
	public void setPriorityRequest(int priorityRequest) {
		this.priorityRequest = priorityRequest;
	}
	public String getFundDesc() {
		return fundDesc;
	}
	public void setFundDesc(String fundDesc) {
		this.fundDesc = fundDesc;
	}
	public int getResourcePlan() {
		return resourcePlan;
	}
	public void setResourcePlan(int resourcePlan) {
		this.resourcePlan = resourcePlan;
	}
	public String getQcNum() {
		return qcNum;
	}
	public void setQcNum(String qcNum) {
		this.qcNum = qcNum;
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
	public String getGroupsList() {
		return groupsList;
	}
	public void setGroupsList(String groupsList) {
		this.groupsList = groupsList;
	}
	public int getExecview() {
		return execview;
	}
	public void setExecview(int execview) {
		this.execview = execview;
	}
	public String getFundingSrcDesc() {
		return fundingSrcDesc;
	}
	public void setFundingSrcDesc(String fundingSrcDesc) {
		this.fundingSrcDesc = fundingSrcDesc;
	}
	public String getFundingNum() {
		return fundingNum;
	}
	public void setFundingNum(String fundingNum) {
		this.fundingNum = fundingNum;
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
	public Date getKickoffDate() {
		return kickoffDate;
	}
	public void setKickoffDate(Date kickoffDate) {
		this.kickoffDate = kickoffDate;
	}
	public String getProjReg() {
		return projReg;
	}
	public void setProjReg(String projReg) {
		this.projReg = projReg;
	}
	public String getPetNum() {
		return petNum;
	}
	public void setPetNum(String petNum) {
		this.petNum = petNum;
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
	
	
}

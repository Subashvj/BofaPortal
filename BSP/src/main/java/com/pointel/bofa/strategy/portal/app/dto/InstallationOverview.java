package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstallationOverview {
	
	@Id
	@Column(name="INSTALL_ID")
	private int installId;
	
	@Column(name="INSTALL_DATE")
	private Date installDate;
	
	@Column(name="INSTALL_END")
	private Date installEnd;
	
	@Column(name="INSTALL_TITLE")
	private String installTitle;
	
	@Column(name="INSTALL_OWNER")
	private String installOwner;
	
	@Column(name="STATUS_DESC")
	private String statusDesc;
	
	@Column(name="OWNER")
	private String owner;
	
	@Column(name="INSTALL_STATUS_ID")
	private int installStatusId;
	
	@Column(name="INSTALL_TYPE")
	private int installType;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="INSTALL_LASTSTATUS")
	private Date installLaststatus;
	
	@Column(name="DISPLAYNAME")
	private String displayname;
	
	@Column(name="INSTALL_STATUS_DESC")
	private String installStatusDesc;
	
	@Column(name="INSTALL_TYPE_DESC")
	private String installTypeDesc;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@Column(name="INSTALL_OWNERGROUP")
	private int installOwnergroup;
	
	@Column(name="TOTALLINKED")
	private int totallinked;
	
	@Column(name="INST_ENVIRONMENT")
	private String instEnvironment;
	
	@Column(name="INST_ENV_ID")
	private int instEnvId;
	
	@Column(name="CAB_NUM")
	private String cabNum;
	
	@Column(name="CAB_STATUS")
	private int cabStatus;
	
	@Column(name="CAB_APPROVAL_DATE")
	private Date cabApprovalDate;
	
	@Column(name="CAB_STATUS_DESCRIPTION")
	private String cabStatusDescription;
	
	@Column(name="VACOB_BUNDLE")
	private String vacobBundle;
	
	@Column(name="BUNDLE_NAME")
	private String bundleName;
	public int getInstallId() {
		return installId;
	}
	public void setInstallId(int installId) {
		this.installId = installId;
	}
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	public Date getInstallEnd() {
		return installEnd;
	}
	public void setInstallEnd(Date installEnd) {
		this.installEnd = installEnd;
	}
	public String getInstallTitle() {
		return installTitle;
	}
	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}
	public String getInstallOwner() {
		return installOwner;
	}
	public void setInstallOwner(String installOwner) {
		this.installOwner = installOwner;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getInstallStatusId() {
		return installStatusId;
	}
	public void setInstallStatusId(int installStatusId) {
		this.installStatusId = installStatusId;
	}
	public int getInstallType() {
		return installType;
	}
	public void setInstallType(int installType) {
		this.installType = installType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getInstallLaststatus() {
		return installLaststatus;
	}
	public void setInstallLaststatus(Date installLaststatus) {
		this.installLaststatus = installLaststatus;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getInstallStatusDesc() {
		return installStatusDesc;
	}
	public void setInstallStatusDesc(String installStatusDesc) {
		this.installStatusDesc = installStatusDesc;
	}
	public String getInstallTypeDesc() {
		return installTypeDesc;
	}
	public void setInstallTypeDesc(String installTypeDesc) {
		this.installTypeDesc = installTypeDesc;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getInstallOwnergroup() {
		return installOwnergroup;
	}
	public void setInstallOwnergroup(int installOwnergroup) {
		this.installOwnergroup = installOwnergroup;
	}
	public int getTotallinked() {
		return totallinked;
	}
	public void setTotallinked(int totallinked) {
		this.totallinked = totallinked;
	}
	public String getInstEnvironment() {
		return instEnvironment;
	}
	public void setInstEnvironment(String instEnvironment) {
		this.instEnvironment = instEnvironment;
	}
	public int getInstEnvId() {
		return instEnvId;
	}
	public void setInstEnvId(int instEnvId) {
		this.instEnvId = instEnvId;
	}
	public String getCabNum() {
		return cabNum;
	}
	public void setCabNum(String cabNum) {
		this.cabNum = cabNum;
	}
	public int getCabStatus() {
		return cabStatus;
	}
	public void setCabStatus(int cabStatus) {
		this.cabStatus = cabStatus;
	}
	public Date getCabApprovalDate() {
		return cabApprovalDate;
	}
	public void setCabApprovalDate(Date cabApprovalDate) {
		this.cabApprovalDate = cabApprovalDate;
	}
	public String getCabStatusDescription() {
		return cabStatusDescription;
	}
	public void setCabStatusDescription(String cabStatusDescription) {
		this.cabStatusDescription = cabStatusDescription;
	}
	public String getVacobBundle() {
		return vacobBundle;
	}
	public void setVacobBundle(String vacobBundle) {
		this.vacobBundle = vacobBundle;
	}
	public String getBundleName() {
		return bundleName;
	}
	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}
	
	
}

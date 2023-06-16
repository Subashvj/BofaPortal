package com.pointel.bofa.strategy.portal.app.entity;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="INSTALLS")
public class AddInstallation {

	@Id
    @SequenceGenerator(name="seq",sequenceName="INSTALLS_INSTALL_ID_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") 
	private int installId;
	
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date installDate;
	
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	@Column(name="INSTALL_END")
	private Date installEnd;
	private String installTitle;
	private int installStatusId;
	private int installType;
	private String installOwner;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date createDate;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date installLaststatus;
	private int installOwnergroup;
	private int instEnvId;
	private String cabNum;
	private int cabStatus;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date cabApprovalDate;
	private String desApprv;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date desApprvDate;
	private String qmApprv;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date qmApprvDate;
	private String pivApprv;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date pivApprvDate;
	private String ttApprv;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date ttApprcDate;
	private String bundleName;
	private String vacobBundle;
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
	public String getInstallOwner() {
		return installOwner;
	}
	public void setInstallOwner(String installOwner) {
		this.installOwner = installOwner;
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
	public int getInstallOwnergroup() {
		return installOwnergroup;
	}
	public void setInstallOwnergroup(int installOwnergroup) {
		this.installOwnergroup = installOwnergroup;
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
	public String getDesApprv() {
		return desApprv;
	}
	public void setDesApprv(String desApprv) {
		this.desApprv = desApprv;
	}
	public Date getDesApprvDate() {
		return desApprvDate;
	}
	public void setDesApprvDate(Date desApprvDate) {
		this.desApprvDate = desApprvDate;
	}
	public String getQmApprv() {
		return qmApprv;
	}
	public void setQmApprv(String qmApprv) {
		this.qmApprv = qmApprv;
	}
	public Date getQmApprvDate() {
		return qmApprvDate;
	}
	public void setQmApprvDate(Date qmApprvDate) {
		this.qmApprvDate = qmApprvDate;
	}
	public String getPivApprv() {
		return pivApprv;
	}
	public void setPivApprv(String pivApprv) {
		this.pivApprv = pivApprv;
	}
	public Date getPivApprvDate() {
		return pivApprvDate;
	}
	public void setPivApprvDate(Date pivApprvDate) {
		this.pivApprvDate = pivApprvDate;
	}
	public String getTtApprv() {
		return ttApprv;
	}
	public void setTtApprv(String ttApprv) {
		this.ttApprv = ttApprv;
	}
	public Date getTtApprcDate() {
		return ttApprcDate;
	}
	public void setTtApprcDate(Date ttApprcDate) {
		this.ttApprcDate = ttApprcDate;
	}
	public String getBundleName() {
		return bundleName;
	}
	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}
	public String getVacobBundle() {
		return vacobBundle;
	}
	public void setVacobBundle(String vacobBundle) {
		this.vacobBundle = vacobBundle;
	}
	
}

package com.pointel.bofa.strategy.portal.app.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="INSTALL_HISTORY")
public class AddComment {
	@Id
    @SequenceGenerator(name="seqInst",sequenceName="INSTALL_HISTORY_HIST_ID_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqInst") 
	private int histId;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date fdate;
	private String userid;
	private int newStatusId;
	private String comment_;
	private int installId;
	private int public_;

	public int getHistId() {
		return histId;
	}
	public void setHistId(int histId) {
		this.histId = histId;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNewStatusId() {
		return newStatusId;
	}
	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}
	public String getComment_() {
		return comment_;
	}
	public void setComment_(String comment_) {
		this.comment_ = comment_;
	}
	public int getInstallId() {
		return installId;
	}
	public void setInstallId(int installId) {
		this.installId = installId;
	}
	public int getPublic_() {
		return public_;
	}
	public void setPublic_(int public_) {
		this.public_ = public_;
	}
	//@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	//@Temporal(TemporalType.TIMESTAMP)
}

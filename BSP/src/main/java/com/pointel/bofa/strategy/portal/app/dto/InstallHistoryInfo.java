package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class InstallHistoryInfo {
	@Id
	private int histId;
	private Date fdate;
	private String fydate;
	@Column(name="COMMENT_")
	private String comment;
	@Column(name="PUBLIC_")
	private int public_;
	private int newStatusId;
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
	public String getFydate() {
		return fydate;
	}
	public void setFydate(String fydate) {
		this.fydate = fydate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPublic_() {
		return public_;
	}
	public void setPublic_(int public_) {
		this.public_ = public_;
	}
	public int getNewStatusId() {
		return newStatusId;
	}
	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}
	
	

}

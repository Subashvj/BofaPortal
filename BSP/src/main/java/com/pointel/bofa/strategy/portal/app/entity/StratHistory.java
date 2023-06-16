package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STRAT_HISTORY")
public class StratHistory {	
	@Id
    @SequenceGenerator(name="stratHistorySequence",sequenceName="STRAT_HISTORY_HIST_ID_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stratHistorySequence")
	private int histId;
	@Column(name="COMMENT_")
	private String comment_;
	private int newStatusId;
	private int analystInclude;
	private int stratId;
	private Date fdate;
	private String userid;
	@Column(name="PUBLIC_")
	private int public_;
	public int getPublic_() {
		return public_;
	}
	public void setPublic_(int public_) {
		this.public_ = public_;
	}
	public int getHistId() {
		return histId;
	}
	public void setHistId(int histId) {
		this.histId = histId;
	}
	public String getComment_() {
		return comment_;
	}
	public void setComment_(String comment_) {
		this.comment_ = comment_;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
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
	public int getAnalystInclude() {
		return analystInclude;
	}
	public void setAnalystInclude(int analystInclude) {
		this.analystInclude = analystInclude;
	}
	}
	
	
	
	
	


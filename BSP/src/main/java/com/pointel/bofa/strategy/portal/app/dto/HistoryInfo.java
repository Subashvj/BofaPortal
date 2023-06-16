package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class HistoryInfo {
	@Id
	private int histId;
	private Date fdate;
	private Date consumerFdate;
	private String ffdate;
	private String fydate;
	private String displayname;
	private int newStatusId;
	
	@Column(name = "comment_")
	private String comment;
	private String consumerComment;
	private int analystInclude;
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

	public Date getConsumerFdate() {
		return consumerFdate;
	}
	public void setConsumerFdate(Date consumerFdate) {
		this.consumerFdate = consumerFdate;
	}

	public String getFfdate() {
		return ffdate;
	}
	public void setFfdate(String ffdate) {
		this.ffdate = ffdate;
	}
	public String getFydate() {
		return fydate;
	}
	public void setFydate(String fydate) {
		this.fydate = fydate;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public int getNewStatusId() {
		return newStatusId;
	}
	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getConsumerComment() {
		return consumerComment;
	}
	public void setConsumerComment(String consumerComment) {
		this.consumerComment = consumerComment;
	}
	public int getAnalystInclude() {
		return analystInclude;
	}
	public void setAnalystInclude(int analystInclude) {
		this.analystInclude = analystInclude;
	}
	
	
	
	

}

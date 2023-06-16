package com.pointel.bofa.strategy.portal.app.dto;
import java.util.Date;


public class AddCommentRequest {
	
	private int histId;
	
	public int getHistId() {
		return histId;
	}


	public void setHistId(int histId) {
		this.histId = histId;
	}


	private int stratId;
	
	
	private String comment;
	
	
	private Date fDate;
	
	
	private String userId;
	
	
	
	private int newStatusId;


	public int getStratId() {
		return stratId;
	}


	public void setStratId(int stratId) {
		this.stratId = stratId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Date getfDate() {
		return fDate;
	}


	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getNewStatusId() {
		return newStatusId;
	}


	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}
	

}

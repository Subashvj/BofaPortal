package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserCalInfo {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "STARTDATE")
	private Date startDate;
	
	@Column(name = "OUTLEN")
	private int outLen;
	
	@Column(name = "USERID")
	private String userId;
	
	@Column(name = "END")
	private String end;
	
	@Column(name = "EDIT")
	private String edit;
	
	@Column(name = "OUTTYPE")
	private int outType;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "MYUSER")
	private String myUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getOutLen() {
		return outLen;
	}

	public void setOutLen(int outLen) {
		this.outLen = outLen;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public int getOutType() {
		return outType;
	}

	public void setOutType(int outType) {
		this.outType = outType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMyUser() {
		return myUser;
	}

	public void setMyUser(String myUser) {
		this.myUser = myUser;
	}

}

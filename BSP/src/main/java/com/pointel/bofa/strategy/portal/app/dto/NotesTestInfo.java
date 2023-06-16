package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotesTestInfo {
	
	@Id
	@Column(name="STRAT_ID")
	private int stratId;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="ADD_DATE")
	private Date addDate;
	
	@Column(name="INSTALL_TITLE")
	private String installTitle;
	
	@Column(name="DISPLAYNAME")
	private String displayname;

	public int getStratId() {
		return stratId;
	}

	public void setStratId(int stratId) {
		this.stratId = stratId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getInstallTitle() {
		return installTitle;
	}

	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	
	
}

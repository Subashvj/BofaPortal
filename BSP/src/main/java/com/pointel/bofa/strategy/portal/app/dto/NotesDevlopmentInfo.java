package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class NotesDevlopmentInfo {
	@Id
	private int stratId;
	private  String note;
	private Date addDate;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String installTitle;
	private String displayname;
	public String getInstallTitle() {
		return installTitle;
	}
	public void setInstallTitle(String installTitle) {
		this.installTitle = installTitle;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

}

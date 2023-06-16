package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class InstallFilesInfo {
	@Id
	private int fileAttId;
	private String fileDesc;
	private  String fileName;
	private String link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getFileAttId() {
		return fileAttId;
	}
	public void setFileAttId(int fileAttId) {
		this.fileAttId = fileAttId;
	}
	public String getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAddedby() {
		return addedby;
	}
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	private String addedby;
	private Date addedDate;

}

package com.pointel.bofa.strategy.portal.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ATTACHMENTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attachments {
	 
	@Id
	@GeneratedValue( generator = "ATTACHMENTS_ATTACH_ID_SEQ",   strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "ATTACHMENTS_ATTACH_ID_SEQ", sequenceName = "ATTACHMENTS_ATTACH_ID_SEQ", allocationSize = 1)
	private int fileAttId;
	
	//@Column(name = "FILE_ATT_ID")
	//@Column(name = "FILE_TYPE")
	private int attatchType;
	
	//@Column(name = "TYPE_ID")  //called ref id.
	private int typeId;
	
	//@Column(name = "FILE_DESC")
	private String fileDesc;
	
	//@Column(name = "LINK")
	private String link;
	
	//@Column(name = "FILE_VISIBLE")
	private int fileVisible;
	
	//@Column(name = "ADDED_BY")
	private String addedBy;
	
	//@Column(name = "ADDED_DATE")
	private Date addedDate;
	
	//@Column(name = "FOLDER_ID")
	private Integer folderId;
	
	//@Column(name = "FILE_NAME")
	private String fileName;

	public int getFileAttId() {
		return fileAttId;
	}

	public void setFileAttId(int fileAttId) {
		this.fileAttId = fileAttId;
	}

	public int getAttatchType() {
		return attatchType;
	}

	public void setAttatchType(int attatchType) {
		this.attatchType = attatchType;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getFileVisible() {
		return fileVisible;
	}

	public void setFileVisible(int fileVisible) {
		this.fileVisible = fileVisible;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}

package com.pointel.bofa.strategy.portal.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Files  {
	
	@Id
	@Column(name="FILE_ATT_ID")
	private int fileAttId;
	
	@Column(name="FILE_DESC")
	private String fileDesc;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="LINK")
	private String link;
	
	@Column(name="ADDEDBY")
	private String addedby;
	
	@Column(name="ADDED_DATE")
	private Date addedDate;
	
	@Column(name="LOCKED")
	private int locked;
	
	@Column(name="FOLDER_ID")
	private int folderId;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="SORT_ORDER")
	private int sortOrder;
	
	@Column(name="NON_PUBLIC")
	private int nonPublic;
	
	@Column(name="ARTIFACT_TYPE_DESC")
	private String artifactTypeDesc;
	
	@Column(name="ARTIFACT_ID")
	private int artifactId;
	
	@Column(name="DESC_")
	private String desc;
	
	@Column(name="ADDED")
	private Date added;

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

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getNonPublic() {
		return nonPublic;
	}

	public void setNonPublic(int nonPublic) {
		this.nonPublic = nonPublic;
	}

	public String getArtifactTypeDesc() {
		return artifactTypeDesc;
	}

	public void setArtifactTypeDesc(String artifactTypeDesc) {
		this.artifactTypeDesc = artifactTypeDesc;
	}

	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}
}

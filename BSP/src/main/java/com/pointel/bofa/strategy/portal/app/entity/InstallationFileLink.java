package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ATTACHMENTS")
public class InstallationFileLink {
	
	@Id
    @SequenceGenerator(name="attachmentsSeq",sequenceName="ATTACHMENTS_ATTACH_ID_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="attachmentsSeq") 
	private int fileAttId;
	private int fileType;
	private int TypeId;
	private String fileDesc;
	private String fileName;
	private String link;
	private int fileVisible;
	private String addedBy;
	@DateTimeFormat(pattern="YYYY-MM-DD hh:mm:ss")
	private Date addedDate;
	private int locked;
	private int folderId;
	private int artifactId;
	private String serverFilename;

	public int getFileAttId() {
		return fileAttId;
	}

	public void setFileAttId(int fileAttId) {
		this.fileAttId = fileAttId;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public int getTypeId() {
		return TypeId;
	}

	public void setTypeId(int typeId) {
		TypeId = typeId;
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

	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	public String getServerFilename() {
		return serverFilename;
	}

	public void setServerFilename(String serverFilename) {
		this.serverFilename = serverFilename;
	}
	 
}

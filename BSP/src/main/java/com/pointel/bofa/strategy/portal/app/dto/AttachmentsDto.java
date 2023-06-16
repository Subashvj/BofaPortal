package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AttachmentsDto {
	
//	@Id
//	@GeneratedValue( generator = "ATTACHMENTS_ATTACH_ID_SEQ",   strategy = GenerationType.AUTO )
//	@SequenceGenerator(name = "ATTACHMENTS_ATTACH_ID_SEQ", sequenceName = "ATTACHMENTS_ATTACH_ID_SEQ", allocationSize = 1)
//	@Column(name = "FILE_ATT_ID")
//	private int fileAttId;
	
	@Id
	@Column(name = "FILE_TYPE")
	private int attatchType;
	
	@Column(name = "TYPE_ID")  //called ref id.
	private int stratId;
	
	@Column(name = "FILE_DESC")
	private String fileDesc;
	
	@Column(name = "LINK")
	private String fileLink;
	
	@Column(name = "FILE_VISIBLE")
	private int visible;
	
	@Column(name = "ADDED_BY")
	private String userId;
	
	@Column(name = "ADDED_DATE")
	private Date added;
	
	@Column(name = "FOLDER_ID")
	private Integer folderId;

//	public int getFileAttId() {
//		return fileAttId;
//	}
//
//	public void setFileAttId(int fileAttId) {
//		this.fileAttId = fileAttId;
//	}

	public int getAttatchType() {
		return attatchType;
	}

	public void setAttatchType(int attatchType) {
		this.attatchType = attatchType;
	}

	public int getStratId() {
		return stratId;
	}

	public void setStratId(int stratId) {
		this.stratId = stratId;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	
	
	



}

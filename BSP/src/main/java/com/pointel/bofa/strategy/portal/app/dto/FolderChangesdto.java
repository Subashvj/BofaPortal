package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FolderChangesdto {
	
	@Id
	private int folderId;
	
	private int attachmentId;
	
	private int stratid;

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public int getStratid() {
		return stratid;
	}

	public void setStratid(int stratid) {
		this.stratid = stratid;
	}

	@Override
	public String toString() {
		return "FolderChangesdto [folderId=" + folderId + ", attachmentId=" + attachmentId + ", stratid=" + stratid
				+ "]";
	}
	
	

}

package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddFileOrFolder {
	
	@Id
	@Column(name = "ARTIFACT_TYPE_ID")
	private int artifactTypeId;
	@Column(name = "ARTIFACT_TYPE_DESC")
	private String artifactTypeDesc;
	@Column(name = "SORT_ORDER")
	private int sortOrder;
	
	
	public int getArtifactTypeId() {
		return artifactTypeId;
	}
	public void setArtifactTypeId(int artifactTypeId) {
		this.artifactTypeId = artifactTypeId;
	}
	public String getArtifactTypeDesc() {
		return artifactTypeDesc;
	}
	public void setArtifactTypeDesc(String artifactTypeDesc) {
		this.artifactTypeDesc = artifactTypeDesc;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}

package com.pointel.bofa.strategy.portal.app.dto;

public class AddFileOrFolderRequest {
	
	
	private int artifactTypeId;
	
	private String artifactTypeDesc;
	
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

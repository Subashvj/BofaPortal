package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtifactTypeInfo {
	
	@Id
	private int artifactTypeId;
	
	private String artifactTypeDesc;
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

}

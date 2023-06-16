package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ArtifactInfo {
	@Id
	@Column(name = "ARTIFACT_ID")
	private int artifactId;
	
	@Column(name = "COMPONENT_NAME")
	private String componentName;
	
	@Column(name = "ARTIFACT_ADDED")
	private Date artifactAdded;
	
	@Column(name = "ARTIFACT_VERSION")
	private String artifactVersion;
	
	@Column(name = "ARTIFACT_TYPE_DESC")
	private String artifactTyeDesc;
	
	@Column(name = "ARTIFACT_NOTE")
	private String artifactNote;
	
	public int getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Date getArtifactAdded() {
		return artifactAdded;
	}
	public void setArtifactAdded(Date artifactAdded) {
		this.artifactAdded = artifactAdded;
	}
	public String getArtifactVersion() {
		return artifactVersion;
	}
	public void setArtifactVersion(String artifactVersion) {
		this.artifactVersion = artifactVersion;
	}
	public String getArtifactTyeDesc() {
		return artifactTyeDesc;
	}
	public void setArtifactTyeDesc(String artifactTyeDesc) {
		this.artifactTyeDesc = artifactTyeDesc;
	}
	public String getArtifactNote() {
		return artifactNote;
	}
	public void setArtifactNote(String artifactNote) {
		this.artifactNote = artifactNote;
	}
	

}

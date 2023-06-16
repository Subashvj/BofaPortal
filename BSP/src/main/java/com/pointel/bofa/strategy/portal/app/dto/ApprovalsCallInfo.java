package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApprovalsCallInfo {
	@Id
	@Column(name = "ARTIFACT_ID")
	private int artifactId;
	
	@Column(name = "ARTIFACT_LINK")
	private String artifactLink;
	
	@Column(name = "ARTIFACT_ADDED")
	private Date artifactAdded;
	
	@Column(name = "ARTIFACT_DUE")
	private Date artifaceDue;
	
	@Column(name = "ARTIFACT_ACTIVE")
	private int artifactActive;
	
	@Column(name = "ARTIFACT_TYPE_DESC")
	private String artifactTypeDesc;
	
	@Column(name = "ARTIFACT_VERSION")
	private String artifact_version;
	
	@Column(name = "STRAT_ID")
	private int stratId;
	
	@Column(name = "COMPONENT_NAMES")
	private String componentNames;
	

	@Column(name = "DUE_SHORT")
	private String dueShort;
	
	@Column(name = "ADDED_SHORT")
	private String addedShort;
	
	@Column(name = "ARTIFACT_NOTE")
	private int artifactNote;
	
	@Column(name = "ARTIFACT_TYPE_ID")
	private int artifatTypeID;
	
	@Column(name = "SORT_ORDER")
	private int sortOrder;
	
	@Column(name = "NON_PUBLIC")
	private int nonPublic;

	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	public String getArtifactLink() {
		return artifactLink;
	}

	public void setArtifactLink(String artifactLink) {
		this.artifactLink = artifactLink;
	}

	public Date getArtifactAdded() {
		return artifactAdded;
	}

	public void setArtifactAdded(Date artifactAdded) {
		this.artifactAdded = artifactAdded;
	}

	public Date getArtifaceDue() {
		return artifaceDue;
	}

	public void setArtifaceDue(Date artifaceDue) {
		this.artifaceDue = artifaceDue;
	}

	public int getArtifactActive() {
		return artifactActive;
	}

	public void setArtifactActive(int artifactActive) {
		this.artifactActive = artifactActive;
	}

	public String getArtifactTypeDesc() {
		return artifactTypeDesc;
	}

	public void setArtifactTypeDesc(String artifactTypeDesc) {
		this.artifactTypeDesc = artifactTypeDesc;
	}

	public String getArtifact_version() {
		return artifact_version;
	}

	public void setArtifact_version(String artifact_version) {
		this.artifact_version = artifact_version;
	}

	public int getStratId() {
		return stratId;
	}

	public void setStratId(int stratId) {
		this.stratId = stratId;
	}

	public String getComponentNames() {
		return componentNames;
	}

	public void setComponentNames(String componentNames) {
		this.componentNames = componentNames;
	}

	public String getDueShort() {
		return dueShort;
	}

	public void setDueShort(String dueShort) {
		this.dueShort = dueShort;
	}

	public String getAddedShort() {
		return addedShort;
	}

	public void setAddedShort(String addedShort) {
		this.addedShort = addedShort;
	}

	public int getArtifactNote() {
		return artifactNote;
	}

	public void setArtifactNote(int artifactNote) {
		this.artifactNote = artifactNote;
	}

	public int getArtifatTypeID() {
		return artifatTypeID;
	}

	public void setArtifatTypeID(int artifatTypeID) {
		this.artifatTypeID = artifatTypeID;
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


}

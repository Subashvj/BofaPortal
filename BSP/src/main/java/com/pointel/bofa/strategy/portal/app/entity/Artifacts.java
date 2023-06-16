package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ARTIFACTS")
public class Artifacts {
	@Id
	@GeneratedValue( generator = "ARTIFACTS_ARTIFACT_ID_SEQ",   strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "ARTIFACTS_ARTIFACT_ID_SEQ", sequenceName = "ARTIFACTS_ARTIFACT_ID_SEQ", allocationSize = 1)
	@Column(name = "ARTIFACT_ID")
	private int artifactId;
	
	@Column(name = "ARTIFACT_LINK")
	private String artifactLink;
	
	@Column(name = "ARTIFACT_ADDED")
	private Date artifactAdded;
	
	@Column(name = "ARTIFACT_DUE")
	private Date artifactDue;
	
	@Column(name = "ARTIFACT_ACTIVE")
	private int artifactActive;
	
	@Column(name = "ARTIFACT_ADDEDBY")
	private String artifactAddedBy;
	
	@Column(name = "ARTIFACT_TYPE_ID")
	private int artifactTypeId;
	
	@Column(name = "ARTIFACT_VERSION")
	private String artifactVersion;
	
	@Column(name = "STRAT_ID")
	private int stratId;
	
	@Column(name = "LOCKDATE")
	private Date lockDate;
	
	@Column(name = "LOCKBY")
	private String lockBy;
	
	@Column(name = "ARTIFACT_NOTE")
	private String artifactNote;
	
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
	public Date getArtifactDue() {
		return artifactDue;
	}
	public void setArtifactDue(Date artifactDue) {
		this.artifactDue = artifactDue;
	}
	public int getArtifactActive() {
		return artifactActive;
	}
	public void setArtifactActive(int artifactActive) {
		this.artifactActive = artifactActive;
	}
	public String getArtifactAddedBy() {
		return artifactAddedBy;
	}
	public void setArtifactAddedBy(String artifactAddedBy) {
		this.artifactAddedBy = artifactAddedBy;
	}
	public int getArtifactTypeId() {
		return artifactTypeId;
	}
	public void setArtifactTypeId(int artifactTypeId) {
		this.artifactTypeId = artifactTypeId;
	}
	public String getArtifactVersion() {
		return artifactVersion;
	}
	public void setArtifactVersion(String artifactVersion) {
		this.artifactVersion = artifactVersion;
	}
	public int getStratId() {
		return stratId;
	}
	public void setStratId(int stratId) {
		this.stratId = stratId;
	}
	public Date getLockDate() {
		return lockDate;
	}
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
	public String getLockBy() {
		return lockBy;
	}
	public void setLockBy(String lockBy) {
		this.lockBy = lockBy;
	}
	public String getArtifactNote() {
		return artifactNote;
	}
	public void setArtifactNote(String artifactNote) {
		this.artifactNote = artifactNote;
	}
	
	

}

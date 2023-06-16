package com.pointel.bofa.strategy.portal.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTIFACT_USERS")
public class ArtifactUser {
	@Id
	@Column(name = "ARTIFACT_ID")
	private int artifactId;
	
	@Column(name = "ARTIFACT_USER")
	private String artifactUser;
	
	@Column(name = "ARTIFACT_ROLE")
	private int artifactRole;
	
	@Column(name = "ARTIFACT_SIGNOFF")
	private int artifactSignOff;
	
	@Column(name = "ARTIFACT_SIGNOFF_DATE")
	private Date artifactSignoffDate;
	
	@Column(name = "ARTIFACT_COMMENTS")
	private String arttifactComments;
	
	
	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	public String getArtifactUser() {
		return artifactUser;
	}

	public void setArtifactUser(String artifactUser) {
		this.artifactUser = artifactUser;
	}

	public int getArtifactRole() {
		return artifactRole;
	}

	public void setArtifactRole(int artifactRole) {
		this.artifactRole = artifactRole;
	}

	public int getArtifactSignOff() {
		return artifactSignOff;
	}

	public void setArtifactSignOff(int artifactSignOff) {
		this.artifactSignOff = artifactSignOff;
	}

	public Date getArtifactSignoffDate() {
		return artifactSignoffDate;
	}

	public void setArtifactSignoffDate(Date artifactSignoffDate) {
		this.artifactSignoffDate = artifactSignoffDate;
	}

	public String getArttifactComments() {
		return arttifactComments;
	}

	public void setArttifactComments(String arttifactComments) {
		this.arttifactComments = arttifactComments;
	}

	
	

}

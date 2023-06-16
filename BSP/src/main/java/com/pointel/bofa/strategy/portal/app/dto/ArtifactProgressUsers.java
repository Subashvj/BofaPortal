package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtifactProgressUsers {
	
	@Id
	@Column(name="DISPLAYNAME")
	private String displayname;
	
	@Column(name="ARTIFACT_USER")
	private String artifactUser;
	
	@Column(name="ARTIFACT_ROLE")
	private int artifactRole;
	
	@Column(name="ARTIFACT_SIGNOFF")
	private int artifactSignoff;
	
	@Column(name="ARTIFACT_SIGNOFF_DATE")
	private String artifactSignoffDate;
	

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
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

	public int getArtifactSignoff() {
		return artifactSignoff;
	}

	public void setArtifactSignoff(int artifactSignoff) {
		this.artifactSignoff = artifactSignoff;
	}

	public String getArtifactSignoffDate() {
		return artifactSignoffDate;
	}

	public void setArtifactSignoffDate(String artifactSignoffDate) {
		this.artifactSignoffDate = artifactSignoffDate;
	}
	
}

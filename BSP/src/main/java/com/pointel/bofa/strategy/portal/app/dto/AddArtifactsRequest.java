package com.pointel.bofa.strategy.portal.app.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AddArtifactsRequest {
	
	private int stratId;
	
	private List<Integer> componentId;
	
	private int artifactTypeId;
	
	private String artifactVersion;
	
	private String artifactDue;
	
	private String artifactLink;
	
	private String artifactAddedBy;
	
	private String artifactNote;
	
	private int attachId;
	
	//curFolder
	
	private HashMap<String, Integer> user;

	
	
	
	
	
	
	
	public String getArtifactDue() {
		return artifactDue;
	}

	public void setArtifactDue(String artifactDue) {
		this.artifactDue = artifactDue;
	}

	public HashMap<String, Integer> getUser() {
		return user;
	}

	public void setUser(HashMap<String, Integer> user) {
		this.user = user;
	}

	public int getStratId() {
		return stratId;
	}

	public void setStratId(int stratId) {
		this.stratId = stratId;
	}

	public List<Integer> getComponentId() {
		return componentId;
	}

	public void setComponentId(List<Integer> componentId) {
		this.componentId = componentId;
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

	

	public String getArtifactLink() {
		return artifactLink;
	}

	public void setArtifactLink(String artifactLink) {
		this.artifactLink = artifactLink;
	}

	public String getArtifactAddedBy() {
		return artifactAddedBy;
	}

	public void setArtifactAddedBy(String artifactAddedBy) {
		this.artifactAddedBy = artifactAddedBy;
	}

	public String getArtifactNote() {
		return artifactNote;
	}

	public void setArtifactNote(String artifactNote) {
		this.artifactNote = artifactNote;
	}

	public int getAttachId() {
		return attachId;
	}

	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}


	
	
	

}

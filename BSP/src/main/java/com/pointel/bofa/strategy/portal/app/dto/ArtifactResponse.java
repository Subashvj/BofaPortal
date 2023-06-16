package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class ArtifactResponse {

	private List<ArtifactProgress> artifactProgress;
	private List<ArtifactProgressUsers> artifactProgressUsers;
	public List<ArtifactProgress> getArtifactProgress() {
		return artifactProgress;
	}
	public void setArtifactProgress(List<ArtifactProgress> artifactProgress) {
		this.artifactProgress = artifactProgress;
	}
	public List<ArtifactProgressUsers> getArtifactProgressUsers() {
		return artifactProgressUsers;
	}
	public void setArtifactProgressUsers(List<ArtifactProgressUsers> artifactProgressUsers) {
		this.artifactProgressUsers = artifactProgressUsers;
	}
	
	
}

package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ArtifactToComponent {
	@EmbeddedId
	private ArtifactToComponentPk artifactToComponentPk;

	public ArtifactToComponentPk getArtifactToComponentPk() {
		return artifactToComponentPk;
	}

	public void setArtifactToComponentPk(ArtifactToComponentPk artifactToComponentPk) {
		this.artifactToComponentPk = artifactToComponentPk;
	}
	

}

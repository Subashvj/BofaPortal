package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AssignedUser {
	
	@Id
	@Column(name = "EMAIL")
	private String eMail;
	
	@Column(name = "DISPLAYNAME")
	private String displayName;

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}

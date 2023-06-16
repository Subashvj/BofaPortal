package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
	private String displayname;
	@Id
	private String email;
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

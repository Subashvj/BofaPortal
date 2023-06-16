package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecusersInfo {
	@Id
	private String users;
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	}
	
	
	
	
	


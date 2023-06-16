package com.pointel.bofa.strategy.portal.app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDataInfo {
	
	@Id
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "TEXT")
	private String text;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



}

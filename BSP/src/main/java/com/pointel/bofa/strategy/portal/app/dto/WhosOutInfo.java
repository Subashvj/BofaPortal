package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WhosOutInfo {
@Id
private String userid;
private int outlen;
private String displayname;
private String outdesc;
private int outtype;

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public int getOutlen() {
	return outlen;
}
public void setOutlen(int outlen) {
	this.outlen = outlen;
}

public String getDisplayname() {
	return displayname;
}
public void setDisplayname(String displayname) {
	this.displayname = displayname;
}
public String getOutdesc() {
	return outdesc;
}
public void setOutdesc(String outdesc) {
	this.outdesc = outdesc;
}
public int getOuttype() {
	return outtype;
}
public void setOuttype(int outtype) {
	this.outtype = outtype;
}
}

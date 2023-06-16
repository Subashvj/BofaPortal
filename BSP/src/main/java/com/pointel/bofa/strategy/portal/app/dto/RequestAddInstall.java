package com.pointel.bofa.strategy.portal.app.dto;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class RequestAddInstall {

	private String Title;
	private int installationType;
	private int environment;
	private String installationDate;
	private String startTime;
	private String endTime;
	private String cabNum;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getInstallationType() {
		return installationType;
	}
	public void setInstallationType(int installationType) {
		this.installationType = installationType;
	}
	public int getEnvironment() {
		return environment;
	}
	public void setEnvironment(int environment) {
		this.environment = environment;
	}
	

	public String getInstallationDate() {
		return installationDate;
	}
	public void setInstallationDate(String installationDate) {
		this.installationDate = installationDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCabNum() {
		return cabNum;
	}
	public void setCabNum(String cabNum) {
		this.cabNum = cabNum;
	}
}

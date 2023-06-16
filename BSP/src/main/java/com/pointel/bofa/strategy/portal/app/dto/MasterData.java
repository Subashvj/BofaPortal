package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MasterData {
	
	public List<UserDataInfo> userData;
	
	public List<PhaseInfo> phaseInfo;
	
	public List<MilestoneInfo> milestoneData;

	public List<UserDataInfo> getUserData() {
		return userData;
	}

	public void setUserData(List<UserDataInfo> userData) {
		this.userData = userData;
	}

	public List<PhaseInfo> getPhaseInfo() {
		return phaseInfo;
	}

	public void setPhaseInfo(List<PhaseInfo> phaseInfo) {
		this.phaseInfo = phaseInfo;
	}

	public List<MilestoneInfo> getMilestoneData() {
		return milestoneData;
	}

	public void setMilestoneData(List<MilestoneInfo> milestoneData) {
		this.milestoneData = milestoneData;
	}

}

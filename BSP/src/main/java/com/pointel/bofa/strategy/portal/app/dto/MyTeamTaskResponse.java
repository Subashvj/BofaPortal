package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class MyTeamTaskResponse {

	private List<MytaskPastInfo> mytaskPastInfo;
	private List<MyTeamTaskInfo> teamTaskInfos;
	public List<MytaskPastInfo> getMytaskPastInfo() {
		return mytaskPastInfo;
	}
	public void setMytaskPastInfo(List<MytaskPastInfo> mytaskPastInfo) {
		this.mytaskPastInfo = mytaskPastInfo;
	}
	public List<MyTeamTaskInfo> getTeamTaskInfos() {
		return teamTaskInfos;
	}
	public void setTeamTaskInfos(List<MyTeamTaskInfo> teamTaskInfos) {
		this.teamTaskInfos = teamTaskInfos;
	}
}

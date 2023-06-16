package com.pointel.bofa.strategy.portal.app.dto;

import java.util.List;

public class MyTaskResponse {

	
	private List<MyTaskInfo> myTaskInfo;
	
	private List<MytaskPastInfo> mytaskPastInfo;
	
	public List<MyTaskInfo> getMyTaskInfo() {
		return myTaskInfo;
	}
	public void setMyTaskInfo(List<MyTaskInfo> myTaskInfo) {
		this.myTaskInfo = myTaskInfo;
	}
	public List<MytaskPastInfo> getMytaskPastInfo() {
		return mytaskPastInfo;
	}
	public void setMytaskPastInfo(List<MytaskPastInfo> mytaskPastInfo) {
		this.mytaskPastInfo = mytaskPastInfo;
	}
	
	
	
	
	}


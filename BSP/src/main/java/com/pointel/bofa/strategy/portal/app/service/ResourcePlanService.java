package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;
import com.pointel.bofa.strategy.portal.app.dto.DevPlanningRequest;
import com.pointel.bofa.strategy.portal.app.dto.FolderChangesdto;
import com.pointel.bofa.strategy.portal.app.dto.Resources;
import com.pointel.bofa.strategy.portal.app.dto.StratMembersDto;

public interface ResourcePlanService {
	
	public void addDeleteDevPlanning(DevPlanningRequest stratTask) throws Exception;
	public List<Resources> getResources(int stratId) throws Exception;
	public int updateResources( FolderChangesdto folderChangesdto) throws Exception;
	public List<StratMembersDto> getResourcesLikeDisplayName(int stratId, String displayName) throws Exception;

}

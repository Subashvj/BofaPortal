package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.AddTeamMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.DeleteStratMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.RolesInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMemberUsersInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateRoleRequest;
import com.pointel.bofa.strategy.portal.app.dto.UserInfo;
import com.pointel.bofa.strategy.portal.app.entity.StratMembers;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

public interface TeamMembersService {
	List<StratMemberInfo> getTeamMembers(int stratId) throws Exception;
	List<RecursersList> getRecusersInfo(int StratID) throws Exception ;
	List<RolesInfo> getRolesInfo()throws Exception;
	List<TeamMemberUsersInfo> getTeamMemberUsersInfo(int stratId)throws Exception;
	List<TeamMemberUsersInfo>TeamMemberUsersSearchInfo(int stratId,String searchValue)throws Exception;
	List<RolesInfo> getRolesSearchInfo(String searchValue)throws Exception;
	StratMembers UpdateTeamMembersRole( UpdateRoleRequest request)throws Exception;
	ResponseMessage deleteStratMember(DeleteStratMemberRequest deleteRequest)throws Exception;
	ResponseMessage addTeamMembers(AddTeamMemberRequest teamMemberRequest)throws Exception;

}

package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pointel.bofa.strategy.portal.app.dto.AddTeamMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.DeleteStratMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.RolesInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMemberUsersInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateRoleRequest;
import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.entity.StratMembers;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.logger.PointelLogger;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.service.TeamMembersServiceImpl;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@RestController
@RequestMapping("/api/v1/projects/teammembers")
public class TeamMembersController {
	public static Logger logger = LogManager.getLogger(TeamMembersController.class);
	@Autowired
	TeamMembersServiceImpl teamMembersServiceImpl;
	@Autowired
	TraceLogger traceLogger;

	@GetMapping("/getStratMembers/{stratId}")
	public ResponseEntity<?> getStratMembers(@PathVariable int stratId) throws Exception {
		logger.info("[BSP]:getStratMember() - controller method call Started");
		logger.info("Input TypeId:{}", stratId);
		List<StratMemberInfo> memberList = null;
		try {
			memberList = teamMembersServiceImpl.getTeamMembers(stratId);
			return ResponseEntity.ok().body(memberList);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getStratMembers");
			return ResponseEntity.ok().body(error);
		}
	}

	@GetMapping("/getRecuserId/{stratId}")
	public ResponseEntity<?> getrecuserInfo(@PathVariable int stratId) throws Exception {
		List<RecursersList> recuInfo = null;
		try {
			recuInfo = teamMembersServiceImpl.getRecusersInfo(stratId);
			return ResponseEntity.ok().body(recuInfo);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getStratMembers");
			return ResponseEntity.ok().body(error);
		}

	}

	@GetMapping("/getRoles")
	public ResponseEntity<?> getRoles() throws Exception {
		List<RolesInfo> roleInfo = null;
		try {
			roleInfo = teamMembersServiceImpl.getRolesInfo();
			return ResponseEntity.ok().body(roleInfo);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getStratMembers");
			return ResponseEntity.ok().body(error);
		}
	}

	@GetMapping("/getRolesSearch/{searchValue}")
	@ResponseBody
	public ResponseEntity<?> getRolesSearch(@PathVariable String searchValue) throws Exception {
		List<RolesInfo> roleSearchInfo = null;
		try {
			roleSearchInfo = teamMembersServiceImpl.getRolesSearchInfo(searchValue.toLowerCase());
			return ResponseEntity.ok().body(roleSearchInfo);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getStratMembers");
			return ResponseEntity.ok().body(error);
		}
	}

	@GetMapping("/getTeamMemberUsers/{stratId}")
	public ResponseEntity<?> getTeamMemberUsers(@PathVariable int stratId) throws Exception {
		List<TeamMemberUsersInfo> teamUsers = null;
		try {
			teamUsers = teamMembersServiceImpl.getTeamMemberUsersInfo(stratId);
			return ResponseEntity.ok().body(teamUsers);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getTeamMemberUsers");
			return ResponseEntity.ok().body(error);
		}
	}

	@GetMapping("/getTeamMemberUsers/{stratId}/{searchValue}")
	@ResponseBody
	public ResponseEntity<?> getTeamMemberUsersSearch(@PathVariable int stratId, String searchValue) throws Exception {
		List<TeamMemberUsersInfo> teamUsers = null;
		try {
			teamUsers = teamMembersServiceImpl.TeamMemberUsersSearchInfo(stratId, searchValue.toLowerCase());
			return ResponseEntity.ok().body(teamUsers);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in getTeamMemberUsers");
			return ResponseEntity.ok().body(error);
		}
	}

	@PutMapping("/updateStratMemberRole")
	public ResponseEntity<?> updateTeamMembersRole(@RequestBody UpdateRoleRequest request) throws Exception {

		StratMembers stratMembers = null;
		try {
			stratMembers = teamMembersServiceImpl.UpdateTeamMembersRole(request);
			return ResponseEntity.ok().body(stratMembers);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in updateTeamMembersRole");
			return ResponseEntity.ok().body(error);
		}
	}
	@PostMapping("/deleteStratMember")
	public ResponseEntity<?> deleteStratMember(@RequestBody DeleteStratMemberRequest deleteRequest ) throws Exception {
		
		try {
			ResponseMessage responsemessage = teamMembersServiceImpl.deleteStratMember(deleteRequest);
			return ResponseEntity.ok().body(responsemessage);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in deleteStratMember()");
			return ResponseEntity.ok().body(error);
		}
	}
	
	@PostMapping("/addStratMember")
	public ResponseEntity<?> addStratMember(@RequestBody AddTeamMemberRequest request) throws Exception {
		try {
			ResponseMessage responsemessage = teamMembersServiceImpl.addTeamMembers(request);
			return ResponseEntity.ok().body(responsemessage);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured ");
			logger.error("Error occured in addStratMember()");
			return ResponseEntity.ok().body(error);
		}
	}
}

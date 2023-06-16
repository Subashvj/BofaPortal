package com.pointel.bofa.strategy.portal.app.service;

import java.util.Date;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.controller.ProjectLinkedInstalltion;
import com.pointel.bofa.strategy.portal.app.dto.AddTeamMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.DeleteStratMemberRequest;
import com.pointel.bofa.strategy.portal.app.dto.ProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.RecusersInfo;
import com.pointel.bofa.strategy.portal.app.dto.RolesInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMemberUsersInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateRoleRequest;
import com.pointel.bofa.strategy.portal.app.dto.UserInfo;
import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.entity.StratMembers;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.repository.EmailProjectAssignmentInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.ProjectInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.RecusersListRepository;
import com.pointel.bofa.strategy.portal.app.repository.RecusersRepository;
import com.pointel.bofa.strategy.portal.app.repository.RolesRepository;
import com.pointel.bofa.strategy.portal.app.repository.StratHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratMembersInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.StratMembersRepo;
import com.pointel.bofa.strategy.portal.app.repository.TeamMembersUsersRepository;
import com.pointel.bofa.strategy.portal.app.repository.UserInfoRepo;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class TeamMembersServiceImpl implements TeamMembersService {
	public static Logger logger = LogManager.getLogger(TeamMembersServiceImpl.class);

	@Autowired
	StratMembersInfoRepository stratMembersinfoRepository;
	@Autowired
	RecusersRepository recusersRepository;
	@Autowired
	RecusersListRepository recusersListRepository;
	@Autowired
	RolesRepository rolesRepository;
	@Autowired
	TeamMembersUsersRepository membersUsersRepository;
	@Autowired
	StratMembersRepo stratmembersRepo;
	@Autowired
	StratHistoryRepo historyRepo;
	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	UserInfoRepo userInfoRepo;
	@Autowired
	ProjectInfoRepo projectInfoRepo;
	@Autowired
	EmailProjectAssignmentInfoRepo emailProjectAssignmentInfoRepo;

	@Value("${userid}")
	private String userId;
	
	@Value("${spring.mail.username}")
	private String fromEmailId;
	
	@Value("${server.name}")
	private String serverName;

	@Override
	public List<StratMemberInfo> getTeamMembers(int stratId) throws Exception {
		logger.info("[BSP]:getStratMember() - Service method call Started");
		List<StratMemberInfo> stratMember = stratMembersinfoRepository.getStratMembers(stratId);
		System.out.println("stratMember service" + stratMember);
		logger.info("[BSP]:getStratMember() - Service method call Ended");
		return stratMember;
	}

	@Override
	public List<RecursersList> getRecusersInfo(int StratID) throws Exception {
		List<RecusersInfo> recuInfo = recusersRepository.getRecusersInfoId(StratID);
		logger.info("[BSP]:stratId " + StratID);
		logger.info("[BSP]:recuInfo() " + recuInfo);
		// String recuInfo=users;
		List<RecursersList> recursersList = recusersListRepository.getRecusersListInfo(StratID, recuInfo);
		return recursersList;
	}

	@Override
	public List<RolesInfo> getRolesInfo() throws Exception {
		logger.info("[BSP]:getStratMember() - Service method call Started");
		List<RolesInfo> rolesInfo = rolesRepository.roles();
		logger.info("[BSP]:getStratMember() - Service method call Ended");
		return rolesInfo;
	}

	@Override
	public List<TeamMemberUsersInfo> getTeamMemberUsersInfo(int stratId) throws Exception {
		logger.info("[BSP]:getTeamMemberUsersInfo() - Service method call Started");
		logger.info("[BSP]:stratId " + stratId);
		List<TeamMemberUsersInfo> usersInfo = membersUsersRepository.memberUsersInfos(stratId);
		logger.info("[BSP]:getTeamMemberUsersInfo() - Service method call Ended");
		return usersInfo;
	}

	@Override
	public List<TeamMemberUsersInfo> TeamMemberUsersSearchInfo(int stratId, String searchValue) {
		logger.info("[BSP]:getTeamMemberUsersInfo() - Service method call Started");
		logger.info("[BSP]:stratId " + stratId);
		logger.info("[BSP]:searchValue " + searchValue);
		List<TeamMemberUsersInfo> usersSearchInfo = membersUsersRepository.memberUsersSearchInfos(stratId,
				searchValue.toLowerCase());
		logger.info("[BSP]:getTeamMemberUsersInfo() - Service method call Ended");
		return usersSearchInfo;

	}

	@Override
	public List<RolesInfo> getRolesSearchInfo(String searchValue) throws Exception {
		logger.info("[BSP]:getRolesSearchInfo() - Service method call Started");
		logger.info("[BSP]:searchValue " + searchValue);
		List<RolesInfo> roleSearchInfo = rolesRepository.rolesSearch(searchValue.toLowerCase());
		logger.info("[BSP]:getRolesSearchInfo() - Service method call Ended");
		return roleSearchInfo;
	}

	@Override
	@Transactional
	public StratMembers UpdateTeamMembersRole(UpdateRoleRequest request) throws Exception {
		logger.info("[BSP]:getRolesSearchInfso() - Service method call Started");
		int stratId = request.getStratId();
		String username = request.getUsername();
		int roleId = request.getRoleId();
		StratMembers stratMembers = stratmembersRepo.getStratMembersByStratIdAndUserName(stratId, username);
		if (stratMembers != null) {
			stratMembers.setRoleId(roleId);
			stratMembers = stratmembersRepo.save(stratMembers);
		}
		logger.info("[BSP]:getRolesSearchInfo() - Service method call Ended");
		return stratMembers;
	}

	@Override
	@Transactional
public ResponseMessage deleteStratMember(DeleteStratMemberRequest deleteRequest)throws Exception {
	logger.info("[BSP]:deleteStratMember() - Service method call Started");
	logger.info("[Bsp]:deleteStratMember :" +deleteRequest.getStratId() );
	logger.info("[Bsp]:deleteStratMember :" +deleteRequest.getUserName());
	
	
		stratmembersRepo.deleteStratMembers(deleteRequest.getStratId(), deleteRequest.getUserName());
		logger.info("[bsp]:stratMember deleted succesfully");
		String comment = userId + "deleted" + deleteRequest.getUserName() + "from the project";
		int stratid = deleteRequest.getStratId();
		String userid = userId;
		int public_ = 0;
		int analystInclude=0;
		int NewStatusId=0;
		System.out.println();
		StratHistory stratHistory = new StratHistory();
		stratHistory.setComment_(comment);
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		stratHistory.setFdate(sqldate);
		stratHistory.setStratId(stratid);
		stratHistory.setPublic_(public_);
		stratHistory.setUserid(userid);
		stratHistory.setAnalystInclude(analystInclude);
		stratHistory.setNewStatusId(NewStatusId);
		stratHistory = historyRepo.save(stratHistory);
		ResponseMessage responseMessage= new  ResponseMessage();
		responseMessage.setSuccess(true);
		responseMessage.setMessage(MessageConstants.deletedMsg);
		 
		logger.info("[Bsp]:number of rows inserted StratHistory : " + stratHistory.toString());
		logger.info("[BSP]:deleteStratMember() - Service method call Ended");
		return responseMessage;

	}


	@Override
	@Transactional
	public ResponseMessage addTeamMembers(AddTeamMemberRequest teamMemberRequest) throws Exception {
	
		boolean includeMeInCc = false;
		if(teamMemberRequest.getIncludeMe() == 1) {
			includeMeInCc = true;
		}
		List<String> userNameList= teamMemberRequest.getUserName();
		
		UserInfo userInfo_cc = userInfoRepo.getUserInfos(userId);
		ProjectInfo projectInfo = projectInfoRepo.getProjectInfo(teamMemberRequest.getStratId());
		
		for(String username : userNameList) {
		StratMembers stratMembers = stratmembersRepo.findByStratIdAndUsername( teamMemberRequest.getStratId(), username);
		if(stratMembers != null) {
			stratMembers.setRoleId(teamMemberRequest.getRoleId());
			stratmembersRepo.save(stratMembers);
		}
		else {
			StratMembers newStratMembers=new StratMembers();
			newStratMembers.setStratId(teamMemberRequest.getStratId());
			newStratMembers.setRoleId(teamMemberRequest.getRoleId());
			newStratMembers.setUsername(username);
			stratmembersRepo.save(newStratMembers);
		}
		StratHistory stratHistory = new StratHistory();
		String comment = userId + " set " + username + "'s role to " +teamMemberRequest.getRoleId();
		stratHistory.setComment_(comment);
		stratHistory.setStratId(teamMemberRequest.getStratId());
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		stratHistory.setFdate(sqldate);
		stratHistory.setUserid(username);
		stratHistory.setPublic_(0);
		historyRepo.save(stratHistory);
	
		UserInfo userInfo_to = userInfoRepo.getUserInfos(username);
		
		String subject = "Project Assignment: Project# "+String.valueOf(teamMemberRequest.getStratId())+
				" : "+projectInfo.getStratName();
		
		
		if(userId != username) {
			logger.info("[BSP]:sendSimpleMsg() - Service method call Started");
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(fromEmailId);
			messageHelper.setTo(userInfo_to.getEmail());
			if(includeMeInCc) {
				messageHelper.setCc(userInfo_cc.getEmail());
			}
			String mailContent = "http://"+serverName+"/project/email_templetes/email_projectassignment.php?strat_id="+String.valueOf(teamMemberRequest.getStratId());
			
			messageHelper.setBcc("daniel.forsee@bankofamerica.com");
			messageHelper.setText(mailContent, true);
			FileSystemResource res = new FileSystemResource(new File("src/main/resources/static/images/boa.png"));
			messageHelper.addInline("boaImg", res);
			messageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			logger.info("[POINTEL]:sendSimpleMsg() - Service method call Ended");
		}
			
		}
		ResponseMessage responseMessage= new  ResponseMessage();
		responseMessage.setSuccess(true);
		responseMessage.setMessage(MessageConstants.successMsg);
		return responseMessage;
	}
}

package com.pointel.bofa.strategy.portal.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dao.ApprovalDao;
import com.pointel.bofa.strategy.portal.app.dto.AddArtifactsRequest;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactInfo;
import com.pointel.bofa.strategy.portal.app.dto.ProjectNameInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.entity.ArtifactToComponent;
import com.pointel.bofa.strategy.portal.app.entity.ArtifactToComponentPk;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactTypeInfo;
import com.pointel.bofa.strategy.portal.app.entity.ArtifactUser;
import com.pointel.bofa.strategy.portal.app.entity.Artifacts;
import com.pointel.bofa.strategy.portal.app.entity.StratHistory;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactToComponentRepo;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactUserRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratHistoryRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratToComponentRepo;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class ApprovalService {
	public static Logger logger = LogManager.getLogger(ApprovalService.class);
	@Autowired
	ApprovalDao approvalDao;

	@Autowired
	ResponseMessage response;

	@Autowired
	ArtifactUserRepo artifactUserRepo;
	@Autowired
	StratToComponentRepo stratToComponentRepo;
	@Autowired
	ArtifactToComponentRepo artifactToComponentRepo;
	@Autowired
	ArtifactInfoRepo artifactInfoRepo;
	@Autowired
    StratHistoryRepo stratHistoryRepo;
	public List<ProjectNameInfo> getProjectNameInfoStratId(int stratId){
		logger.info("Entered into approvalService getProjectNameInfoStratId");
		logger.info("Input data stratId "+stratId);
		List<ProjectNameInfo> result = approvalDao.getProjectNameInfoStratId(stratId);
		logger.info("Result from  getProjectNameInfoStratId "+result);
		return result;


	}

	public List<ProjectNameInfo> getProjectNameInfoSuggestion(int stratId,String keyword){
		logger.info("Entered into approvalService getProjectNameInfoSuggestion");
		logger.info("Input data stratId "+stratId);
		logger.info("Input data keyword "+keyword);
		List<ProjectNameInfo> result = approvalDao.getProjectNameInfoSuggestion(stratId, keyword.toLowerCase());
		logger.info("Result from  getProjectNameInfoSuggestion "+result);
		return result;

	}


	public List<ArtifactTypeInfo> getArtifactTypeInfo(){
		logger.info("Entered into approvalService getArtifactTypeInfo");
		List<ArtifactTypeInfo> result =approvalDao.getArtifactTypeInfo();
		logger.info("Result from  getArtifactTypeInfo "+result);
		return result;

	}

	public List<ArtifactTypeInfo> getArtifactTypeInfoSuggestion(String keyword){
		logger.info("Entered into approvalService getArtifactTypeInfoSuggestion");
		logger.info("Input data Keyword "+keyword);
		List<ArtifactTypeInfo> result =approvalDao.getArtifactTypeInfoSuggestion(keyword.toLowerCase());
		logger.info("Result from  getArtifactTypeInfoSuggestion "+result);

		return result;
	}

	public List<StratMemberInfo> getStratMemberInfo(int stratId){
		logger.info("Entered into approvalService getStratMemberInfo");
		logger.info("Input data stratId "+stratId);
		List<StratMemberInfo> result=approvalDao.getStratMemberInfo(stratId);
		logger.info("Result from  getStratMemberInfo "+result);
		return result;

	}

	

	public Artifacts saveArtifacts(AddArtifactsRequest addArtifactsRequest) throws ParseException {
		logger.info("Entered into approvalService saveArtifacts");
		logger.info("Input data addArtifactsRequest"+addArtifactsRequest.toString());

		Artifacts artifacts = new Artifacts();
		if(addArtifactsRequest.getArtifactLink()!=null) {
			artifacts.setArtifactLink(addArtifactsRequest.getArtifactLink());	
		}
		else {
			logger.info("ArtifactLink is null");
		}
		
		if(addArtifactsRequest.getArtifactDue()!=null) {
			Date date=new Date();
			String str=addArtifactsRequest.getArtifactDue();
			SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY");
			date=sdf.parse(str);
			java.sql.Date sqlDate= new java.sql.Date(date.getTime());
			artifacts.setArtifactDue(sqlDate);
		}else {
			logger.info("ArtifactDue is null");
		}
		
		
		if(addArtifactsRequest.getArtifactAddedBy()!=null) {
			artifacts.setArtifactAddedBy(addArtifactsRequest.getArtifactAddedBy());
		}else {
			logger.info("ArtifactAddedBy is null");
		}
		if(addArtifactsRequest.getArtifactTypeId()!=0) {
			artifacts.setArtifactTypeId(addArtifactsRequest.getArtifactTypeId());
		}else {
			logger.info("ArtifactTypeId is 0");
		}
		if(addArtifactsRequest.getArtifactVersion()!=null) {
			artifacts.setArtifactVersion(addArtifactsRequest.getArtifactVersion());
		}else {
			logger.info("ArtifactVersion is null");
		}
		if(addArtifactsRequest.getStratId()!=0) {
			artifacts.setStratId(addArtifactsRequest.getStratId());
		}else {
			logger.info("StratId is 0");
		}
		if(addArtifactsRequest.getArtifactNote()!=null) {
			artifacts.setArtifactNote(addArtifactsRequest.getArtifactNote());
		}else {
			logger.info("ArtifactNote is null");
		}
		
		
		Date curDate=new Date();
		java.sql.Date sqlDate= new java.sql.Date(curDate.getTime());
		artifacts.setArtifactAdded(sqlDate);	//	
		//artifacts.setArtifactDue(sqlDate);		
				
		//artifacts.setArtifactTypeId(addArtifactsRequest.getArtifactTypeId());		
		//artifacts.setArtifactVersion(addArtifactsRequest.getArtifactVersion());		
		//artifacts.setStratId(addArtifactsRequest.getStratId());		
		//artifacts.setArtifactNote(addArtifactsRequest.getArtifactNote());
		logger.info("Input data artifacts"+artifacts.toString());

		artifacts=approvalDao.saveArtifacts(artifacts); //insert into artifacts
		logger.info("Input data artifacts"+artifacts.toString());
		logger.info("Artifact id while inserting data "+artifacts.getArtifactId());

		System.out.println("Artifact Id --- "+artifacts.getArtifactId());
		HashMap<String, Integer> user;
		List <String> userReq=new ArrayList<String>();
		List <String> userOpt=new ArrayList<String>();
		if(addArtifactsRequest.getUser()!=null) {
			user=addArtifactsRequest.getUser();

			logger.info("Artifact id while saving data "+artifacts.getArtifactId());



			for (Map.Entry<String,Integer> entry : user.entrySet()) {
				//System.out.println("Key = " + entry.getKey() ", Value = " + entry.getValue());

				if(entry.getValue()==1 || entry.getValue()==2) {

					ArtifactUser artifactUser=approvalDao.getArtifactUser(artifacts.getArtifactId(), entry.getKey()); 
					logger.info("Check for existing user data in DB");
					logger.info("ArtifactId from DB "+artifacts.getArtifactId());
					logger.info("User from DB "+entry.getKey());

					if(artifactUser!=null) { 
						artifactUser.setArtifactRole(entry.getValue());
						logger.info("Updating existing user data input data artifactUser"+artifactUser.toString());
						artifactUserRepo.save(artifactUser); //update artifact users
					}
					else 
					{
						ArtifactUser artifactUserNew=new ArtifactUser();
						artifactUserNew.setArtifactId(addArtifactsRequest.getArtifactTypeId());
						artifactUserNew.setArtifactUser(entry.getKey());
						artifactUserNew.setArtifactRole(entry.getValue());   
						artifactUserRepo.save(artifactUserNew);       //inserting into  artifact users 
						logger.info("Inserting new user data to DB input data artifactUserNew"+artifactUserNew.toString());
						

						if(entry.getValue()==1)
						{
							userReq.add(entry.getKey());
						}
						if(entry.getValue()==2) {
							userOpt.add(entry.getKey());
						}

					}
				}
				//old
			}
		}
		List<ArtifactToComponent> artifactToComponentsList=new ArrayList<ArtifactToComponent>();

		for (Integer cmpId : addArtifactsRequest.getComponentId()) {

			ArtifactToComponentPk artifactToComponentPk= new ArtifactToComponentPk();

			artifactToComponentPk.setArtifactId(artifacts.getArtifactId());//
			artifactToComponentPk.setComponentId(cmpId);
			ArtifactToComponent artifactToComponent=new ArtifactToComponent();
			artifactToComponent.setArtifactToComponentPk(artifactToComponentPk);
			artifactToComponentsList.add(artifactToComponent);


		}
		logger.info("");
		artifactToComponentRepo.saveAll(artifactToComponentsList);

		ArtifactInfo artifactInfo = artifactInfoRepo.getArtifactInfo(artifacts.getArtifactId());

		String approveComment="ADDED new artifact : "+artifactInfo.getComponentName()+" "+artifactInfo.getArtifactTyeDesc() +" version "+artifactInfo.getArtifactVersion()+" : Ready for Review";                    

		int newStatusId = 60;

		StratHistory stratHistory=new StratHistory();
		stratHistory.setFdate(sqlDate);
		//stratHistory.setUserid(userid);
		stratHistory.setNewStatusId(newStatusId);
		stratHistory.setComment_(approveComment);
		//stratHistory.setStratId(stratId);
		stratHistory.setPublic_(1);

		stratHistoryRepo.save(stratHistory);


//		if(result.getArtifactId()!=0) {
//			response.setSuccess(true);
//			response.setMessage(MessageConstants.successMsg);
//		}
//		else {
//			response.setSuccess(false);
//			response.setMessage(MessageConstants.failureMsg);
//		}
		//return result; //Ref
	return null;
	}






}

package com.pointel.bofa.strategy.portal.app.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pointel.bofa.strategy.portal.app.dto.ProjectNameInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratMemberInfo;
import com.pointel.bofa.strategy.portal.app.dto.ArtifactTypeInfo;
import com.pointel.bofa.strategy.portal.app.entity.ArtifactUser;
import com.pointel.bofa.strategy.portal.app.entity.Artifacts;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactTypeInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactUserRepo;
import com.pointel.bofa.strategy.portal.app.repository.ArtifactsRepo;
import com.pointel.bofa.strategy.portal.app.repository.ProjectNameInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratMemberInfoRepo;

@Component
public class ApprovalDao {
	public static Logger logger = LogManager.getLogger(ApprovalDao.class);
	
	
	@Autowired
	ProjectNameInfoRepo projectNameInfoRepo;
	
	@Autowired
	ArtifactTypeInfoRepo artifactTypeInfoRepo;
	
	@Autowired
	StratMemberInfoRepo stratMemberInfoRepo;

	@Autowired
	ArtifactsRepo artifactsRepo;
	@Autowired
	ArtifactUserRepo artifactUserRepo;
	
	public List<ProjectNameInfo> getProjectNameInfoStratId(int stratId){
		logger.info("Entered into approvalDao getProjectNameInfoStratId");
		logger.info("Input data stratId "+stratId);
		List<ProjectNameInfo> result = projectNameInfoRepo.getProjectNameInfoStratId(stratId);
		logger.info("Result from  getProjectNameInfoStratId "+result);
		return result;
	}
	
	public List<ProjectNameInfo> getProjectNameInfoSuggestion(int stratId,String keyword)
	{
		logger.info("Entered into approvalDao getProjectNameInfoSuggestion");
		logger.info("Input data stratId "+stratId);
		logger.info("Input data keyword "+keyword);
		List<ProjectNameInfo> result = projectNameInfoRepo.getProjectNameInfoSuggestion(stratId, keyword);
		logger.info("Result from  getProjectNameInfoSuggestion "+result);
		return result;
	}
	
	
	
	public List<ArtifactTypeInfo> getArtifactTypeInfo(){
		logger.info("Entered into approvalDao getArtifactTypeInfo");
		List<ArtifactTypeInfo> result =artifactTypeInfoRepo.getArtifactTypeInfo();
		logger.info("Result from  getArtifactTypeInfo "+result);
		return result;
		
	}
	
	public List<ArtifactTypeInfo> getArtifactTypeInfoSuggestion(String keyword){
		logger.info("Entered into approvalDao getArtifactTypeInfoSuggestion");
		logger.info("Input data Keyword "+keyword);
		List<ArtifactTypeInfo> result =artifactTypeInfoRepo.getArtifactTypeInfoSuggestion(keyword);
		logger.info("Result from  getArtifactTypeInfoSuggestion "+result);
		return result;
	}
	
	
	public List<StratMemberInfo> getStratMemberInfo(int stratId){
		logger.info("Entered into approvalDao getStratMemberInfo");
		List<StratMemberInfo> result =stratMemberInfoRepo.getStratMemberInfo(stratId);
		logger.info("Result from  getStratMemberInfo "+result);
		return result;
		
	}
	
	

	public Artifacts saveArtifacts(Artifacts artifacts) {
		logger.info("Entered into approvalDao saveArtifacts");
		Artifacts result=artifactsRepo.save(artifacts);
		logger.info("Result from  saveArtifacts "+result);
		return result;
		
	}
	
	public ArtifactUser getArtifactUser(int artifactId,String artifactUser) {
		logger.info("Entered into approvalDao getArtifactUser");
		ArtifactUser artifactuser = artifactUserRepo.findByArtifactIdAndArtifactUser(artifactId, artifactUser);
		logger.info("Result from getArtifactUser "+artifactuser.toString());
		return artifactuser;
	}
}

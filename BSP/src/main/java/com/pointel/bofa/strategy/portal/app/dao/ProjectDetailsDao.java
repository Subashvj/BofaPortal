package com.pointel.bofa.strategy.portal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ApprovalsCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.Cti;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedProducts;
import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;
import com.pointel.bofa.strategy.portal.app.dto.ResourcePlan;
import com.pointel.bofa.strategy.portal.app.dto.TechComponents;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstallation;
import com.pointel.bofa.strategy.portal.app.dto.Milestones;
import com.pointel.bofa.strategy.portal.app.dto.TeamMembers;
import com.pointel.bofa.strategy.portal.app.repository.ApprovalsInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.CtiRepo;
import com.pointel.bofa.strategy.portal.app.repository.ImpactedProductsRepo;
import com.pointel.bofa.strategy.portal.app.repository.LinkedInstallationRepo;
import com.pointel.bofa.strategy.portal.app.repository.MileStoneRepo;
import com.pointel.bofa.strategy.portal.app.repository.RecommendedMembersRepo;
import com.pointel.bofa.strategy.portal.app.repository.ResourcePlanRepo;
import com.pointel.bofa.strategy.portal.app.repository.TeamMembersRepo;
import com.pointel.bofa.strategy.portal.app.repository.TechComponentsRepo;

@Repository
public class ProjectDetailsDao {
	
	@Autowired
	LinkedInstallationRepo linkedInstallationRepo;
	
	@Autowired
	TeamMembersRepo TeamMembersRepo;
	
	@Autowired
	MileStoneRepo mileStoneRepo;
	
	@Autowired
	RecommendedMembersRepo recommendedMembersRepo;
	
	@Autowired
	ImpactedProductsRepo impactedProductsRepo;
	
	@Autowired
	TechComponentsRepo techComponentsRepo;
	
	@Autowired
	ApprovalsInfoRepo approvalsInfoRepo;
	
	@Autowired
	CtiRepo ctiRepo;
	
	@Autowired
	ResourcePlanRepo resourcePlanRepo;
	
	public List<LinkedInstallation> getinkedInstallation(int stratId){
		System.out.println("entered dao "+stratId);
		return linkedInstallationRepo.retrieveLinkedInstallationData(stratId);
	}
	
	 public List<TeamMembers> getTeamMembers(int stratId)throws Exception{
		 
		 return TeamMembersRepo.retrieveTeamMembers(stratId);
	 }

	public List<Milestones> getMileStones(int stratId) {
		return mileStoneRepo.retrireveMileatones(stratId);
	}
	
	//from sasi
	
	public List<ImpactedProducts> getProduct(int stratId) {
		return impactedProductsRepo.getProduct(stratId);
	}
	
	public List<RecommendedMembers> getMembers(int stratId){
		return recommendedMembersRepo.getMembers(stratId);
	}

	
	public List<TechComponents> getTechComponents(int stratId) {
		return techComponentsRepo.getComponents(stratId);
	}
	
	public List<ResourcePlan> getResourcePlan(int strat_id){
		return resourcePlanRepo.getResourcePlan(strat_id);
	}
	public List<Cti> getCti(int strat_id){
		return ctiRepo.getCti(strat_id);

	}
	
	//end

	public List<ApprovalsCallInfo> getApprovals(int stratId) {
		
		List<ApprovalsCallInfo> result  = approvalsInfoRepo.retrieveApprovalsInfoData(stratId);
		
		return result;
	}
	
	
	

}

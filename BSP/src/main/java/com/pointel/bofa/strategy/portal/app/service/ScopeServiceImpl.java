package com.pointel.bofa.strategy.portal.app.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dto.UpdateScopeRequest;

import com.pointel.bofa.strategy.portal.app.entity.StratComments;
import com.pointel.bofa.strategy.portal.app.entity.StratToScope;
import com.pointel.bofa.strategy.portal.app.entity.Strategies2;
import com.pointel.bofa.strategy.portal.app.repository.StratCommentRepo;
import com.pointel.bofa.strategy.portal.app.repository.StratScopeRepo;
import com.pointel.bofa.strategy.portal.app.repository.Strategies2Repo;

@Service
public class ScopeServiceImpl implements ScopeService {
	public static Logger logger = LogManager.getLogger(ScopeServiceImpl.class);
	@Value("${userid}")
	private String userId;
	@Autowired
	Strategies2Repo strategies2Repo;
	@Autowired
	StratScopeRepo stratScopeRepo;
	@Autowired
	StratCommentRepo stratCommentRepo;

	@Override
	public Strategies2 UpdateScopeType(UpdateScopeRequest request) throws Exception {
		logger.info("[BSP]:UpdateScopeType() - Service method call Started");
		int stratId = request.getStratId();
		int scopeType = request.getScopeType();
		String commentText = "scope design";
		Strategies2 strategies2 = null;
		strategies2 = strategies2Repo.findByStratId(stratId);
		logger.info("[BSP]:UpdateScopeType() stratID:- " + stratId);
		switch (scopeType) {
		case 1:

			if (strategies2 != null) {
				strategies2.setImpactPrompt(request.getImpactPrompt());
				strategies2.setImpactUi(request.getImpactUi());
				strategies2.setImpactDid(request.getImpactDid());
				strategies2.setImpactDynmen(request.getImpactDynmen());
				strategies2.setImpactDt(request.getImpactDt());
				strategies2.setImpactDb(request.getImpactDb());
				strategies2.setImpactNlu(request.getImpactNlu());
				strategies2.setImpactGrammar(request.getImpactGrammer());
				strategies2.setImpactKvp(request.getImpactKvp());
				strategies2.setImpactCti(request.getImpactCti());
				strategies2.setImpactCodeonly(request.getImpactCodeonly());
				strategies2 = strategies2Repo.save(strategies2);
			}
			break;
		case 2:
			commentText = "test scope";
			if (strategies2 != null) {
				strategies2.setImpactRegrtest(request.getImpactRegrtest());
				strategies2.setImpactFunctest(request.getImpactRegrtest());
				strategies2.setImpactPivtest(request.getImpactPivtest());
				strategies2.setImpactSit(request.getImpactSit());
				strategies2 = strategies2Repo.save(strategies2);
			}
			break;
		case 3:
			commentText = "Analaytics scope ";
			if (strategies2 != null) {
				strategies2.setImpactChampchall(request.getImpactChampchall());
				strategies2 = strategies2Repo.save(strategies2);
			}
		default:
			break;
		}

		StratToScope stratToScope = new StratToScope();
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		stratToScope.setScopeDate(sqldate);
		stratToScope.setScopeId(scopeType);
		stratToScope.setScopeUserid(userId);
		stratToScope.setStratId(stratId);
		stratToScope = stratScopeRepo.save(stratToScope);

		StratComments stratComment = new StratComments();
		stratComment.setStratId(stratId);
		stratComment.setCommentUser(userId);
		stratComment.setCommentDate(""+date.getTime());
		stratComment.setFdate(sqldate);
		stratComment.setComment_("update" + commentText + "scope information");
		stratComment = stratCommentRepo.save(stratComment);

		logger.info("[BSP]:UpdateScopeType() - Service method call Ended");
		return strategies2;

	}
}

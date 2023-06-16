package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.UpdateScopeRequest;
import com.pointel.bofa.strategy.portal.app.entity.Strategies2;

public interface ScopeService {
	
	Strategies2 UpdateScopeType(UpdateScopeRequest request) throws Exception;

}

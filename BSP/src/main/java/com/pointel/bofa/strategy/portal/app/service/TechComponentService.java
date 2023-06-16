package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateTechComponentRequest;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

public interface TechComponentService {
	List<TechComponentsEditInfo>getTechcomponentEditInfo(int stratId)throws Exception;
	ResponseMessage UpdateTechComponent(UpdateTechComponentRequest request) throws Exception;
}

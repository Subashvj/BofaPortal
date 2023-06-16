package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateImpactedProductsRequest;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

public interface ImpactedProductService {
	List<ImpactedComponentsEditInfo> getImpactedComponents(int stratId) throws Exception;
	ResponseMessage updateProduct(UpdateImpactedProductsRequest request)throws Exception;
}

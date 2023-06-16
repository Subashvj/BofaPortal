package com.pointel.bofa.strategy.portal.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpdateImpactedProductsRequest;
import com.pointel.bofa.strategy.portal.app.entity.StratToProduct;
import com.pointel.bofa.strategy.portal.app.entity.StratToProductPK;
import com.pointel.bofa.strategy.portal.app.repository.ImpactedComponentsRepository;
import com.pointel.bofa.strategy.portal.app.repository.StratToProductRepo;
import com.pointel.bofa.strategy.portal.app.util.MessageConstants;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;
@Service
public class ImpactedProductServiceImpl implements ImpactedProductService {
	private static Logger logger = LogManager.getLogger(ImpactedProductServiceImpl.class);
	@Autowired
	ImpactedComponentsRepository impactedComponentsRepository;
	@Autowired
	StratToProductRepo stratToProductRepo;
	
	@Override
	public List<ImpactedComponentsEditInfo> getImpactedComponents(int stratId) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl getApprovals input data :" + stratId);
		List<ImpactedComponentsEditInfo> componentsEditinfos = impactedComponentsRepository.impactedComponentsEditInfos(stratId);
		logger.info("getTechComponents result  data :" + componentsEditinfos.toString());
		return componentsEditinfos;
	}

	@Override
	@Transactional
	public ResponseMessage updateProduct(UpdateImpactedProductsRequest request) throws Exception {
		logger.info("Entered into ProjectDetailsServiceimpl and updateProduct method started");
		stratToProductRepo.deleteAllByStratId(request.getStratId());
		ResponseMessage responseMessage = new ResponseMessage();
		List<Integer> productIds = request.getProductId();
		List<StratToProduct> stratToProductsList= new ArrayList<>();
		for(int productId :productIds ) {
			StratToProductPK stratToProductpk = new StratToProductPK();
			StratToProduct stratToProduct = new StratToProduct();
			stratToProductpk.setStratId(request.getStratId());
			stratToProductpk.setProductId(productId);
			stratToProduct.setStratToProductPK(stratToProductpk);
			stratToProductsList.add(stratToProduct);
		}
		stratToProductRepo.saveAll(stratToProductsList);
		responseMessage.setSuccess(true);
		responseMessage.setMessage(MessageConstants.successMsg);
		logger.info("exit from ProjectDetailsServiceimpl and updateProduct method ended");
		return responseMessage;
	}

	

}

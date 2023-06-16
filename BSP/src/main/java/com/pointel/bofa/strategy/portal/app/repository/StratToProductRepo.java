package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.StratToComponentPK;
import com.pointel.bofa.strategy.portal.app.entity.StratToProduct;

@Repository
public interface StratToProductRepo extends JpaRepository<StratToProduct, StratToComponentPK>{
	
	@Modifying
	@Query(value="Delete from strat_to_product where strat_id=?1",nativeQuery=true)
	void deleteAllByStratId(int stratId);

}

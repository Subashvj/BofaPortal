package com.pointel.bofa.strategy.portal.app.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ImpactedProducts;



@Repository
public interface ImpactedProductsRepo extends JpaRepository<ImpactedProducts, String> {
	
	@Query(value = "select products.product_name from strat_to_product"
			+ " inner join products on strat_to_product.product_id = products.product_id"
			+ " where strat_to_product.strat_id = ?1",  nativeQuery = true)
	public List<ImpactedProducts> getProduct(int strat_id);

}

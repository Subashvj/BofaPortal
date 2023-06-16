package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.InstallProductInfo;
@Repository
public interface InstallProductRepository extends JpaRepository<InstallProductInfo, Integer>{
	@Query(value = "select products.product_name,\r\n"
			+ "count(strat_to_product.product_id) as tot from strat_to_install\r\n"
			+ "inner join strat_to_product on strat_to_install.strat_id = strat_to_product.strat_id\r\n"
			+ "inner join products on strat_to_product.product_id = products.product_id\r\n"
			+ "where strat_to_install.install_id = 1 group by product_name\r\n"
			+ "order by count(strat_to_product.product_id) desc", nativeQuery = true)
	List<InstallProductInfo> productInfos(int installId);

}

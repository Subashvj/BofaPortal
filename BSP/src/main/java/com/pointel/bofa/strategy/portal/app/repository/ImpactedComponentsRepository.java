package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
@Repository
public interface ImpactedComponentsRepository extends JpaRepository<ImpactedComponentsEditInfo, Integer> {
	@Query(value="select products.product_id, products.product_name, incl\r\n"
			+ "from products\r\n"
			+ "left join ( select '1' as incl, strat_to_product.product_id from strat_to_product\r\n"
			+ "where strat_to_product.strat_id = ?1 \r\n"
			+ ")b on   products.product_id = b.product_id\r\n"
			+ "where products.product_visible = 1 order by products.product_name asc", nativeQuery = true)
	List<ImpactedComponentsEditInfo> impactedComponentsEditInfos (int stratId);

}

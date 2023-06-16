package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanning;
import com.pointel.bofa.strategy.portal.app.entity.CtiPlanningPk;
@Repository
public interface CtiPlanningRepo extends JpaRepository<CtiPlanning, CtiPlanningPk> {
	
	
	@Query(value="select * from CTI_PLANNING where STRAT_ID =?1 and CTI_MONTH =?2  and CTI_YEAR=?3 and ESTIMATE_GRP=?4",nativeQuery = true)
	CtiPlanning checkCtiPlanning(int stratId,int ctiMonth,int ctiYear,int estimateGrp);
	
	@Modifying
	@Query(value="Delete from CTI_PLANNING where STRAT_ID =?1 and CTI_MONTH =?2  and CTI_YEAR=?3 and ESTIMATE_GRP=?4",nativeQuery = true)
	void deleteCtiPlanning(int stratId,int ctiMonth,int ctiYear,int estimateGrp);
	

}

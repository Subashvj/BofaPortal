package com.pointel.bofa.strategy.portal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.dto.Milestones;

public interface MileStoneRepo extends JpaRepository<Milestones, Integer> {
	
	
	@Query(nativeQuery = true,value = "SELECT s.* FROM "
			+ "( SELECT to_number('SIZING') as inst_mile_id,to_char('SIZING DUE') as milestone_desc, "
			+ "to_char(strategies1.sizing_due, 'mm/dd') AS start_date, "
			+ "to_char(strategies1.sizing_due, 'mm/dd') AS end_date, "
			+ "strategies1.sizing_due AS sd,strategies1.sizing_due AS ed, "
			+ "to_number('1111') as install_id FROM strategies1 "
			+ "WHERE strategies1.strat_id = ?1 "
			+ "AND strategies1.sizing_due IS NOT NULL "
			+ "AND strategies1.sizing_due >= SYSTIMESTAMP - INTERVAL '60' DAY "
			+ "UNION ALL SELECT to_number('PIR85') as inst_mile_id, "
			+ "to_char('PIR 85% DUE') as milestone_desc, to_char( strategies1.pir_85_due, 'mm/dd') AS start_date,"
			+ " to_char( strategies1.pir_85_due, 'mm/dd') AS end_date, strategies1.pir_85_due AS sd, "
			+ "strategies1.pir_85_due AS ed, to_number('1111') as install_id FROM strategies1 "
			+ "WHERE strategies1.strat_id = ?1 "
			+ "AND strategies1.pir_85_due IS NOT NULL "
			+ "AND strategies1.pir_85_due >= SYSTIMESTAMP - INTERVAL '60' DAY "
			+ "UNION ALL SELECT to_number('PIR100') as inst_mile_id, to_char('PIR 100% DUE') as milestone_desc,"
			+ " to_char( strategies1.pir_100_due, 'mm/dd') AS start_date, "
			+ "to_char( strategies1.pir_100_due, 'mm/dd') AS end_date, "
			+ "strategies1.pir_100_due AS sd, strategies1.pir_100_due AS ed, "
			+ "to_number('1111') as install_id FROM strategies1 "
			+ "WHERE strategies1.strat_id = ?1 "
			+ "AND strategies1.pir_100_due IS NOT NULL "
			+ "AND strategies1.pir_100_due >= SYSTIMESTAMP - INTERVAL '60' DAY "
			+ "UNION ALL SELECT to_number('SWAG') as inst_mile_id, to_char('SWAG DUE') as milestone_desc,"
			+ " to_char( strategies1.swag_due, 'mm/dd') AS start_date, "
			+ "to_char( strategies1.swag_due, 'mm/dd') AS end_date, "
			+ "strategies1.swag_due AS sd, strategies1.swag_due AS ed, "
			+ "to_number('1111') as install_id FROM strategies1 "
			+ "WHERE strategies1.strat_id = ?1 "
			+ "AND strategies1.swag_due IS NOT NULL "
			+ "AND strategies1.swag_due >= SYSTIMESTAMP - INTERVAL '60' DAY "
			+ "UNION ALL SELECT to_number('PROJ') as inst_mile_id, "
			+ "to_char(strat_tasks.task_desc) as milestone_desc, "
			+ "to_char(strat_tasks.task_start, 'mm/dd') AS start_date,"
			+ " to_char(strat_tasks.task_due, 'mm/dd') AS end_date, "
			+ "strat_tasks.task_start AS sd, "
			+ "strat_tasks.task_due AS ed, to_number('2222') as install_id FROM strat_tasks "
			+ "WHERE strat_tasks.strat_id = ?1"
			+ " AND strat_tasks.milestone_id > 0 "
			+ "AND strat_tasks.milestone_id <> 23 "
			+ "AND strat_tasks.task_due >= SYSTIMESTAMP - INTERVAL '60' DAY "
			+ "UNION ALL select distinct install_milestones.inst_mile_id, inst_milestone_types.milestone_desc, "
			+ "to_char(install_milestones.start_date, 'mm/dd') AS start_date, "
			+ "to_char(install_milestones.end_date, 'mm/dd') AS end_date, "
			+ "install_milestones.start_date as sd, install_milestones.end_date as ed,"
			+ " install_milestones.install_id from install_milestones "
			+ "inner join inst_milestone_types on "
			+ "install_milestones.inst_milestone_type_id = inst_milestone_types.inst_milestone_type_id "
			+ "inner join strat_to_install on install_milestones.install_id = strat_to_install.install_id "
			+ "where strat_to_install.strat_id = ?1 "
			+ "and install_milestones.end_date >= SYSTIMESTAMP - INTERVAL '60' DAY )s order by s.sd, s.ed")
	List<Milestones> retrireveMileatones(int stratId);


}

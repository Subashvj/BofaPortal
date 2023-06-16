package com.pointel.bofa.strategy.portal.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.dto.MyTaskInfo;
import com.pointel.bofa.strategy.portal.app.entity.StratTasks;

@Repository
public interface StratTasksRepository extends JpaRepository<StratTasks, BigInteger>{
	
}

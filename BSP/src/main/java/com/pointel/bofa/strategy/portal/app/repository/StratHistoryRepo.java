package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.StratHistory;

@Repository
public interface StratHistoryRepo extends JpaRepository<StratHistory, Integer>{

}

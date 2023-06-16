package com.pointel.bofa.strategy.portal.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.entity.Strategies;

public interface StrategiesRepository extends JpaRepository<Strategies, Integer>{

	public Strategies findByStratId(int stratId);

}

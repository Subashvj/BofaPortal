package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.Strategies2;

@Repository
public interface Strategies2Repo extends JpaRepository<Strategies2, Integer>{

	public Strategies2 findByStratId(int stratId);

}

package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.Strategies1;

@Repository
public interface Strategies1Repo extends JpaRepository<Strategies1, Integer>{
	public Strategies1 findByStratId(int stratId);

}

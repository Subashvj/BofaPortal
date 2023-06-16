package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointel.bofa.strategy.portal.app.entity.InstallHistory;


@Repository
public interface InstallHistoryRepo extends JpaRepository<InstallHistory,Integer>{


}

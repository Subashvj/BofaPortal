package com.pointel.bofa.strategy.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointel.bofa.strategy.portal.app.entity.Attachments;

public interface AttachmentsRepo extends JpaRepository<Attachments, Integer> {
	
}

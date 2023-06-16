package com.pointel.bofa.strategy.portal.app.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.pointel.bofa.strategy.portal.app.entity.Attachments;
import com.pointel.bofa.strategy.portal.app.repository.AttachmentsRepo;


@Repository
public class FileAndLinkDao {
	
	public static Logger logger = LogManager.getLogger(FileAndLinkDao.class);
	
	@Autowired
	AttachmentsRepo attachmentsRepo;
	
	public int saveLinkRequest(Attachments attachments) {
		System.out.println("dao  "+attachments.toString());
		logger.info("Entered into FileAndLinkDao saveLinkRequest");
		logger.info("input data "+attachments.toString());
		Attachments attachmentsRes = attachmentsRepo.save(attachments);
		logger.info("LinkRequest fileAttId "+attachmentsRes.getFileAttId());
		return attachmentsRes.getFileAttId();
	}

	public int saveFileAttachments(Attachments attachments) {
		
		logger.info("Entered into FileAndLinkDao saveFileAttachments");
		logger.info("input data "+attachments.toString());
		Attachments attachmentsRes = attachmentsRepo.save(attachments);
		logger.info("saveFileAttachments fileAttId "+attachmentsRes.getFileAttId());
		return attachmentsRes.getFileAttId();
		
		
		
	}

}

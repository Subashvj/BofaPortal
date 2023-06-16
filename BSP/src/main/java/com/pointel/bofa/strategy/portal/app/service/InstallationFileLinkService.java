package com.pointel.bofa.strategy.portal.app.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.entity.AddComment;
import com.pointel.bofa.strategy.portal.app.entity.InstallationFileLink;
import com.pointel.bofa.strategy.portal.app.dto.RequestCommentData;
import com.pointel.bofa.strategy.portal.app.dto.RequestInstallationFileLink;
import com.pointel.bofa.strategy.portal.app.repository.InstallationFileLinkRepository;
import com.pointel.bofa.strategy.portal.app.util.ResponseMessage;

@Service
public class InstallationFileLinkService {

	public static Logger logger = LogManager.getLogger(InstallationFileLinkService.class);
	@Value("${userid}")
	private String userId; 
	
	@Autowired
	InstallationFileLinkRepository installationFileLinkRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Transactional
	public ResponseMessage addFileLink(RequestInstallationFileLink requestInstallationFileLink) throws Exception{
		logger.info("[BSP]:addFileLink() - Service Insertion Process Started");
		InstallationFileLink installationFileLink = new InstallationFileLink();
		installationFileLink.setTypeId(requestInstallationFileLink.getTypeId());
		installationFileLink.setFileDesc(requestInstallationFileLink.getFileDesc());
		installationFileLink.setLink(requestInstallationFileLink.getFileLink());
		installationFileLink.setAddedBy(userId);
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		installationFileLink.setAddedDate(sqldate);
		installationFileLink.setFileType(2);
		installationFileLink.setFileVisible(1);
		installationFileLink.setFileName("test");
		installationFileLink.setLocked(1);
		installationFileLink.setFolderId(1);
		installationFileLink.setArtifactId(1);
		installationFileLink.setServerFilename("test");
		installationFileLinkRepository.save(installationFileLink);
		responseMessage.setSuccess(true);
		logger.info("[BSP]:addFileLink() - Service Insertion Process Ended");
		return responseMessage;	
	}
}

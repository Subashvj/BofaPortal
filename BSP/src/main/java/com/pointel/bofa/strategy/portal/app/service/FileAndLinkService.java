package com.pointel.bofa.strategy.portal.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.pointel.bofa.strategy.portal.app.dto.AttachmentsDto;
import com.pointel.bofa.strategy.portal.app.dto.FileAttachments;
import com.pointel.bofa.strategy.portal.app.entity.Attachments;

public interface FileAndLinkService {
	
	public int saveLinkRequest(AttachmentsDto attachments) throws Exception;
	public String saveFile(MultipartFile file,FileAttachments fileAttachments) throws Exception;

}

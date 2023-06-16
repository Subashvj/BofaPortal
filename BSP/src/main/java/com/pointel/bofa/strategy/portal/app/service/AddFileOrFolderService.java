package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dao.AddFileOrFolderDao;
import com.pointel.bofa.strategy.portal.app.dto.AddFileOrFolder;

@Service
public class AddFileOrFolderService {
	public static Logger logger = LogManager.getLogger(AddFileOrFolderService.class);
	
	@Autowired
	AddFileOrFolderDao addFileOrFolderDao;
	
	public List<AddFileOrFolder> getAddFileOrFolder(){
		logger.info("Entered into AddFileOrFolderService getAddFileOrFolder");
		List<AddFileOrFolder> result = addFileOrFolderDao.getAddFileOrFolder();
		logger.info("Result from getAddFileOrFolder  "+result.toString());
		return result;
	}
		
		public List<AddFileOrFolder> getAddFileOrFolderSuggestion(String keyword){
			
			logger.info("Entered into AddFileOrFolderDao getAddFileOrFolderSuggestion");
			
			List<AddFileOrFolder> result=addFileOrFolderDao.getAddFileOrFolderSuggestion(keyword.toLowerCase());
			logger.info("Result from getAddFileOrFolderSuggestion "+result.toString());
			return result;
		}
		
		
	

}

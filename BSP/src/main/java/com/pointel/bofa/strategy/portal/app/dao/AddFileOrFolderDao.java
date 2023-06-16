package com.pointel.bofa.strategy.portal.app.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pointel.bofa.strategy.portal.app.dto.AddFileOrFolder;
import com.pointel.bofa.strategy.portal.app.repository.AddFileOrFolderRepo;


@Component
public class AddFileOrFolderDao {
	
	public static Logger logger = LogManager.getLogger(AddFileOrFolderDao.class);
	
	@Autowired
	AddFileOrFolderRepo addFileOrFolderRepo;
	
	public List<AddFileOrFolder> getAddFileOrFolder(){
		
		logger.info("Entered into AddFileOrFolderDao getAddFileOrFolder");
		List<AddFileOrFolder> result=addFileOrFolderRepo.getAddFileOrFolder();
		logger.info("Result from getAddFileOrFolder "+result.toString());
		return result;
	}
	
	
	public List<AddFileOrFolder> getAddFileOrFolderSuggestion(String keyword){
		
		logger.info("Entered into AddFileOrFolderDao getAddFileOrFolderSuggestion");
		List<AddFileOrFolder> result=addFileOrFolderRepo.getAddFileOrFolderSuggestion(keyword);
		logger.info("Result from getAddFileOrFolderSuggestion "+result.toString());
		return result;
	}

}

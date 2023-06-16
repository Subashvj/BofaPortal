package com.pointel.bofa.strategy.portal.app.service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dao.FileAndLinkDao;
import com.pointel.bofa.strategy.portal.app.dto.AssignedUser;
import com.pointel.bofa.strategy.portal.app.dto.AttachmentsDto;
import com.pointel.bofa.strategy.portal.app.dto.FileAttachments;
import com.pointel.bofa.strategy.portal.app.entity.Attachments;
import com.pointel.bofa.strategy.portal.app.repository.AssignedUserRepo;

@Service
public class FileAndLinkServiceImpl implements FileAndLinkService {
	
	public static Logger logger = LogManager.getLogger(FileAndLinkServiceImpl.class);
	
	@Autowired
	FileAndLinkDao fileAndLinkDao;
	
//	@Autowired
//	Attachments attachments;
	
//  @Autowired
//	PropertiesConfig config;
	
	@Autowired
	AssignedUserRepo assignedUserRepo;
	
	@Autowired
	JavaMailSender javaMailSender;
//	
//	@Autowired
//	PropertiesConfig propertiesConfig;
	
	private Path dirLocation = null;
	
	@Value("${fileLocation}")
	private String destinationFileLocation;
	
	@Value("${userid}")
	private String userId;

	@Override
	public int saveLinkRequest(AttachmentsDto attachmentsDto) throws Exception {
		System.out.println("service "+attachmentsDto.toString());
		logger.info("Entered into FileAndLinkServiceImpl saveLinkRequest");
		logger.info("input data "+attachmentsDto.toString());
		
		Date date = new Date();
		java.sql.Date currentDateTime = new java.sql.Date(date.getTime());    
	    System.out.println("current Date Time "+currentDateTime);   
	    attachmentsDto.setAdded(currentDateTime);
		logger.info("current date  "+currentDateTime);
		
		attachmentsDto.setUserId(userId);
	    
	    
	    //Entity start
		Attachments attachments = new Attachments();    
		
		
		attachments.setAddedDate(attachmentsDto.getAdded());
		attachments.setAttatchType(attachmentsDto.getAttatchType());
		attachments.setFileDesc(attachmentsDto.getFileDesc());
		attachments.setLink(attachmentsDto.getFileLink());
		attachments.setFolderId(attachmentsDto.getFolderId());
		attachments.setTypeId(attachmentsDto.getStratId());
		attachments.setAddedBy(attachmentsDto.getUserId());
		attachments.setFileVisible(attachmentsDto.getVisible());
		
		System.out.println("Attachments entity "+new ObjectMapper().writeValueAsString(attachments));
		
	    
	    //Entity end
		
		
		int filetAttId = fileAndLinkDao.saveLinkRequest(attachments);
		logger.info("FiltAttId "+filetAttId);
		return filetAttId;
	}

	@Override
	public String saveFile(MultipartFile file,FileAttachments fileAttachments) throws Exception {
		
		logger.info("Entered into FileAndLinkController saveFile");
		logger.info("input data "+fileAttachments.toString());
		
			Date date = new Date();
			java.sql.Date currentDateTime = new java.sql.Date(date.getTime());    
		    System.out.println("current Date Time "+currentDateTime);   
		    fileAttachments.setAdded(currentDateTime);
			logger.info("current date  "+currentDateTime);
			
			fileAttachments.setUserId(userId);
		
		Attachments attachments = new Attachments();
		
		attachments.setAddedDate(fileAttachments.getAdded());
		attachments.setAttatchType(fileAttachments.getAttatchType());
		attachments.setFileDesc(fileAttachments.getFileDesc());
		attachments.setLink(fileAttachments.getFileLink());
		attachments.setFileName(fileAttachments.getFileName());
		attachments.setFolderId(fileAttachments.getFolderId());
		attachments.setTypeId(fileAttachments.getStratId());
		attachments.setAddedBy(fileAttachments.getUserId());
		attachments.setFileVisible(fileAttachments.getVisible());
		
		logger.info("Attachments Data "+attachments.toString());
		
		int fileAttId = fileAndLinkDao.saveFileAttachments(attachments);
		
		logger.info("Attachments fileAttId "+fileAttId);
		
		List<AssignedUser> result  =assignedUserRepo.retrieveAssignedUser(attachments.getTypeId());
		
		logger.info("Attachments AssignedUser result "+result.toString());
		if(result.size() > 0) {
			
			logger.info("Result not equal 0");
			int noOfPeopleSubscribed = result.size();
			String[] toEmailAddress = new String[noOfPeopleSubscribed];
			int inc = 0;
			for (AssignedUser assignedUser : result) {
				toEmailAddress[inc] = assignedUser.geteMail();
				inc++;
			}
			System.out.println("array List "+toEmailAddress.toString());
			logger.info("array List "+new ObjectMapper().writeValueAsString(toEmailAddress));
			
			System.out.println("array List new "+new ObjectMapper().writeValueAsString(toEmailAddress));
			
			
			System.out.println("result "+new ObjectMapper().writeValueAsString(result));
			System.out.println("result not equal to 0 ");
			
			String subject = "Supporting documents added to project "+attachments.getTypeId();
			
			System.out.println("subject "+subject);
			
			String body = "A file "+attachments.getFileDesc()+" - "+attachments.getFileName()+" was added to project "+attachments.getTypeId();
			
			logger.info("Subject "+subject);
			logger.info("body "+body);
			
			System.out.println("body "+body);
			//email start
			
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(userId);  
			
			messageHelper.setSubject(subject);
			//taskToEmail = "aravindjack4453@gmail.com"; //sample data
			messageHelper.setTo(toEmailAddress);
			//messageHelper.addCc();
			messageHelper.setText(body, true); 
			javaMailSender.send(mimeMessage);
			
			//email end .
			
			
		}
		
		 this.dirLocation =  Paths.get(destinationFileLocation)   
                 .toAbsolutePath()
                .normalize();
		 
		 //If the directory not exist create the directory.
		 File theDir = new File(this.dirLocation.toString());
			if (!theDir.exists()){
			    theDir.mkdirs();
			}

         // TODO Auto-generated method stub
         try {
             String fileName = file.getOriginalFilename();
             Path dfile = this.dirLocation.resolve(fileName);
             Files.copy(file.getInputStream(), dfile,StandardCopyOption.REPLACE_EXISTING);
             logger.info("file name "+fileName);
             logger.info("file saved successfully ");
             return fileName;
             
         } catch (Exception e) {
        	 logger.error("Error occured saved to file .");
             throw new RuntimeException("Could not upload file");
         }
	}

}

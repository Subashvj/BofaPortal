package com.pointel.bofa.strategy.portal.app.service;

import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointel.bofa.strategy.portal.app.dao.TaskDao;
import com.pointel.bofa.strategy.portal.app.dto.AssignedUser;
import com.pointel.bofa.strategy.portal.app.dto.EditTaskDto;
import com.pointel.bofa.strategy.portal.app.dto.StrategiesInfo;
import com.pointel.bofa.strategy.portal.app.dto.TaskBean;
import com.pointel.bofa.strategy.portal.app.dto.MasterData;
import com.pointel.bofa.strategy.portal.app.entity.StratTasks;
import com.pointel.bofa.strategy.portal.app.repository.AssignedUserRepo;
import com.pointel.bofa.strategy.portal.app.repository.StrategiesInfoRepo;

import lombok.experimental.UtilityClass;

@Service
public class TaskServiceImpl implements TaskService {
	
	public static Logger logger = LogManager.getLogger(TaskService.class);
//	
//	@Autowired
//	PropertiesConfig propertiesConfig;
//	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	AssignedUserRepo assignUserRepo;
	
	@Autowired
	StrategiesInfoRepo strategiesInfoRepo;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmailId;
	
	@Value("${userid}")
	private String userId;
	
	@Bean
	private StratTasks getStratTasks() {
		return new StratTasks();
	}

	@Override
	public BigInteger saveTask(StratTasks stratTask) throws Exception {
		
		logger.info("Entered into TaskServiceImpl saveTask input data :"+stratTask.toString());
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();  
	    System.out.println(formatter.format(date));
	    String currentDateTime = formatter.format(date);
		stratTask.setAddDate(currentDateTime);
		
		stratTask.setAssignedBy(userId); 

		
		
		Date d1 = stratTask.getTaskStrat();
		Date d2 = stratTask.getTaskDue();
		if(d1.compareTo(d2)>0) {
			stratTask.setTaskStrat(d2);
		}
		BigInteger taskId = taskDao.saveTask(stratTask);
		logger.info("Task id from saveTask "+taskId);
		// Start Email part
		
		String assignTo = stratTask.getAssignedTo(); 
		//String assignTo = "aaa"; sample data
		String assignby = userId;
		int stratId = stratTask.getStratId();
		//int stratId = 7031;  sample data
		if(taskId!=null) {
			System.out.println("entered email ");
			if(assignTo!=assignby) {
				logger.info("task asign to not equal to user id :");
				logger.info("Assign to "+assignTo);
				logger.info("Assign by "+assignby);
				
				System.out.println("userid assignto not equal ");
				
				String subject = "";
				String task_ccName = "";
				String task_ccEmail = "";
				String taskToName = "";
				String taskToEmail = "";
				
				List<StrategiesInfo> strategiesInfoRes = strategiesInfoRepo.retrieveStrategiesInfo(stratId);

				if(strategiesInfoRes.size() > 0) {
				
					logger.info("StrategiesInfoRes Result  "+new ObjectMapper().writeValueAsString(strategiesInfoRes));
				String stratName = strategiesInfoRes.get(0).getStratName();
				
				subject = "New task assigned to you on project "+stratId+" : "+stratName;
				
				logger.info("Email subject "+subject);
				
				System.out.println("StrategiesInfoRes result "+new ObjectMapper().writeValueAsString(strategiesInfoRes));
				}
				
				
				
				
				//Assign to List
			List<AssignedUser> assignToResult = assignUserRepo.retrirveAssignUser(assignTo);
			
			logger.info("assignToResult result "+new ObjectMapper().writeValueAsString(assignToResult));
			int noOfPeopleSubscribed = assignToResult.size();
			String[] toEmailAddress = new String[noOfPeopleSubscribed];
			int inc = 0;
			for (AssignedUser assignedUser : assignToResult) {
				toEmailAddress[inc] = assignedUser.geteMail();
				inc++;
			}
			
			System.out.println("to mail "+new ObjectMapper().writeValueAsString(toEmailAddress));

			
			//Assign By
			List<AssignedUser> assignByResult = assignUserRepo.retrirveAssignUser(assignby);
			logger.info("AssignByResult result "+new ObjectMapper().writeValueAsString(assignByResult));
			if(assignByResult.size() > 0) {
			
				
			System.out.println("assignByResult result "+new ObjectMapper().writeValueAsString(assignByResult));
			
			 task_ccName = assignByResult.get(0).getDisplayName();
			 task_ccEmail = assignByResult.get(0).geteMail();
			 
			 System.out.println("ccmail "+task_ccEmail);
			
			}

			String body = "http://localhost/project/email_templates/email_task_assignmnent.php?task_id = "+taskId;
			
			logger.info("Email body "+body);
			
			//String ccName = task_ccName;
			//String ccMail = task_ccEmail;
			
			
			
			
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(fromEmailId);  
			
			messageHelper.setSubject(subject);
			//taskToEmail = "aravindjack4453@gmail.com"; sample data
			messageHelper.setTo(toEmailAddress);
			messageHelper.addCc(task_ccEmail);
			messageHelper.setText(body, true); 
			FileSystemResource res = new FileSystemResource(new File("src/main/resources/static/images/boa.png"));
			messageHelper.addInline("boaImg", res);
			messageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			
			
			
				
			}
		}
		
		
		return taskId;
	}

	@Override
	public BigInteger editTask(EditTaskDto startTask) throws Exception {
		logger.info("Entered into TaskServiceImpl editTask input data :"+startTask.toString());
		
		
		boolean sendEmail = false;
		boolean assignedEmail = false;
		String editUser = userId;
		Date startDate= startTask.getTaskStrat();
		Date endDate = startTask.getTaskDue();
		
		if(startDate.compareTo(endDate)>0) {
			startDate = null;
			startTask.setTaskStrat(startDate);
		}
		
		if(startTask.getTaskStatusId()!=5) {
			logger.info("Task status id in not equal to 5 :");
			if(startTask.getTaskPercent()==100||startTask.getTaskStatusId()==4) {
				logger.info("Task percent is 100 and Task status id id 4 :");
				startTask.setTaskPercent(100);
				startTask.setTaskStatusId(4);
				if(startTask.getMileStoneId()>0) {
					sendEmail = true;
					logger.info("sendEmail set into true  :");
				}
			}
			
			if((startTask.getTaskPercent() > 0&&startTask.getTaskPercent() < 100 ) && (startTask.getTaskStatusId()!= 2 &&startTask.getTaskStatusId()!= 3&&startTask.getTaskStatusId()!= 5)) {
				logger.info("Task status id set into 2 :");
				startTask.setTaskStatusId(2);
			}
			if(startTask.getTaskPercent()==0||startTask.getTaskStatusId()==1) {
				
				startTask.setTaskPercent(0);
				startTask.setTaskStatusId(1);
				
				logger.info("Task percent set into 0 :");
				logger.info("Task status id set into 1 :");
			}
		}
	String assignToUser =	startTask.getCurrentAssign();
	String newAssign = startTask.getCurrentAssignBy();
	String reAssign = startTask.getAssignedTo();  
	if(!"0".equals(reAssign) && !assignToUser.equals(reAssign)) {
		assignToUser = reAssign;
		newAssign = editUser;
		assignedEmail = true;
		startTask.setCurrentAssign(assignToUser);
		startTask.setCurrentAssignBy(newAssign);
		
		logger.info("assignedEmail set into true  :");
	}
	
	
	
	System.out.println("strat task id "+startTask.getTaskStatusId());
	
	StratTasks stratTasksBean = getStratTasks();
	stratTasksBean.setTaskId(startTask.getTaskId());
	stratTasksBean.setTaskStrat(startTask.getTaskStrat());
	stratTasksBean.setTaskDue(startTask.getTaskDue());
	stratTasksBean.setTaskPercent(startTask.getTaskPercent());
	stratTasksBean.setTaskStatusId(startTask.getTaskStatusId());
	stratTasksBean.setMileStoneId(startTask.getMileStoneId());
	stratTasksBean.setStratPhaseId(startTask.getStratPhaseId());
	stratTasksBean.setTaskNotes(startTask.getTaskNotes());
	
	System.out.println("Updated entity " + new ObjectMapper().writeValueAsString(stratTasksBean));
	logger.info("Updated entity " +stratTasksBean.toString());
	
	BigInteger id =	taskDao.editTask(stratTasksBean);
	logger.info("result from editTask "+id);
		return id;
	}

	@Override
	public MasterData getMasterData() throws JsonProcessingException {
		
		logger.info("Entered into TaskServiceImpl getMasterData:");
		
		MasterData masterData = taskDao.getMasterData();
		logger.info("Result from getMasterData :"+masterData.toString());
		return masterData;
	}

	@Override
	public List<TaskBean> getTask(int stratId) throws Exception {
		logger.info("Entered into TaskServiceImpl getTask:");
		List<TaskBean>  result = taskDao.getTask(stratId);
		logger.info("Result from getTask : "+result.toString());
		return result;
	}



}

















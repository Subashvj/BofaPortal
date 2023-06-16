package com.pointel.bofa.strategy.portal.app;


import static org.junit.jupiter.api.Assertions.assertEquals;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pointel.bofa.strategy.portal.app.dto.MyProjectInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyTaskInfo;

import com.pointel.bofa.strategy.portal.app.dto.MyTeamTaskInfo;
import com.pointel.bofa.strategy.portal.app.dto.MyWeeksAllocationInfo;
import com.pointel.bofa.strategy.portal.app.dto.NewestProjectInfo;

import com.pointel.bofa.strategy.portal.app.dto.ProjectListInfo;
import com.pointel.bofa.strategy.portal.app.dto.UpComingInstallationInfo;
import com.pointel.bofa.strategy.portal.app.entity.TestTable;
import com.pointel.bofa.strategy.portal.app.repository.MyProjectInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyTaskInfoRepository;

import com.pointel.bofa.strategy.portal.app.repository.MyTeamTaskInfoRepository;
import com.pointel.bofa.strategy.portal.app.repository.MyWeeksAllocationInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.NewestProjectInfoRepo;

import com.pointel.bofa.strategy.portal.app.repository.ProjectListInfoRepo;
import com.pointel.bofa.strategy.portal.app.repository.TestTableRepo;
import com.pointel.bofa.strategy.portal.app.repository.UpComingInstallationInfoRepo;



@SpringBootTest
class BofaStrategyPortalApplicationTests {

	
	
	@Autowired
	MyTaskInfoRepository myTaskInfoRepository;
	
	@Autowired
	UpComingInstallationInfoRepo upComingInstallationInfoRepo;
	
    @Autowired 
    MyWeeksAllocationInfoRepo myWeeksAllocationInfoRepo;
	
    @Autowired
    MyProjectInfoRepository myProjectInfoRepository;
    
    @Autowired
    MyTeamTaskInfoRepository myTeamTaskInfoRepository;
    
    
    @Autowired
    NewestProjectInfoRepo newestProjectInfoRepo;
    
    
    
    @Autowired
    ProjectListInfoRepo projectListInfoRepo;
    
    @PersistenceContext
	private EntityManager entityManager;
	
    
	//@Test
	@Disabled //no
	void myTaskInfo() {
		 
		
		List<MyTaskInfo> myTaskInfoList = myTaskInfoRepository.getMyTaskInfo("aaa");
		
		for(MyTaskInfo myTaskInf:myTaskInfoList) {
			
			System.out.println(myTaskInf.toString());
		}
		
		
	}
	
	//@Test
    @Disabled //working 1
	void newestProjects() {
	
		
        List<NewestProjectInfo> newestProjectInfoList = newestProjectInfoRepo.getNewestProjectInfo();
		
        for(NewestProjectInfo newestProjectInfo:newestProjectInfoList) {
			
			System.out.println(newestProjectInfo.toString());
		}
		
	}
	
	
	//@Test
	@Disabled
	void upComingInstallation() {
		
    	
		List<UpComingInstallationInfo> upComingInstallationInfoList = upComingInstallationInfoRepo.getUpComingInsatallations();
		
        for(UpComingInstallationInfo upComingInstallationInfo:upComingInstallationInfoList) {
			
			System.out.println(upComingInstallationInfo.toString());
		}
		
	}
	
	//@Test
	@Disabled  //working 2
	void myTeamTask() {
		
    	       List<MyTeamTaskInfo> myTeamTaskInfoList = null;
		       myTeamTaskInfoList = myTeamTaskInfoRepository.retriveMyTeamTask("test", null);
				
				for(MyTeamTaskInfo myTeamTaskInfo:myTeamTaskInfoList) {
							
					  System.out.println(myTeamTaskInfo.toString());
				}
		
	}
	
	//@Test
//	@Disabled //working 3
//	void myWeekAllocation() {
//			
//		List<MyWeeksAllocationInfo> myWeeksAllocationInfoList = myWeeksAllocationInfoRepo.retriveMyWeeksAllocationInfo("bbb",new Date(2022-02-01));
//		for(MyWeeksAllocationInfo myWeeksAllocationInfo:myWeeksAllocationInfoList) {
//			
//			  System.out.println(myWeeksAllocationInfo.toString());
//		}
//		
//		
//	}
	
	/*
	 * //@Test
	 * 
	 * @Disabled //working 4 void myTeamProject() {
	 * 
	 * List<MyTeamProjectInfo> trial =
	 * myTeamProjectInfoRepository.retriveMyTeamProjects("test");
	 * 
	 * System.out.println(trial.size());
	 * 
	 * for(MyTeamProjectInfo myTeamProjectInfo:trial) {
	 * 
	 * System.out.println(myTeamProjectInfo.toString()); } }
	 */
	
	//@Test
	@Disabled //working 5
	void myProjectInfo() {
		
		
        List<MyProjectInfo> trial = myProjectInfoRepository.retriveMyProjectInfo("aaa");
		
		System.out.println(trial.size());
		
		for(MyProjectInfo myProjectInfo:trial) {
			
			System.out.println(myProjectInfo.toString());
		}
	}
	
	
	/*
	 * //@Test public void mailTest() throws Exception {
	 * 
	 * List<PeopleSubscribedInfo> peopSubInfoList= new ArrayList<>();
	 * PeopleSubscribedInfo peopleSubscribedInfo= new PeopleSubscribedInfo();
	 * peopleSubscribedInfo.setEmail("basigadaget@gmail.com"); PeopleSubscribedInfo
	 * peopleSubscribedInfo1= new PeopleSubscribedInfo();
	 * peopleSubscribedInfo1.setEmail("gladybasi@gmail.com");
	 * peopSubInfoList.add(peopleSubscribedInfo);
	 * peopSubInfoList.add(peopleSubscribedInfo1); ProjectDetailsInfo
	 * projectDetailInfo = new ProjectDetailsInfo();
	 * projectDetailInfo.setLobDesc("LOBDESC");
	 * projectDetailInfo.setStratCatdesc("STRATCATDESC");
	 * projectDetailInfo.setStratId(1001);
	 * projectDetailInfo.setStratName("STRATNAME");
	 * projectDetailInfo.setStratObjectives("STRATOBJECTIVES");
	 * Mockito.when(peopleSubscribedInfoRepo.fetchPeopleSubscribedInfo(0)).
	 * thenReturn(peopSubInfoList);
	 * Mockito.when(projectDetailsInfoRepo.fetchProjectDetailsInfo(0)).thenReturn(
	 * projectDetailInfo); assertEquals("Alhamdulillah",
	 * projectService.mailSender(0));
	 * 
	 * }
	 */
	
	//@Test
	public void paginationTest() {
		
		
		//Pageable pageable = PageRequest.of(0,3);
		
		Pageable pageable = PageRequest.of(0,3);
		
		
		List<ProjectListInfo> projectList = projectListInfoRepo.fetchProjDetailStratIdGreaterThan("7031",pageable).getContent();
		
		Long totalElements = projectListInfoRepo.fetchProjectDetails(pageable).getTotalElements();
		
		int totalNoPages = projectListInfoRepo.fetchProjectDetails(pageable).getTotalPages();
		
		System.out.println("result is : "+"totalElements : "+totalElements +"totalPages: "+totalNoPages+" "+projectList);
		
        for(ProjectListInfo p:projectList) {
			
			System.out.println(p.toString());
		}
		
		/*Comparator<ProjectListInfo> comparator = new Comparator<ProjectListInfo>()
		{
			
			public int compare(ProjectListInfo p1,ProjectListInfo p2) {
				if(p1.getStratId()<p2.getStratId())
					return 1;
				else
					return -1;
			}
			
		};
	
		List<ProjectListInfo> projectList1= new ArrayList<>();
		
		for(ProjectListInfo p:projectList) {
			
			projectList1.add(p);
		}
		
		Collections.sort(projectList1,comparator);
		
        for(ProjectListInfo p:projectList1) {
			
			System.out.println(p.toString());
		}
		*/
	}
	@Autowired
	TestTableRepo testTableRepo;
	@Test
	
	public void test_sampletable() {
		TestTable testTable = new TestTable();
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		testTable.setDateColumn(sqldate);
		testTable.setTimestampColumn(sqldate);
		testTable.setId(3);
		testTableRepo.save(testTable);
		
	}
	
	

		
		
	
	

}

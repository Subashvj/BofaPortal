package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pointel.bofa.strategy.portal.app.dao.OverviewInfo;
import com.pointel.bofa.strategy.portal.app.dto.ApprovalsCallInfo;
import com.pointel.bofa.strategy.portal.app.dto.Cti;
import com.pointel.bofa.strategy.portal.app.dto.HistoryInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.ImpactedProducts;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstallation;
import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.LobsInfo;
import com.pointel.bofa.strategy.portal.app.dto.Milestones;
import com.pointel.bofa.strategy.portal.app.dto.NotesDevlopmentInfo;
import com.pointel.bofa.strategy.portal.app.dto.NotesTestInfo;
import com.pointel.bofa.strategy.portal.app.dto.PmInfo;
import com.pointel.bofa.strategy.portal.app.dto.RecommendedMembers;
import com.pointel.bofa.strategy.portal.app.dto.RecursersList;
import com.pointel.bofa.strategy.portal.app.dto.ResourcePlan;
import com.pointel.bofa.strategy.portal.app.dto.Rminfo;
import com.pointel.bofa.strategy.portal.app.dto.ScopeResponse;
import com.pointel.bofa.strategy.portal.app.dto.StatusInfo;
import com.pointel.bofa.strategy.portal.app.dto.StratPhases;
import com.pointel.bofa.strategy.portal.app.dto.TasksInfo;
import com.pointel.bofa.strategy.portal.app.dto.TeamMembers;
import com.pointel.bofa.strategy.portal.app.dto.TechComponents;
import com.pointel.bofa.strategy.portal.app.dto.TechComponentsEditInfo;
import com.pointel.bofa.strategy.portal.app.dto.Typesinfo;
import com.pointel.bofa.strategy.portal.app.error.CustomResponseEntityExceptionHandler;
import com.pointel.bofa.strategy.portal.app.error.ErrorMessage;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.RmInfoRepository;
import com.pointel.bofa.strategy.portal.app.service.ProjectDetailsServiceImple;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectDetailsControllerImple implements ProjectDetailsController{

	private static final Logger logger = LogManager.getLogger(ProjectDetailsControllerImple.class);
	@Autowired
	ProjectDetailsServiceImple projectdetailsServiceImple;
	
	@Autowired
	TraceLogger traceLogger;
	

	@Override
	@GetMapping("/getHistory/{stratId}")
	public ResponseEntity<?> getHistorys(@PathVariable int stratId) throws Exception{
		List<HistoryInfo>  historyInfo = null;
		try {
			logger.info("[BSP]:getHistorys() - Method call started");
			logger.info("input data "+stratId);
			historyInfo = projectdetailsServiceImple.getHistoryInfo(stratId);
			logger.info("Result from getHistorys"+historyInfo);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getHistorys()");
		}
		logger.info("[BSP]:getHistorys() - Method call Ended");
		return  ResponseEntity.ok().body(historyInfo);
	}

	@Override
	@GetMapping("/getRm/{stratId}")
	public ResponseEntity<?> getRm(@PathVariable int stratId) throws Exception {
		// TODO Auto-generated method stub
		List<Rminfo> rminfos =null;
		try {
			logger.info("[BSP]:getRm() - Method call started");
			logger.info("input data "+stratId);
			rminfos = projectdetailsServiceImple.getRmInfo(stratId);
			logger.info("Result from getRm"+rminfos);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getHistorys()");
		}
		logger.info("[BSP]:getHistorys() - Method call  Ended");
		return ResponseEntity.ok().body(rminfos);
	}

	@Override
	@GetMapping("/getOverview/{stratId}")
	public ResponseEntity<?> getoverview(@PathVariable int stratId) throws Exception {
		// TODO Auto-generated method stub
		List<OverviewInfo> overviewInfos= null;
		try {
			logger.info("[BSP]:getRm() - Method call started");
			logger.info("input data "+stratId);			
			overviewInfos= projectdetailsServiceImple.getOverviewInfo(stratId);
			logger.info("Result from getoverview"+overviewInfos);
		}catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getHistorys()");
		}
		logger.info("[BSP]:getHistorys() - Method call  Ended");
		return ResponseEntity.ok().body(overviewInfos);
	}

	@Override
	@GetMapping("/getDevelopmentNotes/{stratId}")
	public ResponseEntity<?> getDevelopmentNotes( int stratId) throws Exception{
		// TODO Auto-generated method stub
		List<NotesDevlopmentInfo> notesDevlopmentInfo = null;
		try {
			logger.info("[BSP]:getRm() - Method call started");
			logger.info("input data "+stratId);
		notesDevlopmentInfo= projectdetailsServiceImple.getDevelopmentNotesInfo(stratId);
		logger.info("Result from getDevelopmentNotes" + notesDevlopmentInfo);
		}catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getNotesDevelopment()");
		}
		logger.info("[BSP]:getHistorys() - Method call  Ended");
		return ResponseEntity.ok().body(notesDevlopmentInfo);
	}

	@Override
	@GetMapping("/getTestNotes/{stratId}")
	public ResponseEntity<?> getTestNotes(int stratId)  throws Exception {
		List<NotesTestInfo> notesTestInfo = null;
		try {
			logger.info("[BSP]:getRm() - Method call started");
			logger.info("input data "+stratId);
			notesTestInfo =projectdetailsServiceImple.getTestNotes(stratId);
			logger.info("Result from getDevelopmentNotes" + notesTestInfo);
		}catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getNotesTest()");
		}
		logger.info("[BSP]:getHistorys() - Method call  Ended");
		return ResponseEntity.ok().body(notesTestInfo);
	}

	//jayakumar
	
	
	@Override
	@GetMapping("/getTasks/{stratId}")
	public ResponseEntity<?> getTasks(@PathVariable int stratId) throws Exception {
		logger.info("[BSP]:getTasks() - getTasks() controller method call Started");
		List<TasksInfo> taskInfo = null;
		try {
			logger.info("input data "+stratId);
			taskInfo  = projectdetailsServiceImple.getTasks(stratId);
			logger.info("Result from getTasks" + taskInfo);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getTasks()");
		}
		logger.info("[BSP]:getTasks() -getTasks() controller method call Started");
		return ResponseEntity.ok().body(taskInfo);
	}
	
	
	@Override
	@GetMapping("/getScope/{stratId}")
	public ResponseEntity<?> getScope(@PathVariable int stratId) throws Exception {
		logger.info("[BSP]:getScope() - getScope() controller method call Started");
		ScopeResponse scopeResponse = null;
		try {
			logger.info("input data "+stratId);
			scopeResponse = projectdetailsServiceImple.getScope(stratId);
			logger.info("Result from getScope" + scopeResponse);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getScope()");
		}
		logger.info("[BSP]:getScope() -getScope() controller method call Started");
		return ResponseEntity.ok().body(scopeResponse);
	}
	
	@Override
	@GetMapping("/getPm/{stratId}/{userId}")
	public ResponseEntity<?> getPm(@PathVariable int stratId,@PathVariable String userId) throws Exception {
		logger.info("[BSP]:getScope() - getPm() controller method call Started");
		List<PmInfo> pmInfo = null;
		try {
			logger.info("input data "+stratId);
			pmInfo = projectdetailsServiceImple.getPm(stratId, userId);
			logger.info("Result from getPm" + pmInfo);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getPm()");
		}
		logger.info("[BSP]:getPm() -getPm() controller method call Ended");
		return ResponseEntity.ok().body(pmInfo);
	}
	
	@Override
	@GetMapping("/getFiles/{typeId}")
	public ResponseEntity<?> getFiles(@PathVariable int typeId) throws Exception{
		logger.info("[BSP]:getFiles() - controller method call Started");
		logger.info("Input TypeId:{}",typeId);
		Map files = null;
		try {
			files = projectdetailsServiceImple.getFiles(typeId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getFiles()");
		}
		logger.info("[BSP]:getFiles() controller method call Ended");
		return ResponseEntity.ok().body(files);		
	}
	
	
	//Aravindh
	
	@GetMapping("/getLinkedIstallation/{stratId}")
	public ResponseEntity<?> getLinkedIstallation(@PathVariable int stratId) {
		logger.info("Entered into ProjectDetailsController getLinkedIstallation");
		logger.info("input data "+stratId);
		try {
		System.out.println("entered ");
		List<LinkedInstallation> result  = projectdetailsServiceImple.getLinkedInstallation(stratId);
		logger.info("Result from getLinkedIstallation "+result);
		return ResponseEntity.ok().body(result);
		}catch(Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getLinkedIstallation");
			return ResponseEntity.ok().body(error);
		}
		
	}
	
	@GetMapping("/getTeamMembers/{stratId}")
	public ResponseEntity<?> getTeamMembers(@PathVariable int stratId){
		logger.info("Entered into ProjectDetailsController getTeamMembers");
		logger.info("input data "+stratId);
		try {
              List<TeamMembers> result  = projectdetailsServiceImple.getTeamMembers(stratId);
              logger.info("Result from getTeamMembers "+result);
              return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getTeamMembers");
			return ResponseEntity.ok().body(error);
		}
		
	}
	
	@GetMapping("/getMileStone/{stratId}")
	public ResponseEntity<?> getMileStones(@PathVariable int stratId){
		logger.info("Entered into ProjectDetailsController getMileStones");
		logger.info("input data "+stratId);
		try {
			List<Milestones> result  = projectdetailsServiceImple.getMileStones(stratId);
			 logger.info("Result from getMileStones "+result);
			 return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getMileStones");
			return ResponseEntity.ok().body(error);
		}
		
	}
	
	//from sasi

	@GetMapping("/getImpactedProduct/{stratId}")
	public ResponseEntity<?> getProduct(@PathVariable int stratId)
	{ 
		logger.info("Entered into ProjectDetailsController getProduct");
		logger.info("input data "+stratId);
		try {
           List<ImpactedProducts> result = projectdetailsServiceImple.getProduct(stratId);
           logger.info("Result from getProduct "+result);
           return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getProduct");
			return ResponseEntity.ok().body(error);
		}
	}
	
	
	@GetMapping("/getTechComponent/{stratId}")
	public ResponseEntity<?> getComponents(@PathVariable int stratId)
	{ 
		logger.info("Entered into ProjectDetailsController getComponents");
		logger.info("input data "+stratId);
		try {
		List<TechComponents> result = projectdetailsServiceImple.getTechComponents(stratId);
		 logger.info("Result from getComponents "+result);
		return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getComponents");
			return ResponseEntity.ok().body(error);
		}
	}
	
	
	@GetMapping("getCti/{strat_id}")
	public ResponseEntity<?> getCti(@PathVariable int strat_id){
		logger.info("Entered into ProjectDetailsController getCti");
		logger.info("Input data strat id"+strat_id);
		try {
			List<Cti> result=projectdetailsServiceImple.getCti(strat_id);
			logger.info("Result from getCti "+result);
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getCti");
			return ResponseEntity.ok().body(error);
		}

	}
	@GetMapping("getResourcePlan/{strat_id}")
	public ResponseEntity<?> getResourcePlan(@PathVariable int strat_id){
		logger.info("Entered into ProjectDetailsController getResourcePlan");
		logger.info("Input data strat id"+strat_id);
		try {
			List<ResourcePlan> result=projectdetailsServiceImple.getResourcePlan(strat_id);
			logger.info("Result from getResourcePlan "+result);
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getResourcePlan");

			return ResponseEntity.ok().body(error);
		}

	}
	@GetMapping("/getRecommendedMembers/{stratId}")
	public ResponseEntity<?> getMembers(@PathVariable int stratId){

		logger.info("Entered into ProjectDetailsController getMembers");
		logger.info("input data "+stratId);
		try {
		List<RecommendedMembers> result = projectdetailsServiceImple.getMembers(stratId);
		 logger.info("Result from getMembers "+result);
		return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			e.printStackTrace();
			ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
			logger.error("Error occured in getMembers");
			return ResponseEntity.ok().body(error);
		}
	}

	
	//end sasi
	
	@GetMapping("/getApprovals/{stratId}")
	public ResponseEntity<?> getApprovals(@PathVariable int stratId){
		logger.info("Entered into ProjectDetailsController getApprovals");
		logger.info("input data "+stratId);
		try {
			List<ApprovalsCallInfo> result = projectdetailsServiceImple.getApprovals(stratId);
			 logger.info("Result from getApprovals "+result);
			return ResponseEntity.ok().body(result);
			}catch (Exception e) {
				e.printStackTrace();
				ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
				logger.error("Error occured in getApprovals");
				return ResponseEntity.ok().body(error);
			}
		
	}
		
	@GetMapping("/getTypes")
	public ResponseEntity<?> getTypes()throws Exception{
		logger.info("Entered into ProjectDetailsController getTypes");	
		try {
			List<Typesinfo> typesinfos = projectdetailsServiceImple.getTypesinfo();
			 logger.info("Result from getTypes "+typesinfos);
			return ResponseEntity.ok().body(typesinfos);
			}catch (Exception e) {
				e.printStackTrace();
				ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
				logger.error("Error occured in getTypes");
				return ResponseEntity.ok().body(error);
			}
		}
	@GetMapping("/getStatusList")
	public ResponseEntity<?> getStatus()throws Exception{
		logger.info("Entered into ProjectDetailsController status");	
		try {
			List<StatusInfo> statusList = projectdetailsServiceImple.getStatusinfo();
			 logger.info("Result from getTypes "+statusList);
			return ResponseEntity.ok().body(statusList);
			}catch (Exception e) {
				e.printStackTrace();
				ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
				logger.error("Error occured in status");
				return ResponseEntity.ok().body(error);
			}

	}
	 @GetMapping("/getPhases")
		public ResponseEntity<?> stratPhases()throws Exception{
			logger.info("Entered into ProjectDetailsController stratPhases");	
			try {
				List<StratPhases> stratPhase = projectdetailsServiceImple.getStratPhasesinfo();
				 logger.info("Result from getTypes "+stratPhase);
				return ResponseEntity.ok().body(stratPhase);
				}catch (Exception e) {
					e.printStackTrace();
					ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
					logger.error("Error occured in stratPhases");
					return ResponseEntity.ok().body(error);
				}
        }
	 
	 @GetMapping("/getLobs")
		public ResponseEntity<?> getLobs()throws Exception{
			logger.info("Entered into ProjectDetailsController stratPhases");	
			try {
				List<LobsInfo> lobsInfo = projectdetailsServiceImple.getLobsList();
				 logger.info("Result from getTypes "+lobsInfo);
				return ResponseEntity.ok().body(lobsInfo);
				}catch (Exception e) {
					e.printStackTrace();
					ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured ");
					logger.error("Error occured in lobsInfo");
					return ResponseEntity.ok().body(error);
				}
        }
	 
		

}
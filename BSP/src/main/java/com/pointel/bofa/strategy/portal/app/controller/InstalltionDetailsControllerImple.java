package com.pointel.bofa.strategy.portal.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pointel.bofa.strategy.portal.app.dto.InstallFilesInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallHistoryInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallLinked;
import com.pointel.bofa.strategy.portal.app.dto.InstallMilestoneInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallProductInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallTechInfo;
import com.pointel.bofa.strategy.portal.app.dto.InstallTypes;
import com.pointel.bofa.strategy.portal.app.dto.InstallationMilestone;
import com.pointel.bofa.strategy.portal.app.dto.InstallationOverview;
import com.pointel.bofa.strategy.portal.app.dto.InstallationTasks;
import com.pointel.bofa.strategy.portal.app.dto.UsersInfo;
import com.pointel.bofa.strategy.portal.app.entity.CabStatus;
import com.pointel.bofa.strategy.portal.app.entity.EstimateGroups;
import com.pointel.bofa.strategy.portal.app.entity.InstallEnvironments;
import com.pointel.bofa.strategy.portal.app.entity.InstallStatuses;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.pagination.InstallationPageService;
import com.pointel.bofa.strategy.portal.app.pagination.PagingRequest;
import com.pointel.bofa.strategy.portal.app.pagination.PagingResponse;
import com.pointel.bofa.strategy.portal.app.service.InstallationDetailsServiceImple;

@RestController
@RequestMapping("/api/v1/installations")
public class InstalltionDetailsControllerImple implements InstallationDetailsController {
	private static final Logger logger = LogManager.getLogger(InstalltionDetailsControllerImple.class);

	@Autowired
	InstallationDetailsServiceImple installationsDetailsServiceImpl;

	@Autowired
	TraceLogger traceLogger;
	
	@Autowired
	InstallationPageService installationPageService;
	
	/*
	 * @Override
	 * 
	 * @GetMapping("/getInstallMilestone/{installId}") public ResponseEntity<?>
	 * getInstallMilestone(int installId) throws Exception {
	 * List<InstallMilestoneInfo> installMilestoneInfos =null; try {
	 * logger.info("[BSP]:getInstallMilestone() - Method call started");
	 * installMilestoneInfos =
	 * installtionDetailsServiceImple.getInstallMilestoneInfo(installId); } catch
	 * (Exception e) { traceLogger.writeStackTrace(e); throw new
	 * FailedToFullfillRequest("Operation Failed","getHistorys()");
	 * 
	 * } return ResponseEntity.ok().body(installMilestoneInfos); }
	 */
	@Override
	@GetMapping("/getIncludedTechComponents/{installId}")
	public ResponseEntity<?> getInstallTech(@PathVariable int installId) throws Exception {
		List<InstallTechInfo> installTechInfos = null;
		try {
			logger.info("[BSP]:getInstallTech() - Method call started");
			installTechInfos = installationsDetailsServiceImpl. getInstallTechInfo(installId);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getInstallTech()");
		}
		return ResponseEntity.ok().body(installTechInfos);
	}

	@Override
	@GetMapping("/getIncludedProducts/{installId}")
	public ResponseEntity<?> getInstallProduct(@PathVariable int installId) throws Exception {
		List<InstallProductInfo> installProductInfos = null;
		try {
			logger.info("[BSP]:getInstallProduct() - Method call started");
			installProductInfos = installationsDetailsServiceImpl.getInstallProductInfo(installId);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getInstallProduct()");
		}
		return  ResponseEntity.ok().body(installProductInfos);
	}
	@GetMapping("/getSupportingFiles/{typeId}")
	public ResponseEntity<?> getInstallFile(@PathVariable int typeId)throws Exception{
		List<InstallFilesInfo> installFilesInfos =null;
		try {
			logger.info("[BSP]:getInstallFile() - Method call started");
			installFilesInfos =installationsDetailsServiceImpl.getInstallFileinfo(typeId);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getInstallFile()");
		}
		return  ResponseEntity.ok().body(installFilesInfos);
		
	}
	@GetMapping("/getProjectMembers/{installId}")
	public ResponseEntity<?> getUsers(@PathVariable int installId) throws Exception{
		List<UsersInfo> usersinfo = null;
		try {
			logger.info("[BSP]:getUsers() - Method call started");
			usersinfo = installationsDetailsServiceImpl.getUsersInfo(installId);
		} catch (Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed","getUsers()");
		}
		return  ResponseEntity.ok().body(usersinfo);
	}
	
	//jayakumar
	@PostMapping(path="/installationList")
	public ResponseEntity<Object> searchInstallationList(@RequestBody PagingRequest request) throws Exception{
		logger.info("[BSP]:searchInstallationList() - method call Started");
		PagingResponse pagingResponse = null;
		try {
			pagingResponse = installationPageService.getInstallationPage(request);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"searchInstallationList()");
		}
		logger.info("[BSP]:searchInstallationList() - method call Ended");
		return new ResponseEntity<>(pagingResponse,HttpStatus.OK);
	}
	
	//jayakumar
	@Override
	@GetMapping("/getInstallationOverview/{installId}")
	public ResponseEntity<?> getInstallationOverview(@PathVariable int installId) throws Exception{
		logger.info("[BSP]:getInstallationOverview() - controller method call Started");
		List<InstallationOverview> installationOverview = null;		
		try {
			 installationOverview = installationsDetailsServiceImpl.getInstallationOverview(installId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationOverview()");
		}
		logger.info("[BSP]:getInstallationOverview() - controller method call Ended");
		return ResponseEntity.ok().body(installationOverview);
	}
	
	@Override
	@GetMapping("/getLinkedInstall/{installId}")
	public ResponseEntity<?> getInstallLinked(@PathVariable int installId) throws Exception{
		logger.info("[BSP]:getInstallLinked() - controller method call Started");
		List<InstallLinked> installLinked = null;	
		try {
			installLinked = installationsDetailsServiceImpl.getInstallLinked(installId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallLinked()");
		}
		logger.info("[BSP]:getInstallLinked() - controller method call Ended");
		return ResponseEntity.ok().body(installLinked);	
	}
	
	@Override
	@GetMapping("/getTasks/{installId}")
	public ResponseEntity<?> getInstallationTasks(@PathVariable int installId) throws Exception{
		logger.info("[BSP]:getInstallationTasks() - method call Started");
		List<InstallationTasks> installationTasks = null;
		try {
			installationTasks = installationsDetailsServiceImpl.getInstallationTasks(installId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationTasks()");
		}
		logger.info("[BSP]:getInstallationTasks() - method call Ended");
		return ResponseEntity.ok().body(installationTasks);
	}
	
	@Override
	@GetMapping("/getInstallMilestone/{installId}")
	public ResponseEntity<?> getInstallationMilestone(@PathVariable int installId) throws Exception{
		logger.info("[BSP]:getInstallationMilestone() - method call Started");
		List<InstallationMilestone> InstallationMilestone = null;
		try {
			InstallationMilestone  = installationsDetailsServiceImpl.getInstallationMilestone(installId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationMilestone()");
		}
		logger.info("[BSP]:getInstallationMilestone() - method call Ended");
		return ResponseEntity.ok().body(InstallationMilestone);	
	}
	@Override
	@GetMapping("/getInstallHistory/{installId}")
	public ResponseEntity<?> getInstallHistory(@PathVariable int installId) throws Exception{
		logger.info("[BSP]:getInstallHistory() - method call Started");
		List<InstallHistoryInfo> InstallaHistory = null;
		try {
			InstallaHistory  = installationsDetailsServiceImpl.getInstallHistory(installId);
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallHistory()");
		}
		logger.info("[BSP]:getInstallHistory() - method call Ended");
		return ResponseEntity.ok().body(InstallaHistory);	
	}

	/*
	 * @GetMapping("/getInstallTypes") public ResponseEntity<?> getInstallTypes()
	 * throws Exception{
	 * logger.info("[BSP]:getInstallHistory() - method call Started");
	 * List<InstallTypes> InstallaTypes = null; try { InstallaTypes =
	 * installationsDetailsServiceImpl.getInstallTypesInfo(); }catch(Exception e) {
	 * traceLogger.writeStackTrace(e); throw new
	 * FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallHistory()"
	 * ); } logger.info("[BSP]:getInstallHistory() - method call Ended"); return
	 * ResponseEntity.ok().body(InstallaTypes); }
	 */
	@Override
	@GetMapping("/getInstallStatus")
	public ResponseEntity<?> getInstallationStatus() throws Exception{
		logger.info("[BSP]:getInstallationStatus() - method call Started");
		List<InstallStatuses> installStatuses = null;
		try {
			installStatuses = installationsDetailsServiceImpl.getInstallationStauts();
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationStatus()");
		}
		logger.info("[BSP]:getInstallationStatus() - method call Ended");
		return ResponseEntity.ok().body(installStatuses);
	}
	
	@Override
	@GetMapping("/getInstallTypes")
	public ResponseEntity<?> getInstallationTypes() throws Exception{
		logger.info("[BSP]:getInstallationTypes() - method call Started");
		List<InstallTypes> InstallTypes = null;
		try {
			InstallTypes = installationsDetailsServiceImpl.getInstallationTypes();
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationTypes()");
		}
		logger.info("[BSP]:getInstallationTypes() - method call Ended");
		return ResponseEntity.ok().body(InstallTypes);
	}
	
	@Override
	@GetMapping("/getInstallEnvironments")
	public ResponseEntity<?> getInstallationEnvironments() throws Exception{
		logger.info("[BSP]:getInstallationEnvironments() - method call Started");
		List<InstallEnvironments> installEnvironments = null;
		try {
			installEnvironments = installationsDetailsServiceImpl.getInstallEnvironments();
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getInstallationEnvironments()");
		}
		logger.info("[BSP]:getInstallationEnvironments() - method call Ended");
		return ResponseEntity.ok().body(installEnvironments);
	}
	
	@Override
	@GetMapping("/getTechOwner")
	public ResponseEntity<?> getTechOwner() throws Exception{
		logger.info("[BSP]:getTechOwner() - method call Started");
		List<EstimateGroups> estimateGroups = null;
		try {
			estimateGroups = installationsDetailsServiceImpl.getTechOwner();
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getTechOwner()");
		}
		logger.info("[BSP]:getTechOwner() - method call Ended");
		return ResponseEntity.ok().body(estimateGroups);
	}
	
	@Override
	@GetMapping("/getCabStatus")
	public ResponseEntity<?> getCabStatus() throws Exception{
		logger.info("[BSP]:getCabStatus() - method call Started");
		List<CabStatus> cabStatus = null;
		try {
			cabStatus = installationsDetailsServiceImpl.getCabStatus();
		}catch(Exception e) {
			traceLogger.writeStackTrace(e);
			throw new FailedToFullfillRequest("Operation Failed,Exception:"+e,"getCabStatus()");
		}
		logger.info("[BSP]:getCabStatus() - method call Ended");
		return ResponseEntity.ok().body(cabStatus);
	}	
}

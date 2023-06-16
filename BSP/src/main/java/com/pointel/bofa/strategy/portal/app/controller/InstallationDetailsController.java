package com.pointel.bofa.strategy.portal.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface InstallationDetailsController {

	//ResponseEntity<?> getInstallMilestone(int installId) throws Exception;
	ResponseEntity<?> getInstallTech(int installId) throws Exception;
	ResponseEntity<?> getInstallProduct(int installId) throws Exception;
	public ResponseEntity<?> getInstallHistory(int installId) throws Exception;
	
	//jayakumar
	public ResponseEntity<?> getInstallationOverview(int installId) throws Exception;
	public ResponseEntity<?> getInstallLinked(int installId) throws Exception;
	public ResponseEntity<?> getInstallationTasks(int installId) throws Exception;
	public ResponseEntity<?> getInstallationMilestone(int installId) throws Exception;
	
	public ResponseEntity<?> getInstallationStatus() throws Exception;
	public ResponseEntity<?> getInstallationTypes() throws Exception;
	public ResponseEntity<?> getInstallationEnvironments() throws Exception;
	public ResponseEntity<?> getTechOwner() throws Exception;
	public ResponseEntity<?> getCabStatus() throws Exception;
}

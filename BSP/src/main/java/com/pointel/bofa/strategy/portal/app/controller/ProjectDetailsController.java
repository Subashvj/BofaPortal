package com.pointel.bofa.strategy.portal.app.controller;

import org.springframework.http.ResponseEntity;

public interface ProjectDetailsController {

	ResponseEntity<?> getHistorys(int stratId) throws Exception;
	ResponseEntity<?> getRm(int stratId)throws Exception;
	ResponseEntity<?> getoverview(int stratId)throws Exception;
	ResponseEntity<?> getDevelopmentNotes(int stratId)throws Exception;
	ResponseEntity<?> getTestNotes(int stratId)throws Exception;
	//jayakumar
	public ResponseEntity<?> getTasks(int stratId) throws Exception;
	public ResponseEntity<?> getScope(int stratId) throws Exception;
	public ResponseEntity<?> getPm(int stratId,String userId) throws Exception;
	public ResponseEntity<?> getFiles(int typeId) throws Exception;
}

/*
 * Copyright (c) 2008 TouchPoint Solutions Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of TouchPoint 
 * Solutions Inc ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with TouchPoint.
 *
 * TOUCHPOINT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. TOUCHPOINT SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.pointel.bofa.strategy.portal.app.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * To Log stack trace for an Error
 */
@Component
public class TraceLogger {

     
	private static final Logger logger = LogManager.getLogger(TraceLogger.class);

	
	/*public static void writeMessage(Level level, String msgText) {
		Logger logger = Logger.getLogger("");
		logger.log(level, msgText);
	}*/

	/**
	 * To write the stack trace in the Log file
	 * @param exception
	 */
	public void writeStackTrace(Exception exception) {
		//Logger logger = Logger.getLogger("ActiveSync");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		logger.log(Level.ERROR, sw.toString());
		try {
			sw.close();
			pw.close();
			sw = null; pw = null;
		} catch (Exception close) {}
	}

	/**
	 * To terminate the application
	 * 
	 * @param reason
	 */
	/*
	public static void terminate(String reason) {
		Logger logger = Logger.getLogger("");
		logger.log(Level.ERROR, "OMS Submitter terminated Reason " + reason);
	}*/
}
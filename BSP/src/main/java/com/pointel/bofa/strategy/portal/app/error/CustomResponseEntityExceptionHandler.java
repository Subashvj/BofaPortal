package com.pointel.bofa.strategy.portal.app.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pointel.bofa.strategy.portal.app.interceptor.AppInterceptor;

@ControllerAdvice
@ResponseStatus
public class CustomResponseEntityExceptionHandler 
       extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LogManager.getLogger(CustomResponseEntityExceptionHandler.class);

	@ExceptionHandler(RecordsNotFoundException.class)
	public ResponseEntity<ErrorMessage> recordsNotFoundException(RecordsNotFoundException exception,
			WebRequest request) {
		
		logger.info("called from method "+exception.getMethodName());
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
				exception.getMessage());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
	@ExceptionHandler(FailedToFullfillRequest.class)
	public ResponseEntity<ErrorMessage> recordsNotFoundException(FailedToFullfillRequest exception,
	WebRequest request) {

	logger.info("called from method "+exception.getMethodName());

	ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
	exception.getMessage());

	return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}
	
}

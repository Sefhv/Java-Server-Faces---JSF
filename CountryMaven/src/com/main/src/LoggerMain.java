package com.main.src;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class LoggerMain implements Serializable {

	private Logger logger;
	
	public LoggerMain() {
		logger = LogManager.getLogger();
	}
	
	@Test
	public void testLogger() {
		logger.error("Error message");
	}		       
    
	public Logger getLogger() {
		if(logger==null)
			logger = LogManager.getLogger();	
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}         
}


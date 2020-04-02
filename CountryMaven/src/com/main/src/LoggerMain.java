package com.main.src;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LoggerMain implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger;

	public LoggerMain() {

	}

	@Test
	public void testLogger() {
		getLogger().error("Error message");
	}

	public static Logger getLogger() {
		if (logger == null)
			logger = LogManager.getLogger();
		return logger;
	}

	public static void setLogger(Logger logger) {
		LoggerMain.logger = logger;
	}
}

/*
 * Copyleft 2013
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.organization.automation.project.spice.mix.testng.extension.logging;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public final class TAFLoggerFactory {

	private static Logger logger;
	
	private static final Level   DEFAULT_LEVEL       = Level.ALL;
	private static final String  DEFAULT_PATH        = "output/" + "taf_log.txt";
	private static final boolean DEFAULT_ADDITIVITY  = false;
	private static final String  DEFAULT_ENCODING    = "UTF-8";
	
	private static String path = DEFAULT_PATH;
	
	/**
	 * Protect constructor since it is a static only class.
	 */
	private TAFLoggerFactory() {
	}
		
	public static synchronized Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger(TAFLoggerFactory.class);
			init();
		}
		
		return logger;
	}
	
	public static synchronized Logger getLogger(Class<?> clazz) {
		if (logger == null) {
			logger = Logger.getLogger(clazz);
			init();
		}
		
		return logger;
	} 
	
	public static String getLoggerMessagePrefix() {
		return DateUtils.now() + "[LOG][System/TAF]";
	}
	
	private static void init() {
		setUpBasicSettings();
		
		// TAF Console Logs
		setUpConsoleAppender();
		
		// TAF File Logs
		setUpFileAppender();
		
		// TAF System Console Logs
		setUpSystemConsoleAppender();
	}
	
	private static void setUpBasicSettings() {
		BasicConfigurator.resetConfiguration();		
		DateUtils.setBelarusTimeZone();
		
		logger.setAdditivity(DEFAULT_ADDITIVITY);
		logger.removeAllAppenders();
		logger.setLevel(DEFAULT_LEVEL);
	}
	
	private static void setUpConsoleAppender() {
		try {
			ConsoleAppender ca = new ConsoleAppender();		
			ca.setWriter(new OutputStreamWriter(System.out, DEFAULT_ENCODING));
			ca.setLayout(new PatternLayout(DateUtils.now() + "[LOG][%-3p][TAF]        %m %n"));
			ca.setName("TAF Console Appender.");
			ca.activateOptions();
			logger.addAppender(ca);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString());
		}
	}
	
	private static void setUpSystemConsoleAppender() {
		try {
			ConsoleAppender sysca = new ConsoleAppender();		
			sysca.setWriter(new OutputStreamWriter(System.out, DEFAULT_ENCODING));
			sysca.setLayout(new PatternLayout(DateUtils.now() + "[LOG][%-3p][System/TAF] %m %n"));
			sysca.setName("TAF System Console Appender.");
			sysca.activateOptions();
			BasicConfigurator.configure(sysca);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString());
		}
	}
	
	private static void setUpFileAppender() {
		logger.addAppender(getFileAppender());
	}
	
	public static FileAppender getFileAppender(String filePath) {
		path = filePath;
		
		return getFileAppender();
	}
	
	public static FileAppender getFileAppender() {
		FileAppender appender = null;
		
		// Note, %n is newline
	    String pattern = DateUtils.now() + "[LOG][%-3p] %m %n";
	    
	    /* 
	   	pattern =  "Milliseconds since program start: %r %n";
	    pattern += "Classname of caller: %C %n";
	    pattern += "Date in ISO8601 format: %d{ISO8601} %n";
	    pattern += "Location: %l %n %n";
	    pattern += "[LOG][%-3p] %m %n %n"; 
	    */
	      
	    PatternLayout layout = new PatternLayout(pattern);  
		
	    try {
			appender = new FileAppender(layout, path, false);	
			appender.setName("TAF File Appender.");
			// appender.addFilter(new DemoLevelFilter());
			
			BasicConfigurator.configure(appender);
		} catch (IOException e) {
			logger.error(e.toString());
		}
		
		return appender;
	}
	
	public static void printAllLevelsCodes() {
		logger.info("----------------------------------------------------------");
		logger.info("level DEMO: " + CustomLevels.DEMO_TRACE_INT);
		logger.info("level FULL_DETAILED: " + CustomLevels.FULL_DETAILED_TRACE_INT);
		logger.info("level ALL: " + Level.ALL_INT);
		logger.info("level DEBUG: " + Level.DEBUG_INT);
		logger.info("level ERROR: " + Level.ERROR_INT);
		logger.info("level FATAL: " + Level.FATAL_INT);
		logger.info("level INFO: " + Level.INFO_INT);
		logger.info("level OFF: " + Level.OFF_INT);
		logger.info("level TRACE: " + Level.TRACE_INT);
		logger.info("level WARN: " + Level.WARN_INT);
		logger.info("----------------------------------------------------------");
	}
}

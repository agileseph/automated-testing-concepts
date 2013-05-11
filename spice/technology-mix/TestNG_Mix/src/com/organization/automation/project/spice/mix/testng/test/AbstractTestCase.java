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
package com.organization.automation.project.spice.mix.testng.test;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public class AbstractTestCase implements ITestCase {
	protected static final Logger LOGGER = TAFLoggerFactory.getLogger();
	private static final String DEFAULT_ID = "TestNG Test Case";
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AbstractTestCase() {
		id = DEFAULT_ID;
	}
	
	@Override
	public void preconditions() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}

	@Override
	public void init() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}
	
	@Override
	public void setup() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}
	
	@Override
	public void steps() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}
	
	@Override
	public void poststeps() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}
	
	@Override
	public void check() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());
	}
	
	@Override
	public void teardown() throws Exception {
		logOnPointStart(new Object() { } .getClass().getEnclosingMethod().getName());

		id = null;
	}

	@Override
	public void run() throws TCException {
		try {
			logOnStart();
			
			preconditions();
			logOnPointPass();
			
			init();
			logOnPointPass();
			
			setup();
			logOnPointPass();
			
			steps();
			logOnPointPass();
			
			poststeps();
			logOnPointPass();
			
			check();
			logOnPointPass();
		} catch (Exception e) {
			LOGGER.error("[TEST]       [EXCEPTION]");
			LOGGER.error("[TEST]        " + e.toString());
			throw new TCException(e);
		} catch (Error e) {
			LOGGER.error("[TEST]       [ERROR]");
			LOGGER.error("[TEST]        " + e.toString());
			throw new TCError(e);
		} finally {
			teardownSafely();
		}
	}
	
	public void teardownSafely() {
		try {
			teardown();
			logOnPointPass();
		} catch (Exception e) {
			LOGGER.error(e.toString());
		} catch (Error e) {
			LOGGER.error(e.toString());
		}
	}
	
	private void logOnStart() {
		LOGGER.info("[TEST] ");
		LOGGER.info("[TEST]         Control points:");
		LOGGER.info("[TEST] ");
	}
	
	private void logOnPointPass() {
		LOGGER.info("[TEST]                                                  OK ");
	}
	
	private void logOnPointStart(String name) {
		LOGGER.info("[TEST]         [POINT] " + name);
	}
}

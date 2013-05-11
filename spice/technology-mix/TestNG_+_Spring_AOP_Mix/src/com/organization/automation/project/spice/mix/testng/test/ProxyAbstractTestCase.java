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
import org.springframework.aop.framework.AopContext;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public class ProxyAbstractTestCase implements ITestCase {
	protected static final Logger LOGGER = TAFLoggerFactory.getLogger();
	private static final String DEFAULT_ID = "TestNG Test Case";
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProxyAbstractTestCase() {
		id = DEFAULT_ID;
	}
	
	@Override
	public void preconditions() throws Exception {
	}

	@Override
	public void init() throws Exception {
	}
	
	@Override
	public void setup() throws Exception {
	}
	
	@Override
	public void steps() throws Exception {
	}
	
	@Override
	public void poststeps() throws Exception {
	}
	
	@Override
	public void check() throws Exception {
	}
	
	@Override
	public void teardown() throws Exception {
		id = null;
	}

	@Override
	public void run() throws TCException {
		try {
			((ITestCase) AopContext.currentProxy()).preconditions();
			((ITestCase) AopContext.currentProxy()).init();
			((ITestCase) AopContext.currentProxy()).setup();
			((ITestCase) AopContext.currentProxy()).steps();
			((ITestCase) AopContext.currentProxy()).poststeps();
			((ITestCase) AopContext.currentProxy()).check();
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
			((ITestCase) AopContext.currentProxy()).teardown();
		} catch (Exception e) {
			LOGGER.error(e.toString());
		} catch (Error e) {
			LOGGER.error(e.toString());
		}
	}
}

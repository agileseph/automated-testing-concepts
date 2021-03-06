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
package com.organization.automation.project.spice.mix.testng.extension.aop.spring;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;
import com.organization.automation.project.spice.mix.testng.test.set.TestSetTexture;

@Test(groups = { "InitializationTests" })
public class InitializationTests_TestSet extends TestSetTexture {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	/*
	 * Pre and post processing
	 */
	@Parameters({ "test-suite" })
	@BeforeSuite
	public void setUpSuite(final String testSuiteName) {
		setUpSuiteTests(testSuiteName);
	}
	
	@AfterSuite
	public void tearDownSuite() {
		tearDownSuiteTests();
	}

	@Parameters({ "test-set_initialization-tests" })
	@BeforeClass
	public void setUpSet(final String testSetName) {
		setName(testSetName);
		setUpAllTests();
	}
	
	@AfterClass
	public void tearDownSet() {
		tearDownAllTests();
	}
	
	@BeforeMethod
	public void setUpTest() {
		setUpEachTest();
	}
	
	@AfterMethod
	public void tearDownTest() {
		tearDownEachTest();
	}
	
	@Test(groups = "initLocalEnv")
	public void isLocalTAFEnvOK() {
		LOGGER.info("[TEST]         [INIT] local env started");
		LOGGER.info("[TEST]                                                  OK ");
	}
	
	@Test(groups = "initQAEnv", dependsOnGroups = { "initLocalEnv" })
	public void isQAEnvOK() {
		LOGGER.info("[TEST]         [INIT] QA env started");
		LOGGER.info("[TEST]                                                  OK ");
	}
}

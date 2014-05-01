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
package com.organization.automation.project.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.organization.automation.project.architecture.model.TestSystem;
import com.organization.automation.project.tests.extension.junit.JUnitExtension;

public class TestSetTexture extends JUnitExtension {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(TestSetTexture.class);
	protected final static TestSystem TS = new TestSystem();

	@BeforeClass
	public static void setUpAllTests() {
		LOGGER.info("[Test]         =============================================================");
		LOGGER.info("[Test]         [BEFORE] All TCs");
		try {
			TS.init();
		} catch (Exception e) {
			LOGGER.error("              [TestTexture] before all tests: " + e.toString());
			e.printStackTrace();
			throw new AssertionError(e);			
		}
	}	
	
	@Before
	public void setUpEachTest() {
		LOGGER.info("[Test]         [BEFORE] Each TC");
		try {
			TS.check();
			TS.ready();
			TS.pre_run();
			TS.run();
		} catch (Exception e) {
			LOGGER.error("              [TestTexture] before test: " + e.toString());
			e.printStackTrace();
			throw new AssertionError(e);			
		}
	}
	
	@After
	public void tearDownEachTest() {
		LOGGER.info("[Test]         [AFTER] Each TC");
		try {
			TS.post_run();
			TS.setState(TS.getCheckState());
		} catch (Exception e) {
			LOGGER.error("              [TestTexture] after test: " + e.toString());
			e.printStackTrace();
			throw new AssertionError(e);			
		}
	}

	@AfterClass
	public static void tearDownTests() {
		LOGGER.info("[Test]         [AFTER] All TCs");
		try {
			TS.check();
			TS.setState(TS.getFinishState());
			TS.finish();
		} catch (Exception e) {
			LOGGER.error("              [TestTexture] after all tests: " + e.toString());
			e.printStackTrace();
			throw new AssertionError(e);
		}
		
		LOGGER.info("[Test]         =============================================================");
	}		
}

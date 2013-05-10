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
package com.organization.automation.project.spice.mix.junit.test.suite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;
import com.organization.automation.project.spice.mix.junit.system.TestSystem;
import com.organization.automation.project.spice.mix.junit.test.set.TestSetTexture;

public class TestSuiteTexture {
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	public static final TestSuite SUITE = new TestSuite(TestSystem.SUITE_NAME);
	
	public static boolean runTestSet(Class<? extends TestSetTexture> c) {
		logOnSetStart(c.getName());
		
		TestResult result = new TestResult();
		SUITE.runTest(new JUnit4TestAdapter(c), result);

		logOnSetEnd(c.getName(), result.wasSuccessful(), result.runCount());
	
		return result.wasSuccessful();
	}
	
	// log methods
	protected static void logOnSuiteStart() {
		LOGGER.info("[SUITE]       ===========================================================");
		LOGGER.info("[SUITE]                      Test suite: " + SUITE.getName());
		LOGGER.info("[SUITE]       ===========================================================");
	}
	
	protected static void logOnMainSetsStart() {
		//LOGGER.info("[TestSuite]   Test sets start processing...");
	}
	
	protected static void logOnSetStart(String nameTS) {
		//LOGGER.info("[TestSuite]   Test set " + nameTS + " starts...");
	}
	
	protected static void logOnSetEnd(String nameTS, boolean result, int count) {
		//LOGGER.info("[SUITE]       Test set " + nameTS + " has been finished.");
		//LOGGER.info("[TestSuite]   Test set info: ");
		//LOGGER.info("[TestSuite]                 result    = " + result);
		//LOGGER.info("[TestSuite]                 TCs count = " + count);
		//LOGGER.info("[TestSuite]   Test set " + TSName + " - [ " + result + " ]");
	}
}

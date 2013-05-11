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
package com.organization.automation.project.spice.mix.testng.test.set;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public class TestSetTexture {
	
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	
	protected String description;
	
	public void setName(String name) {
		this.description = name;
	}

	public void setUpSuiteTests(String name) {
		LOGGER.info("[SUITE]        ===================================================================");
		LOGGER.info("[SUITE]                    Test Suite: " + name);
		LOGGER.info("[SUITE]        ===================================================================");
	}
	
	public void setUpAllTests() {
		LOGGER.info("[SET]          ===================================================================");
		LOGGER.info("[SET]                      Test Set: " + description);
		LOGGER.info("[SET]          ===================================================================");
		
		LOGGER.info("[TEST]_____________________");
		LOGGER.info("[TEST][BEFORE] [ALL] start");
		LOGGER.info("[TEST]         ...");
		LOGGER.info("[TEST][BEFORE] [ALL] end");
		LOGGER.info("[TEST]_____________________");
	}
	
	public void setUpEachTest() {
		LOGGER.info("[TEST]_____________________");
		LOGGER.info("[TEST][BEFORE] [EACH] start");
		LOGGER.info("[TEST]         ...");
		LOGGER.info("[TEST][BEFORE] [EACH] end");
		LOGGER.info("[TEST]_____________________");
		
		LOGGER.info("[TEST]         *******************************************************************");
	}
	
	public void tearDownEachTest() {
		LOGGER.info("[TEST]         *******************************************************************");
		
		LOGGER.info("[TEST]_____________________");
		LOGGER.info("[TEST][AFTER]  [EACH] start");
		LOGGER.info("[TEST]         ...");
		LOGGER.info("[TEST][AFTER]  [EACH] end");
		LOGGER.info("[TEST]_____________________");
	}
	
	public void tearDownAllTests() {
		LOGGER.info("[TEST]_____________________");
		LOGGER.info("[TEST][AFTER]  [ALL] start");
		LOGGER.info("[TEST]         ...");
		LOGGER.info("[TEST][AFTER]  [ALL] end");
		LOGGER.info("[TEST]_____________________");

		LOGGER.info("[SET]          ===================================================================");
		LOGGER.info("[SET]                                                          Test Set:  [ DONE ]");
		LOGGER.info("[SET]          ===================================================================");
	}
	
	public void tearDownSuiteTests() {
		LOGGER.info("[SUITE]        ===================================================================");
		LOGGER.info("[SUITE]                                                      Test Suite:  [ DONE ]");
		LOGGER.info("[SUITE]        ===================================================================");
	}
}

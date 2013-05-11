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
package com.organization.automation.project.spice.mix.junit.system;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;

public class TestSystem {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	public static final String SUITE_NAME    = "Test Project Suite";
	public static final String TEST_SET_NAME = "Feature Addition";
	public static final String INIT_TEST_SET = "Initialization Tests";

	// min timeout is 5 seconds
	public static final long MIN_TIMEOUT = 5000;

	// log methods
	public static void logOnError(String message) {
		LOGGER.error(message);
	}

	public static void logOnInfo(String message) {
		LOGGER.info(message);
	}

	public static void logOnTCStart(String description) {
		LOGGER.info("[TEST]        ***********************************************************");
		LOGGER.info("[TEST]        Description: " + description);
	}

	public static void logOnTCPass() {
		LOGGER.info("[TEST]        ----------------------------------------------------------");
		LOGGER.info("[TEST]                                                           [ PASS ]");
		LOGGER.info("[TEST]        ***********************************************************");
	}

	public static void logOnTCFail() {
		LOGGER.info("[TEST]        ----------------------------------------------------------");
		LOGGER.info("[TEST]                                                           [ FAIL ]");
		LOGGER.info("[TEST]        ***********************************************************");
	}

	public void pause(long timeout) {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			LOGGER.error(e.toString());
		}
	}
}

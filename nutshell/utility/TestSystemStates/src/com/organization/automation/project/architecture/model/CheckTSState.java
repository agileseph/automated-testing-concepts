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
package com.organization.automation.project.architecture.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckTSState implements TSState {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckTSState.class);
	
	private final TestSystem testSystem;
	
	// Test System forces start only ones.
	private boolean wasForcedSUT;

	public CheckTSState(TestSystem testSystem) {
		this.testSystem = testSystem;
		wasForcedSUT = false;
	}

	@Override
	public void init() throws Exception {
		throw new IllegalStateException("Can't initialise the Test System.");
	}

	@Override
	public void delivered() throws Exception {
		throw new IllegalStateException("Can't deliver the report.");
	}

	@Override
	public void byDefault() throws Exception {	
		// stub implementation
	}

	@Override
	public void finish() throws Exception {
		// stub implementation 
	}

	@Override
	public void ready() throws Exception {
		// stub implementation
	}
	
	@Override
	public void check() throws Exception {
		LOGGER.info("[TestSystem]      State Check");
		
		boolean isAlive = testSystem.isSUTAlive();
		
		int run_timeout = 0;
		int max_timeout = 60000; // 1 minute
		int timeout = 5000; // 5 seconds
		
		// force 1 minute ping command until server isAlive or run_timeout reached max_timeout
		while ((!isAlive) && (run_timeout < max_timeout)) {
			isAlive = testSystem.isSUTAlive();
			run_timeout += timeout;
			
			LOGGER.info("              Attempt to connect... timeout = " + timeout +
												"run timeout = " + run_timeout);
			
			testSystem.pause(timeout);
		}
		
		if (isAlive) {
			testSystem.setState(testSystem.getReadyState());
		} else {
			if (wasForcedSUT) {
				testSystem.setState(testSystem.getFinishState());
				testSystem.setIssue("The SUT doesn't work unexpectedly.");
				testSystem.finish();
				throw new Exception("The SUT doesn't work unexpectedly.");
			}
			
			// force 1st time
			wasForcedSUT = true;
			testSystem.setState(testSystem.getForceState());
			testSystem.force();
		}
	}
	
	@Override
	public void force() throws Exception {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void post_run() throws Exception {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void pre_run() throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
	}
}

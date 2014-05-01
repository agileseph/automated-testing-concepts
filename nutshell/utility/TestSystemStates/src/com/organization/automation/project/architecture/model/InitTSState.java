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

public class InitTSState implements TSState {

	private static final Logger LOGGER = LoggerFactory.getLogger(InitTSState.class);
	
	private final TestSystem testSystem;
	//private SystemUnderTest SUT;

	public InitTSState(TestSystem testSystem) {
		this.testSystem = testSystem;
	}

	public void init() throws Exception {
		LOGGER.info("[TestSystem]      State Init.");
		
		// init all variables
		// set up and start Environment
			
		testSystem.setState(testSystem.getCheckState());
	}

	public void delivered() throws Exception {
		throw new IllegalStateException("Can't deliver the report.");
	}

	@Override
	public void byDefault() throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void force() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void finish() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void ready() throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void check() throws Exception {
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

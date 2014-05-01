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

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSystem {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSystem.class);
	
	// Basic Test System states:
	private final TSState initState;
	private final TSState deliveredState;
	private final TSState readyState;
	private final TSState finishState;
	private final TSState checkState;
	private final TSState forceState;
	private final TSState runState;

	// State initialization
	private TSState state;
	
	private String issue;
	private boolean wasNegativeCase;

	private String name;
	 
	// TC timeout:
	public static final int MIN_TEST_TIMEOUT = 60000; // 1 minute
	
	public TestSystem() {
		 LOGGER.info("[TestSystem]   Start");
		 
		 // init Test System states
		 initState      = new InitTSState(this);
		 readyState     = new ReadyTSState(this);
		 deliveredState = new DeliveredTSState(this);
		 finishState    = new FinishTSState(this);	  	 
		 checkState     = new CheckTSState(this);
		 forceState     = new ForceStartSUTTSState(this);
		 runState       = new RunTSState(this);
		 state          = initState; // by default
		 
		 // init Test System parts
		 
		 // init working Environment
		 		 
		 // init SUT
		 		 
		 wasNegativeCase = false;
	 }
	 	 
	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public TSState getState() {
		 return state;
	 }

	 public void setState(TSState state) {
	  this.state = state;
	 }
	 
	 public void setIssue(String issue) {
		 this.issue = issue;
		 wasNegativeCase = true;
	 }
	 
	 public String getIssue() {
		 return issue;
	 }
	 
	 public boolean isNegativeScenario() {
		 return wasNegativeCase;
	 }
	 
	 // main state actions
	 public void init() throws Exception {
		 this.state.init();
	 } 
	 
	 public void delivered() throws Exception {
		 this.state.delivered();
	 }
	 
	 public void finish() throws Exception {
		 this.state.finish();
	 }

	 public void ready() throws Exception {
		 this.state.ready();
	 }
	 
	 public void check() throws Exception {
		 this.state.check();
	 }

	 public void pre_run() throws Exception {
		 this.state.pre_run();
	 }

	 public void run() throws Exception {
		 this.state.run();
	 }

	 public void post_run() throws Exception {
		 this.state.post_run();
	 }
	 
	 public void force() throws Exception {
		 this.state.force();
	 }
	 
	 public TSState getInitState() {
		 return initState;
	 }

	 public TSState getDeliveredState() {
		 return deliveredState;
	 }
	 
	 public TSState getReadyState() {
		 return readyState;
	 }
	 
	 public TSState getFinishState() {
		 return finishState;
	 }
	 
	 public TSState getCheckState() {
		 return checkState;
	 }
	 
	 public TSState getForceState() {
		 return forceState;
	 }
	 
	 public TSState getRunState() {
		 return runState;
	 }
	 
	 // stub implementation
	 public boolean isSUTAlive() {
		 return true; //SUT.isAlive();
	}	 	 	 	 	 
	
	public void pause(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			LOGGER.error(e.toString());
			e.printStackTrace();
		}
	}
}

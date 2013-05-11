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
package com.organization.automation.project.spice.mix.bdd.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.organization.automation.project.spice.mix.junit.test.AbstractTestCase;
import com.organization.automation.project.spice.mix.junit.test.TCException;

public class AbstractTCSteps {
	
	private static final String PASS = "PASS";
	private static final String FAIL = "FAIL";
	
	private AbstractTestCase tc = new AbstractTestCase();
	
	/*
	 * Abstract TC steps
	 */
	@Given("abstract test case with id $ID")
	public void initializeTestCase(@Named("ID") String id) {
		tc = new AbstractTestCase(id);
	}

	@When("abstract test case run")
	public void whenAbstractTestCaseRun() throws TCException {
		tc.run();
	}

	@Then("result should be [$valid]")
	public void checkTC(@Named("valid") String result) {
		Assert.assertEquals(tc.getResult() ? PASS : FAIL, result);
	}
	
	/*
	 * Abstract Exemplified TC steps
	 */
	@Given("abstract test case with id <id> and name <tc_name>")
	public void inputTC(@Named("id") String tcID, @Named("tc_name") String tcName) {
		tc = new AbstractTestCase(tcID + ":" + tcName);
	}

	@Then("result of exemplified TC should be [<result>]")
	public void checkExamplifiedTC(@Named("result") String result) {
		Assert.assertEquals(tc.getResult() ? PASS : FAIL, result);
	}
}

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

import org.junit.Assert;
import org.junit.Test;

import com.organization.automation.project.architecture.model.TestSystem;
import com.organization.automation.project.tests.extension.junit.History;

public class ProjectTestSet extends TestSetTexture {

	@History(number = "1", link = "...", author = "Viktar Karanevich", date = "01-05-2014")
	@Test(timeout = TestSystem.MIN_TEST_TIMEOUT)
	public void itShouldBeTrueCase() {
		LOGGER.info("           [Body]             the test is running...");
		
		// [SET UP]
		int actual   = 0;
		int expected = 0;
		
		// [CHECK POINT]
		Assert.assertEquals(expected, actual);		
	}
	
	@History(number = "2", link = "...", author = "Viktar Karanevich", date = "01-05-2014")
	@Test(timeout = TestSystem.MIN_TEST_TIMEOUT)
	public void itShouldBeFalseCase() {
		LOGGER.info("           [Body]             the test is running...");
		
		// [SET UP]
		int actual   = 1;
		int expected = 0;
		
		// [CHECK POINT]
		Assert.assertEquals(expected, actual);		
	}
}

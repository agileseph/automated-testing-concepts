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
package com.organization.automation.project.spice.mix.junit.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AbstractTCUnitTests {

	/*
	 * Positive cases.
	 */
	@Test
	public void testAbstractTC_PositiveCase() throws TCException {
		ITestCase tc = new AbstractTestCase();
		tc.run();
	}
	
	@Test
	public void testAbstractTC_PositiveCaseWithID() throws TCException {
		String expected = "#1";
		String actual   = "";
		
		ITestCase tc = new AbstractTestCase(expected);
		actual = ((AbstractTestCase) tc).getId();
		tc.run();
		
		assertEquals(expected, actual);
	}
}

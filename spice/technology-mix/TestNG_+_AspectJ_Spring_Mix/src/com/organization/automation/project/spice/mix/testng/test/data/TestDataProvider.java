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
package com.organization.automation.project.spice.mix.testng.test.data;

import org.testng.annotations.DataProvider;

import com.organization.automation.project.spice.mix.aop.aspectjspring.LogAspect;
import com.organization.automation.project.spice.mix.aop.aspectjspring.TCProxy;
import com.organization.automation.project.spice.mix.aop.aspectjspring.TCSample;
import com.organization.automation.project.spice.mix.testng.test.AbstractTestCase;
import com.organization.automation.project.spice.mix.testng.test.set.TestSetTexture;

public class TestDataProvider extends TestSetTexture {

	/*
	   Abstract TC fixture
	 *******************************
	 */
	@DataProvider(name = "Abstract.TC")
	protected Object[][] createTestData_AbstractTC() {
		return new Object[][]{
							 	{ new AbstractTestCase(),
							 	  new TCProxy() }
							 };
	}	

	@DataProvider(name = "Abstract.TC.with.LogAspect")
	protected Object[][] createTestData_AbstractTCLogAspect() {
		return new Object[][]{
							 	{ new AbstractTestCase(),
							 	  new TCProxy(new LogAspect()) }
							 };
	}	

	@DataProvider(name = "Abstract.TC.with.ConstructorParameter")
	protected Object[][] createTestData_AbstractTCConstructorParameter() {
		String expected = "100";
		
		return new Object[][]{
							 	{ new TCSample(expected),
							 	  new TCProxy(),
							 	  expected }
							 };
	}	
}

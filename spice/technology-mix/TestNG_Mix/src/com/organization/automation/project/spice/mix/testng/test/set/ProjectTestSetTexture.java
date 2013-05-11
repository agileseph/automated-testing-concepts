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

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.organization.automation.project.spice.mix.testng.extension.listener.AutomationProjectTestListener;
import com.organization.automation.project.spice.mix.testng.test.data.TestDataProvider;

@Test(groups = { "AbstractTCs" }, dependsOnGroups = { "InitializationTests" })
@Listeners({ AutomationProjectTestListener.class })
public class ProjectTestSetTexture extends TestDataProvider {

	@BeforeClass
	public void setUpSet() {
		setUpAllTests();
	}
	
	@AfterClass
	public void tearDownSet() {
		tearDownAllTests();
	}
	
	@BeforeMethod
	public void setUpTest() {
		setUpEachTest();

	}
	
	@AfterMethod
	public void tearDownTest() {
		tearDownEachTest();
	}
}

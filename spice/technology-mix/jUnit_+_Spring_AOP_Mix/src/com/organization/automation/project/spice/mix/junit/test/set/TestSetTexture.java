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
package com.organization.automation.project.spice.mix.junit.test.set;

import com.organization.automation.project.spice.mix.aop.spring.LogAroundAdvice;
import com.organization.automation.project.spice.mix.aop.spring.TCProxy;
import com.organization.automation.project.spice.mix.junit.JUnitExtension;
import com.organization.automation.project.spice.mix.junit.system.TestSystem;

public class TestSetTexture extends JUnitExtension {

	private static String nameTestSet;
	
	protected final TCProxy TCProxy = new TCProxy(new LogAroundAdvice());
	
	public static void setNameTestSet(String nameTestSet) {
		TestSetTexture.nameTestSet = nameTestSet;
	}

	public static void setUpAllTests() {
		TestSystem.logOnInfo("[SET]         ===========================================================");
		TestSystem.logOnInfo("[SET]                        Test Set: " + nameTestSet);
		TestSystem.logOnInfo("[SET]         ===========================================================");
		
		TestSystem.logOnInfo("[TEST]_____________________");
		TestSystem.logOnInfo("[TEST][BEFORE] [ALL] start");
		TestSystem.logOnInfo("[TEST]         ...");
		TestSystem.logOnInfo("[TEST][BEFORE] [ALL] end");
		TestSystem.logOnInfo("[TEST]_____________________");
	}
	
	public void setUpEachTest() {
		TestSystem.logOnInfo("[TEST]_____________________");
		TestSystem.logOnInfo("[TEST][BEFORE] [EACH] start");
		TestSystem.logOnInfo("[TEST]         ...");
		TestSystem.logOnInfo("[TEST][BEFORE] [EACH] end");
		TestSystem.logOnInfo("[TEST]_____________________");
	}
	
	public void tearDownEachTest() {
		TestSystem.logOnInfo("[TEST]_____________________");
		TestSystem.logOnInfo("[TEST][AFTER]  [EACH] start");
		TestSystem.logOnInfo("[TEST]         ...");
		TestSystem.logOnInfo("[TEST][AFTER]  [EACH] end");
		TestSystem.logOnInfo("[TEST]_____________________");
	}
	
	public static void tearDownAllTests() {
		TestSystem.logOnInfo("[TEST]_____________________");
		TestSystem.logOnInfo("[TEST][AFTER]  [ALL] start");
		TestSystem.logOnInfo("[TEST]         ...");
		TestSystem.logOnInfo("[TEST][AFTER]  [ALL] end");
		TestSystem.logOnInfo("[TEST]_____________________");
		
		TestSystem.logOnInfo("[SET]         ===========================================================");
	}
}

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
package com.organization.automation.project.spice.mix.aop.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.organization.automation.project.spice.mix.junit.test.ITestCase;

public class TCProxy {

	private final AbstractModule logModule; 
	
	public TCProxy() {
		logModule = new LogTestStepModule();
	}
	
	public TCProxy(AbstractModule module) {
		logModule = module;
	}
	
	public ITestCase transform(ITestCase tc) {
		return Guice.createInjector(logModule).getInstance(tc.getClass());
	}
	
	public ITCFactory getTCFactory() {
		return Guice.createInjector(logModule).getInstance(ITCFactory.class);
	}
	
	public IFeatureTCFactory getFeatureTCFactory() {
		return Guice.createInjector(logModule).getInstance(IFeatureTCFactory.class);
	}
}

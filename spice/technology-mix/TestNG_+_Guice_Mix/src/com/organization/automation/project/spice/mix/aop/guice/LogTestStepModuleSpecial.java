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
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.matcher.Matchers;
import com.organization.automation.project.spice.mix.testng.test.AssistedAbstractTestCase;
import com.organization.automation.project.spice.mix.testng.test.ITestCase;

public class LogTestStepModuleSpecial extends AbstractModule {

	@Override
	protected void configure() {
		bindInterceptor(Matchers.subclassesOf(ITestCase.class), 
						Matchers.annotatedWith(LogStep.class), 
						new LoggingTestStepInterceptor());
		install(new FactoryModuleBuilder().
										   implement(ITestCase.class, AssistedAbstractTestCase.class).
										   build(ITCFactory.class));
	}
}

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
package com.organization.automation.project.spice.mix.testng.extension.aop.spring;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.organization.automation.project.spice.mix.aop.spring.LogAroundAdvice;
import com.organization.automation.project.spice.mix.aop.spring.TCProxy;
import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;
import com.organization.automation.project.spice.mix.testng.test.ITestCase;
import com.organization.automation.project.spice.mix.testng.test.ProxyAbstractTestCase;
import com.organization.automation.project.spice.mix.testng.test.TCException;

@Test(groups = { "SpringProxyTests" })
public class SpringProxyUnitTests {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
		
	@Parameters({ "test-set_unit-tests-spring-proxy" })
	@BeforeClass
	public void setUpAllTests(final String name) {
		LOGGER.info("[SET]          ===================================================================");
		LOGGER.info("[SET]                      Test Set: " + name);
		LOGGER.info("[SET]          ===================================================================");
	}
	
	/*
	 * Positive cases.
	 */
	@Test
	public void testSpringProxy_PositiveCase() throws TCException {
		ITestCase tc = new ProxyAbstractTestCase();
		TCProxy proxy = new TCProxy();
		proxy.transform(tc).run();
	}
	
	@Test
	public void testSpringProxy_PositiveCaseWithAdvice() throws TCException {
		ITestCase tc = new ProxyAbstractTestCase();
		TCProxy proxy = new TCProxy(new LogAroundAdvice());
		proxy.transform(tc).run();
	}
}

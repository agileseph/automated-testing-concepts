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

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.organization.automation.project.spice.mix.aop.aspectjspring.TCProxy;
import com.organization.automation.project.spice.mix.testng.extension.annotations.History;
import com.organization.automation.project.spice.mix.testng.test.AbstractTestCase;
import com.organization.automation.project.spice.mix.testng.test.ITestCase;
import com.organization.automation.project.spice.mix.testng.test.TCException;
import com.organization.automation.project.spice.mix.testng.test.set.ProjectTestSetTexture;

import static org.testng.Assert.assertEquals;

@Test(groups = { "AspectJSpringProxyTests" })
public class AspectJSpringProxyUnitTests extends ProjectTestSetTexture {

	@Parameters({ "test-set_unit-tests-aspectjspring-proxy" })
	public AspectJSpringProxyUnitTests(final String name) {
		super();
		setName(name);
	}
	
	/*
	 * Positive cases.
	 */
	@History(author = "Viktar Karanevich", date = "15/04/2013", link = "http://your-bug-tracker-link.com", company = "Copy Left")
	@Test(groups = { "Abstract.TC.basic" }, timeOut = 10000, priority = 3,
		  dataProvider = "Abstract.TC")	
	public void testAspectJSpringProxy_PositiveCase(final AbstractTestCase tc, final TCProxy proxy) throws TCException {
		proxy.transform(tc).run();
	}
	
	@History(author = "Viktar Karanevich", date = "15/04/2013", link = "http://your-bug-tracker-link.com", company = "Copy Left")
	@Test(groups = { "Abstract.TC.basic" }, timeOut = 10000, priority = 3,
		  dataProvider = "Abstract.TC.with.LogAspect")	
	public void testAspectJSpringProxy_PositiveCaseWithAspect(final AbstractTestCase tc, final TCProxy proxy) throws TCException {
		proxy.transform(tc).run();
	}
	
	@History(author = "Viktar Karanevich", date = "15/04/2013", link = "http://your-bug-tracker-link.com", company = "Copy Left")
	@Test(groups = { "Abstract.TC.basic" }, timeOut = 10000, priority = 3,
		  dataProvider = "Abstract.TC.with.ConstructorParameter")	
	public void testAspectJSpringProxy_PositiveCaseWithConstructorParameter(final AbstractTestCase tc, final TCProxy proxy, final String expected) throws TCException {
		ITestCase tcProxy = proxy.transform(tc);	
		String actual = ((AbstractTestCase) tcProxy).getId();
		
		tcProxy.run();
		
		assertEquals(expected, actual);
	}
}

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
package com.organization.automation.project.spice.mix.aop.aspectjspring;

import org.junit.Assert;
import org.junit.Test;

import com.organization.automation.project.spice.mix.junit.JUnitExtension;
import com.organization.automation.project.spice.mix.junit.test.AbstractTestCase;
import com.organization.automation.project.spice.mix.junit.test.ITestCase;
import com.organization.automation.project.spice.mix.junit.test.TCException;

public class AspectJSpringProxyUnitTests extends JUnitExtension {

	/*
	 * Positive cases.
	 */
	@Test
	public void testAspectJSpringProxy_PositiveCase() throws TCException {
		ITestCase tc = new AbstractTestCase();
		TCProxy proxy = new TCProxy();
		proxy.transform(tc).run();
	}
	
	@Test
	public void testAspectJSpringProxy_PositiveCaseWithAspect() throws TCException {
		ITestCase tc = new AbstractTestCase();
		TCProxy proxy = new TCProxy(new LogAspect());
		proxy.transform(tc).run();
	}
	
	@Test
	public void testAspectJSpringProxy_PositiveCaseWithConstructorParameter() throws TCException {
		String expected = "100";
		String actual   = "0";
		
		ITestCase tc = new TCSample(expected);
		TCProxy proxy = new TCProxy();
		ITestCase tcProxy = proxy.transform(tc);
		
		actual = ((AbstractTestCase) tcProxy).getId();
		tcProxy.run();
		
		Assert.assertEquals(expected, actual);
	}
}

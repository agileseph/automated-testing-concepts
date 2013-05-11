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
package com.organization.automation.project.spice.mix.aop.spring;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

import com.organization.automation.project.spice.mix.testng.test.ITestCase;

public class TCProxy {

	private ProxyFactory factory;
	
	private final Advice logAdvice;
	
	public TCProxy() {	
		logAdvice = new LogAroundAdvice();
	}

	public TCProxy(Advice advice) {	
		logAdvice = advice;
	}
	
	public ITestCase transform(ITestCase tc) {
		// initialization
		factory = new ProxyFactory();
		Class<?>[] interfaces = new Class[]{ITestCase.class};
		
		// set up factory
		factory.setTarget(tc);
		factory.setInterfaces(interfaces);
		factory.addAdvice(logAdvice);
		factory.setExposeProxy(true);
		
		return (ITestCase) factory.getProxy(); 
	}
}

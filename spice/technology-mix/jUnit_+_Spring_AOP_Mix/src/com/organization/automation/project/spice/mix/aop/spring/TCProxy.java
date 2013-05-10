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

import com.organization.automation.project.spice.mix.junit.test.ITestCase;

public class TCProxy {

	private final ProxyFactory factory;
	
	private final Advice logAdvice;
	
	public TCProxy() {	
		factory = new ProxyFactory();
		logAdvice = new LogAroundAdvice();
	}

	public TCProxy(Advice advice) {	
		factory = new ProxyFactory();
		logAdvice = advice;
	}
	
	public ITestCase transform(ITestCase tc) {
		// initialization
		Class<?>[] interfaces = new Class[]{ITestCase.class};
		
		// set up factory
		factory.setTarget(tc);
		factory.setInterfaces(interfaces);
		factory.addAdvice(logAdvice);
		factory.setExposeProxy(true);
		
		return (ITestCase) factory.getProxy(); 
	}
}

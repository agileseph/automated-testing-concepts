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

import java.util.Locale;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;

public class LogAroundAdvice implements MethodInterceptor {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	private static final String LOG_BEFORE_TEST_STEP = "[TEST]        [POINT] %s ";
	private static final String LOG_AFTER_TEST_STEP  = "[TEST]                                                  OK";

	private static final String TC_METHOD_RUN = "run";
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// Logging Policy: 1. log before -> 2. method run -> 3. log after
		String methodName = invocation.getMethod().getName();

		// #1: log before
		logBefore(methodName);

		// #2: method run
		Object returnValue = invocation.proceed();

		// #3: log after
		logAfter(methodName);

		return returnValue;
	}
	
	private void logBefore(String methodName) {
		if (methodName.equalsIgnoreCase(TC_METHOD_RUN)) {
			LOGGER.info("[TEST]");
			LOGGER.info("[TEST]        Control points: ");
			LOGGER.info("[TEST]");
		} else {
			String log = String.format(LOG_BEFORE_TEST_STEP, methodName.toLowerCase(Locale.UK));
			LOGGER.info(log);
		}
	}

	private void logAfter(String methodName) {
		if (!methodName.equalsIgnoreCase(TC_METHOD_RUN)) {
			LOGGER.info(LOG_AFTER_TEST_STEP);
		}
	}	
}

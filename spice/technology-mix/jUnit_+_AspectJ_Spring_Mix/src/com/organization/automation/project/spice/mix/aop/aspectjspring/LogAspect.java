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

import java.util.Locale;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;

@Aspect
public class LogAspect {
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	private static final String LOG_BEFORE_TEST_STEP = "[TEST]        [POINT] %s ";
	private static final String LOG_AFTER_TEST_STEP  = "[TEST]                                                  OK";

	/*
	 * Pointcuts
	 */
	@Pointcut("execution(@com.organization.automation.project.spice.mix.aop.aspectjspring.LogStep * *(..))")
	public void annotatedTestStepExecution() {
	}
	
	@Pointcut("execution(@com.organization.automation.project.spice.mix.aop.aspectjspring.LogRun * *(..))")
	public void annotatedTestRunMethod() {
	}
	
	/*
	 * Advices
	 */
	@Before("annotatedTestRunMethod()")
	public void logTestRun(JoinPoint jp) {
		logBeforeRun();
	}
	
	@Around("annotatedTestStepExecution()")
	public Object logTestStep(ProceedingJoinPoint pjp) throws Throwable {
		// Logging Policy: 1. log before -> 2. method run
		String methodName = pjp.getSignature().getName();

		// #1: log before
		logBefore(methodName);

		// #2: method run
		Object returnValue = pjp.proceed();

		// #3: log after
		logAfter();
		
		return returnValue;
	}
	
	private void logBeforeRun() {
		LOGGER.info("[TEST]");
		LOGGER.info("[TEST]        Control points: ");
		LOGGER.info("[TEST]");
	}
	
	private void logBefore(String methodName) {
		String log = String.format(LOG_BEFORE_TEST_STEP, methodName.toLowerCase(Locale.UK));
		LOGGER.info(log);
	}

	private void logAfter() {
		LOGGER.info(LOG_AFTER_TEST_STEP);
	}
}

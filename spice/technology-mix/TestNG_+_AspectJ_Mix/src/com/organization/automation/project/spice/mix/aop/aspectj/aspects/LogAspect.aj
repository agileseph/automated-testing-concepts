package com.organization.automation.project.spice.mix.aop.aspectj.aspects;

import java.util.Locale;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public aspect LogAspect {
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	private static final String LOG_BEFORE_TEST_STEP = "[TEST]         [POINT] %s ";
	private static final String LOG_AFTER_TEST_STEP  = "[TEST]                                                  OK";

	/*
	 * Pointcuts
	 */
	pointcut annotatedTestRunMethod()
		: execution(@com.organization.automation.project.spice.mix.aop.aspectj.LogRun * *(..));

	pointcut annotatedTestStepMethod()
		: execution(@com.organization.automation.project.spice.mix.aop.aspectj.LogStep * *(..));

	/*
	 * Advices
	 */
	before() : annotatedTestRunMethod() {
		logBeforeRun();
	}
	
	Object around() : annotatedTestStepMethod() {
		// Logging Policy: 1. log before -> 2. method run
		String methodName = thisJoinPointStaticPart.getSignature().getName();

		// #1: log before
		logBefore(methodName);

		// #2: method run
		Object returnValue = proceed();

		// #3: log after
		logAfter();
		
		return returnValue;
	}
	
	private void logBeforeRun() {
		LOGGER.info("[TEST]");
		LOGGER.info("[TEST]         Control points: ");
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

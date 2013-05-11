package com.organization.automation.project.spice.mix.aop.aspectj.aspects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public aspect FeatureLogAspect {
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	private static final String LOG_BEFORE_TEST_STEP = "[TEST]        [POINT] %s ";
	private static final String LOG_AFTER_TEST_STEP  = "[TEST]                                                  OK";

	private static final String TC_METHOD_SET_UP = "setup";
	private static final String TC_METHOD_STEPS  = "steps";
	private static final String TC_METHOD_CHECK  = "check";
	
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
		// Logging Policy: 1. log before -> 2. method run -> 3. log after

		// initialization
		String methodName = thisJoinPoint.getSignature().getName();
		Object target = thisJoinPoint.getTarget();
		
		// #1: log before
		logBefore(target, methodName);

		// #2: method run
		Object returnValue = proceed();

		// #3: log after
		logAfter(target, methodName);

		return returnValue;
	}
	
	private void logBeforeRun() {
		LOGGER.info("[TEST]");
		LOGGER.info("[TEST]        Control points: ");
		LOGGER.info("[TEST]");
	}
	
	private void logBefore(Object target, String methodName) {
		String log = String.format(LOG_BEFORE_TEST_STEP, methodName.toLowerCase(Locale.UK));
		LOGGER.info(log);
		
		if (methodName.equalsIgnoreCase(TC_METHOD_CHECK)) {
			LOGGER.info("[TEST]         expected: " + dynamicCall(target, "getExpected").toString());
			LOGGER.info("[TEST]         actual:   " + dynamicCall(target, "getActual").toString());
		}
		if (methodName.equalsIgnoreCase(TC_METHOD_STEPS)) {
			LOGGER.info("[TEST]         1. actor add");
		}		
	}

	private void logAfter(Object target, String methodName) {		
		if (methodName.equalsIgnoreCase(TC_METHOD_SET_UP)) {
			LOGGER.info("[TEST]         a = " + dynamicCall(target, "getA"));
			LOGGER.info("[TEST]         b = " + dynamicCall(target, "getB"));
		}
		
		LOGGER.info(LOG_AFTER_TEST_STEP);
	}
	
	private Object dynamicCall(Object target, String method) {
		Object returnValue = null;

		try {
			Method m = target.getClass().getMethod(method, new Class[] { });
			returnValue = m.invoke(target, new Object[] { });
		} catch (NoSuchMethodException e) {
			handle(e);
		} catch (InvocationTargetException e) {
			handle(e);
		} catch (IllegalAccessException e) {
			handle(e);
		} catch (IllegalArgumentException e) {
			handle(e);
		}

		return returnValue;
	}
	
	private void handle(Exception e){
		LOGGER.error("[FeatureLogAspect] exception: " + e.toString());
	}
}

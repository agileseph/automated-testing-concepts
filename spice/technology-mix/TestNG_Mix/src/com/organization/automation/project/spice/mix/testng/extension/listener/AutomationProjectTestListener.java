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
package com.organization.automation.project.spice.mix.testng.extension.listener;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.organization.automation.project.spice.mix.testng.extension.annotations.AnnotationProcessor;
import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public class AutomationProjectTestListener extends TestListenerAdapter {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	
	private final AnnotationProcessor processor = new AnnotationProcessor();
		
	@Override
	public void onTestFailure(ITestResult tr) {
		LOGGER.info("[TEST]         -------------------------------------------------------------------");
		LOGGER.info("[TEST]                                                                    [ " + getResult(tr.getStatus()) + " ]");	

		super.onTestFailure(tr);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		LOGGER.info("[TEST]         -------------------------------------------------------------------");
		LOGGER.info("[TEST]                                                                    [ " + getResult(tr.getStatus()) + " ]");	

		super.onTestSuccess(tr);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("[TEST]         Description: " + result.getName());	

		processor.processCustomAnnotations(result.getMethod().getConstructorOrMethod().getMethod());
		
		super.onTestStart(result);
	}
	
	private String getResult(int status) {
		return (status == 1) ? "PASS" : "FAIL";
	}
}

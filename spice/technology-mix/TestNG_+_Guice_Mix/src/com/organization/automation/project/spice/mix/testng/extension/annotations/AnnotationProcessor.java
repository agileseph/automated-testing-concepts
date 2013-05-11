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
package com.organization.automation.project.spice.mix.testng.extension.annotations;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

public class AnnotationProcessor {
	
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	
	private String testName;
	
	public void processCustomAnnotations(Method method) {
		testName = method.getName();
		
		History history = method.getAnnotation(History.class);
		process(history);			
	}

	private void process(History annotation) {
		if ((annotation != null) && annotation.enable()) {
			LOGGER.info("[TEST] ***************************************************************************************");
			LOGGER.info("[TEST] * Test '" + testName + "'"); 
			LOGGER.info("[TETS] * created by '" + annotation.author() + 
							    "' on date '" + annotation.date() + 
							    "' at " + annotation.company());
			LOGGER.info("[TEST] ***************************************************************************************");
		}
	}
}

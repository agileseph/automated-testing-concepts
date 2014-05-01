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
package com.organization.automation.project.tests.extension.junit;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnitExtension {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JUnitExtension.class);
	private static final AnnotationProcessor PROCESSOR = new AnnotationProcessor();
	
	@Rule
	public TestWatcher watchman = new TestWatcher() {
		
		@Override
		protected void starting(Description description) {
			super.starting(description);
			
			LOGGER.info("[Test]         -------------------------------------------------------------");
			LOGGER.info("[Test]         [BEFORE] Each TC via TestWatcher");
			LOGGER.info("[Test]         [Description] " +  description.getMethodName());
			
			PROCESSOR.processCustomAnnotations(description);
		}
		
		@Override
		protected void succeeded(Description description) {
			LOGGER.info("[Test]         [AFTER] Each TC via TestWatcher");
			LOGGER.info("[Test]                                                      Status: [ PASS ]");
			LOGGER.info("[Test]         -------------------------------------------------------------");
			
			super.succeeded(description);
		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			LOGGER.info("[Test]         [AFTER] Each TC via TestWatcher");
			LOGGER.info("[Test]                                                      Status: [ FAIL ]");
			LOGGER.info("[Test]         -------------------------------------------------------------");
			LOGGER.error("[Test]         [Error] " + e.getMessage());
			e.printStackTrace();

			super.failed(e, description);
		}		
	};
}

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

import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationProcessor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JUnitExtension.class);
	
	public void processCustomAnnotations(Description desc) {
		LOGGER.info("[Annotations]                 custom annotations are processing ...");
		History history = desc.getAnnotation(History.class);
		process(history);
			
		TestFixture testFixture = desc.getAnnotation(TestFixture.class);
		process(testFixture);			
		LOGGER.info("[Annotations]                                                         [ OK ]");
	}

	private void process(History history) {
		// TODO: stub implementation
	}
	
	private void process(TestFixture testFixture) {
		// TODO: stub implementation
	}
}

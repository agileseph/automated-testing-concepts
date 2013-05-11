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
package com.organization.automation.project.spice.mix.bdd.jbehave.extension.runner;

import org.jbehave.core.junit.AnnotatedPathRunner;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class ReportingAnnotatedPathRunner extends AnnotatedPathRunner {

	public ReportingAnnotatedPathRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
	}

	@Override
	public void run(RunNotifier notifier) {
		super.run(notifier);
	}
}

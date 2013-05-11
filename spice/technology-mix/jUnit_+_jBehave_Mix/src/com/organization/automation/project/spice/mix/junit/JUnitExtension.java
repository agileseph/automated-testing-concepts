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
package com.organization.automation.project.spice.mix.junit;

import java.math.BigInteger;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.organization.automation.project.spice.mix.junit.extension.annotations.AnnotationProcessor;
import com.organization.automation.project.spice.mix.junit.system.TestSystem;

public class JUnitExtension {

    // support of custom annotations for: numbers a, b and BigInteger expected
	protected int a;
	protected int b;
	protected BigInteger expected;

	private final AnnotationProcessor processor = new AnnotationProcessor();

	@Rule
	public TestRule watchman = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			onTCStart(description);

			super.starting(description);
		}

		@Override
		protected void succeeded(Description description) {
			super.succeeded(description);

			onTCPass();
		}

		@Override
		protected void failed(Throwable e, Description description) {
			super.failed(e, description);

			onTCFail();
		}

		private void onTCStart(Description description) {
			TestSystem.logOnTCStart(description.getMethodName());

			processor.process(description);
			init();
		}

		private void onTCPass() {
			TestSystem.logOnTCPass();
		}

		private void onTCFail() {
			TestSystem.logOnTCFail();
		}

		// init annotated variables
		private void init() {
			a = processor.getA();
			b = processor.getB();
			expected = processor.getExpected();
		}
	};
}

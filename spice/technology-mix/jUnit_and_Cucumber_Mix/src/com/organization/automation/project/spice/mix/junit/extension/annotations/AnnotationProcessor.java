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
package com.organization.automation.project.spice.mix.junit.extension.annotations;

import java.math.BigInteger;

import org.junit.runner.Description;

public class AnnotationProcessor {

	private int a;
	private int b;
	
	private BigInteger expected;
	
	// process custom annotations: TestFixture, ...
	public void process(Description description) {
		TestFixture tf = description.getAnnotation(TestFixture.class);
		process(tf);		
	}

	private void process(TestFixture tf) {
		if (tf != null) {
			a = tf.a();
			b = tf.b();
			expected = new BigInteger(tf.expected());
		}
	}
	
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public BigInteger getExpected() {
		return expected;
	}
}

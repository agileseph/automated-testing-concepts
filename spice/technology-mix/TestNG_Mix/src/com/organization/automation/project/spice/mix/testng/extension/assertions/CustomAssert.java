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
package com.organization.automation.project.spice.mix.testng.extension.assertions;

import java.math.BigInteger;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

public final class CustomAssert {
	
	private static final String VALUE_NOT_FOUND = "Custom exclusion.";
	private static final String EMPTY_STRING    = "";
	
	private static final int BIG_INTEGER_EQUALITY_CODE = 0;
	
	/**
	 * Protect constructor since it is a static final class.
	 */
    private CustomAssert() {
    }
	
	public static void assertEquals(String msg, BigInteger expected, BigInteger actual) {
		assertTrue(expected.compareTo(actual) == BIG_INTEGER_EQUALITY_CODE, msg);
	}
	
	public static void assertNotEmpty(String object) {
		assertNotNull(object);
		assertNotSame(object, EMPTY_STRING);
		assertNotSame(object, VALUE_NOT_FOUND);
	}

	public static void assertNotEmpty(String[] objects) {
		for (String object : objects) {
			assertNotEmpty(object);
		}		
	}
}

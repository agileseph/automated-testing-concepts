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

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.organization.automation.project.spice.mix.testng.extension.logging.TAFLoggerFactory;

import static com.organization.automation.project.spice.mix.testng.extension.assertions.CustomAssert.assertEquals;

@Test(groups = { "CustomAssertTests" })
public class CustomAssertUnitTests {
	
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	
	private static final String MSG = "Actual number should be equal expected.";
	
	@Parameters({ "test-set_unit-tests" })
	@BeforeClass
	public void setUpAllTests(final String name) {
		LOGGER.info("[SET]          ===================================================================");
		LOGGER.info("[SET]                      Test Set: " + name);
		LOGGER.info("[SET]          ===================================================================");
	}
	
	/*
	    Positive cases.
	 */
	@Test
	public void testBigIntegerAssert_smallNumbersCase() {
		BigInteger expected = new BigInteger("1");
		BigInteger actual   = new BigInteger("1");
		
		assertEquals(MSG, expected, actual);
	}

	@Test
	public void testBigIntegerAssert_bigNumbersCase() {
		BigInteger expected = new BigInteger("2147483648");
		BigInteger actual   = new BigInteger("2147483648");
		
		assertEquals(MSG, expected, actual);
	}

	@Test
	public void testBigIntegerAssert_bigNumbersEqualObjectCase() {
		BigInteger expected = new BigInteger("2147483648");
		BigInteger actual   = expected;
		
		assertEquals(MSG, expected, actual);
	}
	
	
	/*
    	Negative cases.
	 */
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_smallNumbersMoreCase() {
		BigInteger expected = new BigInteger("1");
		BigInteger actual   = new BigInteger("3");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_smallNumbersLessCase() {
		BigInteger expected = new BigInteger("3");
		BigInteger actual   = new BigInteger("1");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_bigNumbersMoreCase() {
		BigInteger expected = new BigInteger("2147483648");
		BigInteger actual   = new BigInteger("3147483648");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_bigNumbersLessCase() {
		BigInteger expected = new BigInteger("3147483648");
		BigInteger actual   = new BigInteger("2147483648");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_mixNumbersMoreCase() {
		BigInteger expected = new BigInteger("3");
		BigInteger actual   = new BigInteger("3147483648");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_mixNumbersLessCase() {
		BigInteger expected = new BigInteger("3147483648");
		BigInteger actual   = new BigInteger("3");
		
		assertEquals(MSG, expected, actual);
	}
	
	@Test(expectedExceptions = { AssertionError.class })
	public void testBigIntegerAssert_smallNumbersNegativeCase() {
		BigInteger expected = new BigInteger("3");
		BigInteger actual   = new BigInteger("-3");
		
		assertEquals(MSG, expected, actual);
	}
}

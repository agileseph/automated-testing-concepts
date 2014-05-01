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
package com.organization.automation.project.utility;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;

public class DataGenerator {
	private static final String EMAIL_POSTFIX     = "@test.com";
	private static final int    EMAIL_NAME_LENGTH = 8;
	
	public String getRandomUUID() {
		return UUID.randomUUID().toString();
	}
	
	public String getRandomEmail() {
		return RandomStringUtils.random(EMAIL_NAME_LENGTH, true, true).toLowerCase() + EMAIL_POSTFIX;
	}
	
	public int getRandomNumber(int min, int max) {
		final int result = min + new Random().nextInt(max - min);
		
		return result;
	}
}
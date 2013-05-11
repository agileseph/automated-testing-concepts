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
package com.organization.automation.project.spice.mix.testng.extension.logging;

import org.apache.log4j.Level;

public class CustomLevels extends Level {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275500487601517412L;

	private static final int LOW_GAP = 5001;
	private static final int BIG_GAP = 50001;

	public static final String FULL_DETAILED_TRACE_NAME = "FULL_DETAILED_TRACE";
	public static final String DEMO_TRACE_NAME          = "DEMO_TRACE";

	public static final int FULL_DETAILED_TRACE_INT = TRACE_INT - LOW_GAP;
	public static final int DEMO_TRACE_INT          = FATAL_INT + BIG_GAP;

	public static final Level FULL_DETAILED_TRACE = new CustomLevels(FULL_DETAILED_TRACE_INT,
			FULL_DETAILED_TRACE_NAME, 7);
	
	public static final Level DEMO_TRACE = new CustomLevels(DEMO_TRACE_INT,
			DEMO_TRACE_NAME, 8);
		
	protected CustomLevels(int arg0, String arg1, int arg2) {
		super(arg0, arg1, arg2);
	}

	public static Level toLevel(String sArg) {
		Level result = (Level) toLevel(sArg, Level.DEBUG);

		if ((sArg != null) && (sArg.equalsIgnoreCase(DEMO_TRACE_NAME))) {
			result = DEMO_TRACE;
		}
		if ((sArg != null) && (sArg.equalsIgnoreCase(FULL_DETAILED_TRACE_NAME))) {
			result = FULL_DETAILED_TRACE;
		}

		return result;
	}

	public static Level toLevel(int val) {
		Level result = (Level) toLevel(val, Level.DEBUG);
		
		if (val == DEMO_TRACE_INT) {
			result = DEMO_TRACE;
		}
		if (val == FULL_DETAILED_TRACE_INT) {
			result = FULL_DETAILED_TRACE;
		}
		
		return result;
	}

	public static Level toLevel(int val, Level defaultLevel) {
		Level result = Level.toLevel(val, defaultLevel);
		
		if (val == DEMO_TRACE_INT) {
			result = DEMO_TRACE;
		}
		if (val == FULL_DETAILED_TRACE_INT) {
			result = FULL_DETAILED_TRACE;
		}
		
		return result;
	}

	public static Level toLevel(String sArg, Level defaultLevel) {
		Level result = Level.toLevel(sArg, defaultLevel);
		
		if ((sArg != null) && (sArg.equalsIgnoreCase(DEMO_TRACE_NAME))) {
			result = DEMO_TRACE;
		}
		if ((sArg != null) && (sArg.equalsIgnoreCase(FULL_DETAILED_TRACE_NAME))) {
			result = FULL_DETAILED_TRACE;
		}
		
		return result;
	}	
}

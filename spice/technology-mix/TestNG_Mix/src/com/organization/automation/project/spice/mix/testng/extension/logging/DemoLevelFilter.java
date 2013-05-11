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
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

// skip demo logging level if it is not set up
public class DemoLevelFilter extends Filter {

	public int decide(LoggingEvent event) {
	    int result = Filter.ACCEPT;
	    
	    Level setUpLevel = event.getLogger().getLevel();
	    
	    //obtaining the message object passed through Logger
	    int currentLevelInt = event.getLevel().toInt();

	    //checking if the message object is of correct type
	    if (setUpLevel.toInt() == CustomLevels.DEMO_TRACE_INT) {
	        result = Filter.NEUTRAL;
	    } else {
	    	if (currentLevelInt == CustomLevels.DEMO_TRACE_INT) {
	    		result = Filter.DENY;
	    	}
	    }

	    return result;
	}
}

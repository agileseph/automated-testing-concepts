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
package com.organization.automation.project.architecture.model;

import java.util.ArrayList;
import java.util.List;

public class SUT {
	List<ITAFListener> listeners = new ArrayList<ITAFListener>();

	public void addListener(ITAFListener listener) {
		listeners.add(listener);
	}

	public void changeState() {
		System.out.println("Hello, Dear! SUT has been changed the state.");
		System.out.println("Call it magic / Call it true / I call it magic, / when I'm with you. @Coldplay - Magic");
		System.out.println();

		// Notify all ITAF Listeners.
		for (ITAFListener listener : listeners) {
			listener.SUTStateChanged();
		}
	}
}

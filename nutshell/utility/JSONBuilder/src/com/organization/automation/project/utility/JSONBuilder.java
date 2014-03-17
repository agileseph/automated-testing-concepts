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

import org.json.JSONObject;

public class JSONBuilder {

	private final JSONObject    source;	
	private final DataGenerator generator;
	
	public JSONBuilder() {
		source    = new JSONObject();
		generator = new DataGenerator();
	}
	
	public JSONObject build() {
		return source;
	}
	
	public JSONBuilder addID() {
		source.put(Parameter.ID, generator.getRandomUUID());
		return this;
	}
	
	public JSONBuilder addID(String value) {
		source.put(Parameter.ID, value);
		return this;
	}
	
	public JSONBuilder addStatus(String value) {
		source.put(Parameter.CustomParameter.STATUS, value);
		return this;
	}
	
	public JSONBuilder addEmail() {
		source.put(Parameter.CustomParameter.EMAIL, generator.getRandomEmail());
		return this;
	}
	
	public JSONBuilder addEmail(String value) {
		source.put(Parameter.CustomParameter.EMAIL, value);
		return this;
	}
	
	public JSONBuilder addField(String name, String value) {
		source.put(name, value);
		return this;
	}
	
	public JSONBuilder addObject(String name, JSONObject object) {
		source.put(name, object);
		return this;
	}
}

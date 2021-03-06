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
package com.organization.automation.project.spice.mix.bdd.jbehave;

import java.util.List;

import org.junit.runner.RunWith;

import com.organization.automation.project.spice.mix.junit.extension.annotations.RunWithin;
import com.organization.automation.project.spice.mix.junit.extension.monitoring.MultiEnvironmentRunner;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWithin(eclipse = JUnitReportingRunner.class)
@RunWith(MultiEnvironmentRunner.class)
public class AbstractTCStory_UnitTests extends AbstractTCStories {
	
	@Override
	protected List<String> storyPaths() {
		return super.storyPaths();
	}
}

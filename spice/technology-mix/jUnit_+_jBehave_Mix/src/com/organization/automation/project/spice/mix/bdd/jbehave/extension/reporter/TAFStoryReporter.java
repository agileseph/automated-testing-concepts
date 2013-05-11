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
package com.organization.automation.project.spice.mix.bdd.jbehave.extension.reporter;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;

public class TAFStoryReporter implements StoryReporter {

	private static final Logger LOGGER = TAFLoggerFactory.getLogger();

	@Override
	public void successful(String step) {
		LOGGER.info("             " + format(step));
		LOGGER.info("                                                                          OK ");
	}

	@Override
	public void failed(String step, Throwable t) {
		LOGGER.error("[FAILED] step: " + step);
		LOGGER.error("[FAILED] reason: " + t);
	}

	@Override
	public void afterExamples() {
		LOGGER.info(" [EXAMPLES]");
		LOGGER.info("                                                                    [ DONE ] ");		
	}

	@Override
	public void afterScenario() {
		//LOGGER.info("[AFTER_SCENARIO]");
		LOGGER.info(" [SCENARIO]");
		LOGGER.info("                                                                    [ DONE ] ");		
	}

	@Override
	public void afterStory(boolean isGivenStory) {
		//LOGGER.info("[AFTER_STORY] " + isGivenStory);
		LOGGER.info(" [STORY]");
		LOGGER.info("                                                                    [ DONE ] ");		
	}

	@Override
	public void beforeExamples(List<String> steps, ExamplesTable table) {
		LOGGER.info(" [EXAMPLES]");
		LOGGER.info("            General scenario:");
		LOGGER.info("");
		for (String step : steps) {
			LOGGER.info("            " + step);
		}
		LOGGER.info("");

		LOGGER.info("            Table of examples:");
		LOGGER.info("");
		String[] examples = table.asString().split("\n");
		for (int i = 0; i < examples.length; i++) {
			LOGGER.info("            " + examples[i]);
		}
	}

	@Override
	public void beforeScenario(String title) {
		//LOGGER.info("[BEFORE_SCENARIO] " + arg0);
		LOGGER.info(" [SCENARIO]");
		LOGGER.info("             " + title);
		LOGGER.info(" [STEPS]");
	}

	@Override
	public void beforeStep(String step) {
		//LOGGER.info("[BEFORE_STEP] " + step);
		//LOGGER.info(" [Step] ");
		//LOGGER.info("             " + step);
	}

	@Override
	public void beforeStory(Story story, boolean isGivenStory) {
		String fileName = story.getName();
		String path = story.getPath();
		String desc = story.getDescription().asString();
		String meta = story.getMeta().toString();
		
		LOGGER.info(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		LOGGER.info(" [STORY]");
		LOGGER.info("             description:   " + desc);
		LOGGER.info("             file name:     " + fileName);
		LOGGER.info("             relative path: " + path);
		LOGGER.info("             meta info:     " + meta);
	}

	@Override
	public void dryRun() {
		LOGGER.info("[DRY_RUN]");
	}

	@Override
	public void example(Map<String, String> tableCell) {
		LOGGER.info(" [EXAMPLE] ");
		LOGGER.info("             " + tableCell.toString()
														 .replace("{", "[")
														 .replace("}", "]")
														 .replace("=", " = "));
		LOGGER.info("             . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ");
	}

	@Override
	public void failedOutcomes(String arg0, OutcomesTable table) {
		LOGGER.info("[FAILED_OUTCOMES]");
	}

	@Override
	public void givenStories(GivenStories stories) {
		LOGGER.info("[GIVEN_STORIES] " + stories);
	}

	@Override
	public void givenStories(List<String> stories) {
		LOGGER.info("[GIVEN_STORIES]");
	}

	@Override
	public void ignorable(String step) {
		LOGGER.info("[IGNORABLE] " + step);
	}

	@Override
	public void narrative(Narrative narrative) {
		//LOGGER.info("[NARRATIVE] " + arg0);
		String iot = narrative.inOrderTo();
		String asa = narrative.asA();
		String iwt = narrative.iWantTo();
		LOGGER.info(" [NARRATIVE]");
		LOGGER.info("             In order to " + iot);
		LOGGER.info("             As a " + asa);
		LOGGER.info("             I want to " + iwt);
	}

	@Override
	public void notPerformed(String step) {
		LOGGER.info("[NOT_PERFORMED] " + step);
	}

	@Override
	public void pending(String step) {
		LOGGER.info("[PENDING] " + step);
	}

	@Override
	public void pendingMethods(List<String> methods) {
		LOGGER.info("[PENDING_METHODS]");
	}

	@Override
	public void restarted(String step, Throwable t) {
		LOGGER.info("[RESTARTED] " + step + " arg1: " + t);
	}

	@Override
	public void scenarioMeta(Meta meta) {
		//LOGGER.info("[SCENARIO_META] " + meta);
	}

	@Override
	public void scenarioNotAllowed(Scenario scenario, String parameter) {
		LOGGER.info("[SCENARIO_NOT_ALLOWED] " + scenario + " arg1: " + parameter);
	}

	@Override
	public void storyCancelled(Story story, StoryDuration duration) {
		LOGGER.info("[STORY_CANCELLED] " + story + " arg1 " + duration);
	}

	@Override
	public void storyNotAllowed(Story story, String parameter) {
		LOGGER.info("[STORY_NOT_ALLOWED] " + story + " arg1 " + parameter);
	}
	
	// methods for internal using
	private byte[] replace(byte[] source, byte excludedByte, byte replacementByte) {
		byte[] modifiedSource = source;
		
		for (int i = 0; i < source.length; i++) {
			if (source[i] == excludedByte){
				modifiedSource[i] = replacementByte;
			}
		}
		
		return modifiedSource;
	}
	
	/* 
	 * Example:
	 * 		- original string 'Then result of exemplified TC should be [?PASS?]'
	 * 		- target byte is 63, codePoint of '?'
	 * 		- replacement byte is 20, codePoint of 'X'
	 * 		- modified string 'Then result of exemplified TC should be [XPASSX]'
	 * 
	 *		- final result: 'Then result of exemplified TC should be [PASS]'
	 */
	private String format(String originalStr) {
		String result = originalStr;
		byte targetByte = 63;
		byte replacementByte = 20;
		String targetString = new String(new byte[] { replacementByte });
		String replacementString = "";
		
		String modifiedStr = new String(replace(originalStr.getBytes(), targetByte, replacementByte));
		result = modifiedStr.replace(targetString, replacementString);
		
		return result;
	}
}

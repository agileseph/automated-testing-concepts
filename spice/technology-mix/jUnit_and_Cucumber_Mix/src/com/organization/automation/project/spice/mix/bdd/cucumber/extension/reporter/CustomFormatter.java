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
package com.organization.automation.project.spice.mix.bdd.cucumber.extension.reporter;

import java.util.List;

import org.apache.log4j.Logger;

import com.organization.automation.project.spice.mix.junit.extension.logging.TAFLoggerFactory;

import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

public class CustomFormatter implements Formatter, Reporter {
	
	private static final Logger LOGGER = TAFLoggerFactory.getLogger();
	
	private static final String STEP_STATUS = "passed"; 
	
	/*
	 * Formatter
	 */
	@Override
	public void background(Background b) {
	}
	
	@Override
	public void close() {
		LOGGER.info(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
	
	@Override
	public void done() {
		LOGGER.info(" [FEATURE]");
		LOGGER.info("                                                                    [ DONE ] ");
	}
	
	@Override
	public void eof() {
	}
	
	@Override
	public void examples(Examples e) {
	}
	
	@Override
	public void feature(Feature f) {
		LOGGER.info(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		LOGGER.info(" [FEATURE]");

		LOGGER.info("             Description: " + f.getName());
		LOGGER.info("             Tags:        " + f.getTags().get(0).getName());
		
		LOGGER.info(" [NARRATIVE]");
		
		String[] lines = f.getDescription().split("\n");
		for (String line : lines) {
			LOGGER.info("             " + line);
		}
	}
	
	@Override
	public void scenario(Scenario s) {
		LOGGER.info(" [SCENARIO]");
		LOGGER.info("             Description: " + s.getName());
		
		LOGGER.info(" [STEPS]");
	}
	
	@Override
	public void scenarioOutline(ScenarioOutline so) {
		LOGGER.info(" scenario outline: " + so.getDescription());
	}
	
	@Override
	public void step(Step step) {
		LOGGER.info("             " + step.getKeyword() + step.getName());
	}
	
	@Override
	public void syntaxError(String arg0, String arg1, List<String> arg2,
							String arg3, Integer arg4) {
		System.out.println(" syntax error: " + arg0 + " " + arg1 + " " + arg2.toString() + " " + arg3 + " " + arg4);	
	}
	
	@Override
	public void uri(String uri) {
		LOGGER.info(" [INIT]: ");
		LOGGER.info("             Running: " + uri);
	}
	
	/*
	 * Reporter
	 */
	@Override
	public void after(Match m, Result r) {
	}
	
	@Override
	public void before(Match m, Result r) {
	}
	
	@Override
	public void embedding(String arg0, byte[] arg1) {
	}
	
	@Override
	public void match(Match m) {
	}
	
	@Override
	public void result(Result r) {
		if (r.getStatus().equalsIgnoreCase(STEP_STATUS)) {
			LOGGER.info("                                                                          OK ");
		} else {
			LOGGER.info("                                                                        FAIL ");
		}	
	}
	
	@Override
	public void write(String s) {
	}
}

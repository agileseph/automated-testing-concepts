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

import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.XML;

import java.util.Locale;
import java.util.Properties;

import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingPaths;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;

import com.organization.automation.project.spice.mix.bdd.jbehave.AbstractTCStoriesII.CustomStoryControls;
import com.organization.automation.project.spice.mix.bdd.jbehave.AbstractTCStoriesII.CustomReportBuilder;
import com.organization.automation.project.spice.mix.bdd.jbehave.AbstractTCStoriesII.CustomStoryLoader;
import com.organization.automation.project.spice.mix.bdd.jbehave.AbstractTCStoriesII.CustomStoryParser;

import com.organization.automation.project.spice.mix.bdd.jbehave.extension.reporter.TAFStoryReporter;
import com.organization.automation.project.spice.mix.bdd.jbehave.extension.runner.ReportingAnnotatedPathRunner;

@RunWith(ReportingAnnotatedPathRunner.class)
@Configure(storyControls        = CustomStoryControls.class, 
		   storyLoader          = CustomStoryLoader.class, 
		   storyReporterBuilder = CustomReportBuilder.class, 
		   storyParser          = CustomStoryParser.class)
@UsingEmbedder(embedder                 = Embedder.class, 
			   generateViewAfterStories = false, 
			   ignoreFailureInStories   = true, 
			   ignoreFailureInView      = true,
			   storyTimeoutInSecs       = 68, 
			   threads                  = 1, 
			   metaFilters              = "-skip")
@UsingSteps(instances = { AbstractTCSteps.class })
@UsingPaths(searchIn  =   "resources", 
			includes  = { "**/*.story" }, 
			excludes  = { "**/examples_table*.story" })
public class AbstractTCStoriesII {

    public static class CustomStoryControls extends StoryControls {
        public CustomStoryControls() {
        	super();
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }

    public static class CustomStoryLoader extends LoadFromClasspath {
        public CustomStoryLoader() {
            super(Thread.currentThread().getContextClassLoader());
        }
    }

    public static class CustomReportBuilder extends StoryReporterBuilder {
    	private static final Properties RESOURCES = new Properties();
    	
    	public CustomReportBuilder() {
    		super();
            RESOURCES.put("decorateNonHtml", "true");
            
            this.withDefaultFormats()
            	.withFormats(//CONSOLE, 
            				 TXT, 
            				 HTML, 
            				 XML)
            	.withReporters(new TAFStoryReporter())
            	.withViewResources(RESOURCES)
            	.withFailureTrace(true)
            	.withFailureTraceCompression(true)
            	.withCrossReference(new CrossReference());
        }
    }

    public static class CustomStoryParser extends RegexStoryParser {
        public CustomStoryParser() {        	
        	super(new LocalizedKeywords(Locale.ENGLISH));
        }
    }    
}

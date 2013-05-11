/*
 * This little project is designed to make JBehave stories & scenarios show up
 * in the JUnit view in Eclipse and potentially other IDEs that support custom
 * test runners.
 * 
 * For details, please visit https://github.com/codecentric/jbehave-junit-runner 
 */
package de.codecentric.jbehave.junit.monitoring;

import java.util.HashSet;
import java.util.Set;

public class DescriptionTextUniquefier {

	Set<String> strings = new HashSet<String>();

	public String getUniqueDescription(String junitSafeString) {
		while (strings.contains(junitSafeString)) {
			junitSafeString += '\u200B'; // zero-width-space
		}
		strings.add(junitSafeString);
		return junitSafeString;
	}

}

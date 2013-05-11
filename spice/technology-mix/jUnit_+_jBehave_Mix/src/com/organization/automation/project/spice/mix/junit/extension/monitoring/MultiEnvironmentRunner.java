/*
 * For the original idea inspiration, 
 * please visit http://stackoverflow.com/questions/13309392/how-to-use-different-junit-testrunner-in-eclipse-and-ant
 */
package com.organization.automation.project.spice.mix.junit.extension.monitoring;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.organization.automation.project.spice.mix.junit.extension.annotations.RunWithin;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class MultiEnvironmentRunner extends Runner {
    protected Class<?> testClass;
    protected Runner   delegate;
    
    private static final String MAVEN_ARGS = "MAVEN_CMD_LINE_ARGS";
    private static final String ERROR_MSG_ANNOTATION_IS_NULL = MultiEnvironmentRunner.class.getSimpleName() + 
    	" can be used only with test classes, that are annotated with " + 
    	RunWithin.class.getSimpleName() + " annotation somewhere in their class hierarchy!"; 
    
    public MultiEnvironmentRunner(Class<?> testClass) {
        super();
        this.testClass = testClass;
        this.delegate  = getDelegateInstance();        
    }
    
    private Runner getDelegateInstance() {
    	RunWithin annotation = findAnnotationFor(testClass);
    	Class<? extends Runner> delegateClass = recognizeRunner(annotation);
        
        return constructInstanceFor(delegateClass);
    }

    private Runner constructInstanceFor(Class<? extends Runner> clazz) {
    	Runner instance = null;

    	try {
            Constructor<? extends Runner> constructor = clazz.getConstructor(Class.class);
            instance = constructor.newInstance(testClass);
        } catch (NoSuchMethodException e) {
            handle(e, clazz.getName());
        } catch (SecurityException e) {
            handle(e, clazz.getName());
        } catch (InstantiationException e) {
            handle(e, clazz.getName());
        } catch (IllegalAccessException e) {
            handle(e, clazz.getName());
        } catch (IllegalArgumentException e) {
            handle(e, clazz.getName());
        } catch (InvocationTargetException e) {
            handle(e, clazz.getName());
        }
        
        return instance;
    }
    
    private void handle(Exception e, String className) {
    	throw new RuntimeException("While creating " + className + ", it was the error: " + e.toString());
    }
    
	/* By default, 
	 * 		for Maven environment, it should be used JUnit4.class
	 * 		for Eclipse environment, it should be used the custom JUnitReportingRunner.class
	 */
    private Class<? extends Runner> recognizeRunner(RunWithin annotation) {
        Class<? extends Runner> clazz = annotation.defaultRunner();
    	if (!isMavenEnvironment()) {
    		clazz = annotation.eclipse();
        }
        
    	return clazz;
    }
    
    private boolean isMavenEnvironment() {
    	return (System.getenv(MAVEN_ARGS) != null) ? true : false;
    }

    /*
	 * The annotation '@RunWithin' is inherited automatically. For details, please visit:
	 * http://docs.oracle.com/javase/7/docs/api/java/lang/annotation/Inherited.html
	 * 
	 * But for the all TCs Sets classes as Class<? extends JUnitStories> you
	 * should override the method "protected List<String> storyPaths()". Just
	 * include it on the following way:
	 * 
	 * YourAcceptanceTestSet.java: 
	 * =================================================== 
	 * public class YourAcceptanceTestSet extends AcceptanceStories {
	 * 
	 * 		@Override protected List<String> storyPaths() { 
	 * 			return super.storyPaths(); 
	 * 		}
	 * }
	 * ===================================================
	 * 
	 * AcceptanceStories.java: 
	 * ===================================================
	 * @RunWithin
	 * @RunWith(MultiEnvironmentRunner.class) 
	 * public class AcceptanceStories extends AbstractTCStories{
	 * 
	 * 		@Override protected List<String> storyPaths() { 
	 * 			return super.storyPaths(); 
	 * 		} 
	 * }
	 * ===================================================
	 */
    private RunWithin findAnnotationFor(Class<?> testClass) {
        RunWithin annotation = testClass.getAnnotation(RunWithin.class);
        
        // Guard checks
        // #1: annotation should be not null
        assertNotNull(ERROR_MSG_ANNOTATION_IS_NULL, annotation);
        
        return annotation;
    }

    @Override
    public Description getDescription() {
        return delegate.getDescription();
    }

    @Override
    public void run(RunNotifier notifier) {
        delegate.run(notifier);
    }
}

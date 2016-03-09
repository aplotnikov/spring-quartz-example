package org.home.spring.quartz.tasks;

import org.home.spring.quartz.context.AnnotationBasedApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AnnotationBasedApplicationContext.class)
public class ScheduledTest extends AbstractRepeatableTest {

}
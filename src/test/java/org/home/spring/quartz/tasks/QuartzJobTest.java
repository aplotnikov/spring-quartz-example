package org.home.spring.quartz.tasks;

import org.home.spring.quartz.context.ApplicationContext2;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationContext2.class)
@ActiveProfiles("interval")
public class QuartzJobTest extends AbstractRepeatableTest {

}
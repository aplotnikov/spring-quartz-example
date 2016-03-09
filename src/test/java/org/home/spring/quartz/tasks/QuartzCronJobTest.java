package org.home.spring.quartz.tasks;

import org.home.spring.quartz.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationContext.class)
@ActiveProfiles("cron")
public class QuartzCronJobTest extends AbstractRepeatableTest {

}
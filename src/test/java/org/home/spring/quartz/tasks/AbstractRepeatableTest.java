package org.home.spring.quartz.tasks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractRepeatableTest {
    @Before
    public void setUp() throws Exception {
        ScheduleLog.clear();
    }

    @Test
    public void shouldLogObjectContainsNewContentWhenRepeatableJobIsRunning() throws InterruptedException {
        assertThat(ScheduleLog.getStringValue()).isEmpty();

        Thread.sleep(5_000);

        assertThat(ScheduleLog.getStringValue()).contains("I'm printing job...");

        int previousFullLogLength = ScheduleLog.getStringValue().length();

        Thread.sleep(4_000);

        assertThat(ScheduleLog.getStringValue().length()).isGreaterThan(previousFullLogLength);
    }
}

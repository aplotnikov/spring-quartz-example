package org.home.spring.quartz.tasks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractRepeatableTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldLogObjectContainsNewContentWhenRepeatableJobIsRunning() throws InterruptedException {
        assertThat(systemOutRule.getLog()).isEmpty();

        Thread.sleep(5_000);

        assertThat(systemOutRule.getLog()).contains("I'm printing job...");

        int previousFullLogLength = systemOutRule.getLog().length();

        Thread.sleep(4_000);

        assertThat(systemOutRule.getLog().length()).isGreaterThan(previousFullLogLength);
    }
}

package org.home.spring.quartz.tasks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {
    private static final Log LOG = LogFactory.getLog(ScheduledTask.class);

    @Scheduled(fixedDelay = 5_000)
    void doSomething() {
        LOG.info("Appending LOG message into ScheduleLog ...");
        ScheduleLog.append("I'm printing job...\n");
    }
}
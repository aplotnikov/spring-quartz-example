package org.home.spring.quartz.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {
    @Scheduled(fixedDelay = 5_000)
    void doSomething() {
        System.out.println("I'm printing job...");
    }
}
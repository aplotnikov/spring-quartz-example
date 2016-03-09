package org.home.spring.quartz.tasks;

import java.util.TimerTask;

public class PrintingTask extends TimerTask {
    @Override
    public void run() {
        ScheduleLog.append("I'm printing task...\n");
    }
}
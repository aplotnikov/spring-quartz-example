package org.home.spring.quartz.tasks;

import java.util.TimerTask;

public class PrintingTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("I'm printing job...");
    }
}
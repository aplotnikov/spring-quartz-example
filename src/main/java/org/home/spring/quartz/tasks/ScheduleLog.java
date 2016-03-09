package org.home.spring.quartz.tasks;

public class ScheduleLog {
    // TODO refactor it
    private static StringBuilder value = new StringBuilder();

    public static void append(String str) {
        value.append(str);
    }

    public static String getStringValue() {
        return value.toString();
    }

    public static void clear() {
        value = new StringBuilder();
    }

}
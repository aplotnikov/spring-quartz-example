package org.home.spring.quartz.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "org.home.spring.quartz.tasks")
@EnableAsync
@EnableScheduling
public class ApplicationContext {

}

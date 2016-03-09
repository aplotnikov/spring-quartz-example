package org.home.spring.quartz.context;

import org.home.spring.quartz.tasks.PrintingJob;
import org.quartz.Trigger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import javax.annotation.Nonnull;
import javax.inject.Named;

@Configuration
@ComponentScan(basePackages = "org.home.spring.quartz.tasks")
public class ApplicationContext2 {
    @Bean
    @Nonnull
    public JobDetailFactoryBean aPrintReportFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();

        jobDetailFactoryBean.setJobClass(PrintingJob.class);

        return jobDetailFactoryBean;
    }

    @Profile("interval")
    @Bean(name = "aReportTrigger")
    @Nonnull
    public FactoryBean<? extends Trigger> aSimpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();

        simpleTriggerFactoryBean.setJobDetail(
                aPrintReportFactoryBean().getObject()
        );
        simpleTriggerFactoryBean.setStartDelay(1_000);
        simpleTriggerFactoryBean.setRepeatInterval(5_000);

        return simpleTriggerFactoryBean;
    }

    @Profile("cron")
    @Bean(name = "aReportTrigger")
    @Nonnull
    public FactoryBean<? extends Trigger> aCronTriggerBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();

        cronTriggerFactoryBean.setJobDetail(
                aPrintReportFactoryBean().getObject()
        );
        cronTriggerFactoryBean.setCronExpression("0/3 * * ? * *");

        return cronTriggerFactoryBean;
    }

    @Bean
    @Nonnull
    public SchedulerFactoryBean aSchedulerFactoryBean(@Named("aReportTrigger") FactoryBean<? extends Trigger> aReportTrigger) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        schedulerFactoryBean.setTriggers(
                aReportTrigger.getObject()
        );

        return schedulerFactoryBean;
    }
}

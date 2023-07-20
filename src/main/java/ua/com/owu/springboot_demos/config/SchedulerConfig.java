package ua.com.owu.springboot_demos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Async
public class SchedulerConfig {

    @Scheduled(fixedDelay = 1000)
    public void someJob() {
        System.out.println("some job");

    }
}

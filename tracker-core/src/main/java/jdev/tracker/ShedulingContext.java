package jdev.tracker;

import jdev.services.DataSendService;
import jdev.services.DataStoreService;
import jdev.services.ServiceGPS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class ShedulingContext {
    @Bean
    public ServiceGPS serviceGPS() {
        return new ServiceGPS();
    }

    @Bean DataStoreService storeService()
    {
        return new DataStoreService();
    }

    @Bean
    DataSendService sendService()
    {
        return new DataSendService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}

package jdev.tracker;

import jdev.services.ServiceGPS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ShedulingContext {
    @Bean
    public ServiceGPS serviceGPS() {
        return new ServiceGPS();
    }
}

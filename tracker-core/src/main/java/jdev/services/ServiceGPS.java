package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ServiceGPS {
    private int count;
    private int count1;

    @Scheduled (cron = "*/1 * * * * *")
    private void tick() throws Exception {
        PointDTO point = new PointDTO();
        point.setAlt(25.0);
        point.setLat(35.0+count1++);
        point.setLon(45.0+count1++);
        point.setSpeed(65);
        System.out.println(count++ + "--"+point.toJson());
    }
}

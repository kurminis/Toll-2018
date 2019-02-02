package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class ServiceGPS {

    private static Logger log = Logger.getLogger(ServiceGPS.class.getName());

// Подключаем зависимость сохранение данных
    @Autowired
    private DataStoreService dataStoreService;
    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(30);
    private int count;
    private int count1;

//Каждую секунду получаем данные и складываем в очередь
    @Scheduled (fixedDelay = 1000)
    void tick() throws Exception {
        log.info("---Получаем координаты и складываем в очередь каждую 1 секунду---");
        PointDTO point = new PointDTO();
        point.setAlt(25.0);
        point.setLat(35.0+count1++);
        point.setLon(45.0+count1++);
        point.setSpeed(65);
        log.info("Координаты-"+point.toJson()); //Получаем координаты
        queue.put(point.toJson()); //Складываем координаты в очередь
    }

// Каждую секунду отправляем данные в хранилище
    @Scheduled (fixedDelay = 1000, initialDelay = 3000)
    void store() throws Exception {
        log.info("---Сохраняем координаты---");
            dataStoreService.saveData(queue);
    }
}

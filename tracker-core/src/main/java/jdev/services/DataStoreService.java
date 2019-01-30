package jdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class DataStoreService {
    private static Logger log = Logger.getLogger(ServiceGPS.class.getName());
//Подключаем зависимость - отправка данных на сервер (выводим в консоль)
    @Autowired
    private DataSendService dataSendService;

    private BlockingDeque<String> queue_store = new LinkedBlockingDeque<>(30);  // очередь хранения полученных координат

    public void saveData(BlockingDeque<String> queue) throws Exception {
        queue_store.put(queue.poll());
        log.info("Сохраняю данные. Размер очереди = "+queue_store.size());
    }

//Каждые 10 секунд отправляем данные на сервер (выводим в консоль)
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    void savedata() throws Exception {
        dataSendService.sendData(queue_store);
    }

}

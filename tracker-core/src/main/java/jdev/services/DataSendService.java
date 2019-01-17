package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;

@Service
public class DataSendService {

// Выводим очередь в консоль
    public void sendData(BlockingDeque<String> queue) throws InterruptedException {
        System.out.println("Отправляю данные. Размер данных = "+queue.size());
        while (queue.size()>0) {
            System.out.println("Очередь"+queue.poll());
        }
    }
}

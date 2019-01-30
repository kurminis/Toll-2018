package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.commons.io.IOUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.BlockingDeque;
import java.util.logging.Logger;

@Service
public class DataSendService {
    private static Logger log = Logger.getLogger(ServiceGPS.class.getName());
// Отправляем очередь на server-core
    public void sendData(BlockingDeque<String> queue) throws IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        log.info("<<<<<<<<<<<<<<<<<<--Отправляю данные. Размер данных = "+queue.size()+"-->>>>>>>>>>>>>>>>");
        PointDTO point1 = new PointDTO();
        String outputData="null";  //Доп переменная для отправки пустых данных для проверки ответа от сервера

        // Отправляем пустые данные для проверки на неполучение данных и ответа false
        String responseData=restTemplate.postForObject("http://localhost:8080/counter",outputData,String.class);
        log.info(responseData);

        //выбираем все данные из очереди (сохраненные данные) и отправляем на server-core
        while (queue.size()>0) {
            String responseData1=restTemplate.postForObject("http://localhost:8080/counter",queue.poll(),String.class);
            log.info(responseData1);
        }
    }
}

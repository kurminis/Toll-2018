package jdev.tracker;

import jdev.dto.PointDTO;
import org.springframework.web.client.RestTemplate;


//класс тестового запроса
public class TestRequest {
    public static void main(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String str="null";
        PointDTO point1 = new PointDTO();
        point1.setAlt(228.0);
        point1.setLat(135.0);
        point1.setLon(145.0);
        point1.setSpeed(85);
        str=point1.toJson();
        System.out.println(point1.getAlt());
        String resultall=restTemplate.postForObject("http://localhost:8080/counter",str,String.class);
        System.out.println(resultall);
    }
}

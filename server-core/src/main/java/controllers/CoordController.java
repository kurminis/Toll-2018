package controllers;

import jdev.dto.PointDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoordController {
//Обработка данных переданных POST-запросом
    @PostMapping("/counter")
    public Response greetingb(@RequestBody String pointdto) {
        if (pointdto.split(",").length==4) {
            return new Response(true);
        }
        else {
            return new Response(false);
        }
    }
}


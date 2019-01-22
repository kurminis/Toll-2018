package jdev.tracker;

import jdev.dto.PointDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.IOUtils;

import java.net.URL;

public class Main {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShedulingContext.class);

    }

}


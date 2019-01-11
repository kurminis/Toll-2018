package jdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataStoreService {

    @Autowired
    private DataSendService dataSendService;

    public void saveData() {
        System.out.println("Сохраняю данные. БЕБЕ");
    }
}

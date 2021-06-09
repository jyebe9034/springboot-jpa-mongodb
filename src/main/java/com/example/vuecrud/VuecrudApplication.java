package com.example.vuecrud;

import com.example.vuecrud.main.MainRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class VuecrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuecrudApplication.class, args);
    }

}

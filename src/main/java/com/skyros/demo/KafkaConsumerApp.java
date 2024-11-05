package com.skyros.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

}

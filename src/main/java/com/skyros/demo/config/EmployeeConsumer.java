package com.skyros.demo.config;

import com.skyros.demo.service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
@Setter
@Getter
public class EmployeeConsumer {

    @Autowired
    private EmployeeService employeeService;

    @KafkaListener(topics = "${topic.name.msg}", groupId = "app")
    public void consumeMsg(ConsumerRecord<String, String> payload) {
        sleep();
        log.info("topicName: {}", payload.topic());
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("partition: {}", payload.partition());
        log.info("value: {}", payload.value());
    }

    @KafkaListener(topics = "${topic.name.emp}", groupId = "app")
    public void consumeEmp(ConsumerRecord<String, String> payload) {
        sleep();
        getEmployeeService().addEmployee(payload.value());
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableKafka
@EntityScan(basePackages = {"com.models"})
public class TaskServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class, args);
    }
}
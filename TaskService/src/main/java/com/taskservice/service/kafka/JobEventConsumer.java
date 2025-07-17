package com.taskservice.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Company;
import com.models.Job;
import com.taskservice.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobEventConsumer {

    @Autowired
    CompanyRepository companyRepository;

    private static final Logger logger = LoggerFactory.getLogger(JobEventConsumer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final KafkaTemplate<String, Job> kafkaTemplate;

    public JobEventConsumer(KafkaTemplate<String, Job> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "job.created", groupId = "task-service-group")
    public void listenForJob(Job job) {
        try {
            System.out.println("herehereherehere");
            Optional<Company> company = companyRepository.findByName(job.getCompany());
            if(company.isEmpty()) {
                throw new NoSuchFieldException("Company does not exist");
            }
            logger.debug("Successfully received job ID: {}", job.getId());

        }
        catch (NoSuchFieldException e) {
            logger.error("Failed to process kafka message: {}", e.getMessage());
        }
    }
}

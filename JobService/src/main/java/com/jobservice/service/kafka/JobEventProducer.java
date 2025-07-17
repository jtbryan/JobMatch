package com.jobservice.service.kafka;

import com.models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JobEventProducer {

    private static final Logger logger = LoggerFactory.getLogger(JobEventProducer.class);

    private final KafkaTemplate<String, Job> kafkaTemplate;

    public JobEventProducer(KafkaTemplate<String, Job> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJobCreatedEvent(Job job) {
        kafkaTemplate.send("job.created", job);
        logger.debug("Published job.created event for job ID: {}", job.getId());
    }
}

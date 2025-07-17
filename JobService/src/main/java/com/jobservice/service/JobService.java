package com.jobservice.service;

import com.jobservice.dto.JobRequestDTO;
import com.models.Job;
import com.jobservice.repository.CompanyRepository;
import com.jobservice.repository.JobRepository;
import com.jobservice.service.kafka.JobEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobEventProducer jobEventProducer;

    public Job createJob(JobRequestDTO dto) {
        Job job = new Job(dto.getTitle(),
                dto.getCompany(),
                dto.getLowBand(),
                dto.getHighBand(),
                dto.getLocation(),
                Date.from(Instant.now()).toString(),
                Date.from(Instant.now()).toString());

        companyService.AddCompany(dto.getCompany());

        Job createdJob = jobRepository.save(job);

        jobEventProducer.sendJobCreatedEvent(createdJob);

        return createdJob;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public void removeJobById(Long id) {
        jobRepository.deleteById(id);
    }
}

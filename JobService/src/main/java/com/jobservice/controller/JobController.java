package com.jobservice.controller;

import jakarta.validation.Valid;
import com.jobservice.dto.JobRequestDTO;
import com.jobservice.dto.JobResponseDTO;
import com.models.Job;
import com.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/createJob")
    public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody JobRequestDTO job) {
        Job savedJob = jobService.createJob(job);

        JobResponseDTO dto = new JobResponseDTO();
        dto.setCompany(savedJob.getCompany());
        dto.setTitle(savedJob.getTitle());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobsById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity deletedJobById(@PathVariable Long id) {
        jobService.removeJobById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

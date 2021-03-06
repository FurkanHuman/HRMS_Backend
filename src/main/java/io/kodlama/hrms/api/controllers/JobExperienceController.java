package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.JobExperienceService;
import io.kodlama.hrms.entities.dtos.JobExperienceAddDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/JobExperience")
public class JobExperienceController {
    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.jobExperienceService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobExperienceAddDto jobExperienceAddDto) {
        return ResponseEntity.ok(this.jobExperienceService.add(jobExperienceAddDto));
    }
}

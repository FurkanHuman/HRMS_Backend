package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.JobPostingFormService;
import io.kodlama.hrms.entities.concretes.JobPostingForm;

@RestController
@RequestMapping(value = "/api/JobPostingForm")

public class JobPostingFormController {
    private final JobPostingFormService jobPostingFormService;

    @Autowired
    public JobPostingFormController(JobPostingFormService jobPostingFormService) {
        this.jobPostingFormService = jobPostingFormService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPostingForm jobPostingForm) {
        return ResponseEntity.ok(this.jobPostingFormService.add(jobPostingForm));
    }

    @GetMapping("/companyName")
    public ResponseEntity<?> companyName(@RequestBody String compainyName) {
        return ResponseEntity.ok(this.jobPostingFormService.getByEmployerUserCompanyNameContains(compainyName));
    }

}

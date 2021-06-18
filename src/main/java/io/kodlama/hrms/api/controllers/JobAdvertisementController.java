package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.entities.dtos.JobAdvertisementAddDto;

@RestController
@RequestMapping(value = "/api/city")
public class JobAdvertisementController {
    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/addJobAdvertisement")
    public ResponseEntity<?> add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
        return ResponseEntity.ok(this.jobAdvertisementService.addJobAdvertisement(jobAdvertisementAddDto));
    }

    @PostMapping("getJobAdvertisement")
    public ResponseEntity<?> getJobAdvertisement(int jobAdvertisementId) {
        return ResponseEntity.ok(this.jobAdvertisementService.getJobAdvertisement(jobAdvertisementId));
    }

    @GetMapping("getAllJobAdvertisement")
    public ResponseEntity<?> getAllJobAdvertisement() {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllJobAdvertisement());
    }

    @PostMapping("getJobAdvertisementByJobPositionId")
    public ResponseEntity<?> getJobAdvertisementByJobPositionId(int jobPositionId) {
        return ResponseEntity.ok(this.jobAdvertisementService.getJobAdvertisementByJobPositionId(jobPositionId));
    }

    @PostMapping("getJobAdvertisementByCityId")
    public ResponseEntity<?> getJobAdvertisementByCityId(int cityId) {
        return ResponseEntity.ok(this.jobAdvertisementService.getJobAdvertisementByCityId(cityId));
    }

    @PostMapping("disableJobAdvertisement")
    public ResponseEntity<?> gdisableJobAdvertisement(int jobAdvertisementId, boolean state) {
        return ResponseEntity.ok(this.jobAdvertisementService.disableJobAdvertisement(jobAdvertisementId, state));
    }
}
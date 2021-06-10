package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.EmployerUserService;
import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;
import io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto;
import io.kodlama.hrms.entities.dtos.JobAdvertismentAddDto;

@RestController
@RequestMapping(value = "/api/employerUsers")
public class EmployerUsersController {
    private final EmployerUserService employerUserService;
    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public EmployerUsersController(EmployerUserService employerUserService,
            JobAdvertisementService jobAdvertisementService) {
        this.employerUserService = employerUserService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EmployerUser employerUser) {
        return ResponseEntity.ok(this.employerUserService.register(employerUser));
    }

    @PostMapping("/addJobAdvertisement")
    public List<Result> addJobAdvertisement(@RequestBody JobAdvertismentAddDto advertismentAddDto) {
        return this.jobAdvertisementService.addJobAdvertisement(advertismentAddDto);
    }

    @GetMapping("/getJobAdvertisement")
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisement(@RequestParam int jobAdvertisementId) {

        return this.jobAdvertisementService.getJobAdvertisement(jobAdvertisementId);

    }

    @GetMapping("/getJobAdvertisementByJobPositionId")
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByJobPositionId(
            @RequestParam int jobPositionId) {

        return this.jobAdvertisementService.getJobAdvertisementByJobPositionId(jobPositionId);

    }

    @GetMapping("/getJobAdvertisementByCityId")
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByCityId(@RequestParam int cityId) {

        return this.jobAdvertisementService.getJobAdvertisementByCityId(cityId);

    }

    // @GetMapping("/getJobAdvertisementByDateRange")
    // public DataResult<List<JobAdvertisementGetDto>>
    // getJobAdvertisementByDateRange(@RequestParam LocalDate startDate,
    // LocalDate endDate) {

    // return this.jobAdvertisementService.getJobAdvertisementByDateRange(startDate,
    // endDate);

    // }

    @GetMapping("/getAllJobAdvertisement")
    public DataResult<List<JobAdvertisementGetDto>> getAllJobAdvertisement() {

        return this.jobAdvertisementService.getAllJobAdvertisement();

    }

    @GetMapping("getAll")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(this.employerUserService.getAll());
    }

}

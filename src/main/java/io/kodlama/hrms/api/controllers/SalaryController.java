package io.kodlama.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.SalaryService;
import io.kodlama.hrms.entities.concretes.Salary;

@RestController
@RequestMapping(value = "/api/salary")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Salary salary) {
        return ResponseEntity.ok(this.salaryService.add(salary));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.salaryService.getAll());
    }

}

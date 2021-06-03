package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.EmployerUserService;
import io.kodlama.hrms.entities.concretes.EmployerUser;

@RestController
@RequestMapping(value = "/api/employerUsers")
public class EmployerUsersController {
    private EmployerUserService employerUserService;

    @Autowired
    public EmployerUsersController(EmployerUserService employerUserService) {
        this.employerUserService = employerUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EmployerUser employerUser) {
        return ResponseEntity.ok(this.employerUserService.register(employerUser));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(this.employerUserService.getAll());
    }

}

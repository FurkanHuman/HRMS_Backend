package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.StaffUserService;
import io.kodlama.hrms.entities.concretes.StaffUser;

@RestController
@RequestMapping(value = "/api/staffUsers")
public class StaffUsersController {
    private final StaffUserService staffUserService;

    @Autowired
    public StaffUsersController(StaffUserService staffUserService) {
        this.staffUserService = staffUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody StaffUser staffUser) {
        return ResponseEntity.ok(this.staffUserService.add(staffUser));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.staffUserService.getAll());
    }
}
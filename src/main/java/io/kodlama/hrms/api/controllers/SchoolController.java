package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.SchoolService;
import io.kodlama.hrms.entities.dtos.SchoolAddDto;

@RestController
@RequestMapping(value = "/api/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.schoolService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SchoolAddDto schoolTypeDto) {
        return ResponseEntity.ok(this.schoolService.add(schoolTypeDto));
    }
}

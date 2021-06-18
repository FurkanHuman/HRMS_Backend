package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.SchoolTypeService;
import io.kodlama.hrms.entities.dtos.SchoolTypeDto;

@RestController
@RequestMapping(value = "/api/schooltype")
public class SchoolTypeController {

    private final SchoolTypeService schoolTypeService;

    @Autowired
    public SchoolTypeController(SchoolTypeService schoolTypeService) {
        this.schoolTypeService = schoolTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.schoolTypeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SchoolTypeDto schoolTypeDto) {
        return ResponseEntity.ok(this.schoolTypeService.add(schoolTypeDto));
    }

}

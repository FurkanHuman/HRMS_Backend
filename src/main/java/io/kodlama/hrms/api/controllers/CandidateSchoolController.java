package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CandidateSchoolService;
import io.kodlama.hrms.entities.dtos.CandidateSchoolAddDto;

@RestController
@RequestMapping(value = "/api/CandidateSchool")
public class CandidateSchoolController {
    private final CandidateSchoolService candidateSchoolService;

    @Autowired
    public CandidateSchoolController(CandidateSchoolService candidateSchoolService) {
        this.candidateSchoolService = candidateSchoolService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.candidateSchoolService.getAll());
    }

    @PostMapping("/addCandidateScholl")
    public ResponseEntity<?> addCandidateScholl(@RequestBody CandidateSchoolAddDto candidateSchoolAddDto) {
        return ResponseEntity.ok(this.candidateSchoolService.addCandidateScholl(candidateSchoolAddDto));
    }

}
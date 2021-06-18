package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.ProgramingLanguageService;
import io.kodlama.hrms.entities.dtos.ProgramingLanguageDto;

@RestController
@RequestMapping(value = "/api/ProgramingLanguage")
public class ProgramingLanguageController {
    private final ProgramingLanguageService programingLanguageService;

    @Autowired
    public ProgramingLanguageController(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProgramingLanguageDto programingLanguageDto) {
        return ResponseEntity.ok(this.programingLanguageService.add(programingLanguageDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.programingLanguageService.getAll());
    }
}
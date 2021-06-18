package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.LanguageService;
import io.kodlama.hrms.entities.dtos.LanguageDto;

@RestController
@RequestMapping(value = "/api/language")
public class LanguageController {
    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.languageService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LanguageDto languageDto) {
        return ResponseEntity.ok(this.languageService.add(languageDto));
    }
}
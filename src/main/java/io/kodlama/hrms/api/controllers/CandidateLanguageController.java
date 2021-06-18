package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CandidateLanguageService;

@RestController
@RequestMapping(value = "/api/CandidateLanguage")
public class CandidateLanguageController {
    private final CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.candidateLanguageService.getAll());
    }
}
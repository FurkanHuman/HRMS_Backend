package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CandidateProgramingLanguageService;

@RestController
@RequestMapping(value = "/api/CandidateProgramingLanguage")
public class CandidateProgramingLanguageController {// this dangerus methode
    private final CandidateProgramingLanguageService candidateProgramingLanguageService;

    @Autowired
    public CandidateProgramingLanguageController(
            CandidateProgramingLanguageService candidateProgramingLanguageService) {
        this.candidateProgramingLanguageService = candidateProgramingLanguageService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(this.candidateProgramingLanguageService.getAll());
    }

}

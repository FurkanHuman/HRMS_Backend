package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CandidateProgramingLanguageService;
import io.kodlama.hrms.entities.dtos.CandidateProgramingAddDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/CandidateProgramingLanguage")
public class CandidateProgramingLanguageController {// this dangerus methode
    private final CandidateProgramingLanguageService candidateProgramingLanguageService;

    @Autowired
    public CandidateProgramingLanguageController(
            CandidateProgramingLanguageService candidateProgramingLanguageService) {
        this.candidateProgramingLanguageService = candidateProgramingLanguageService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getByCandidate(@RequestParam int candidateId) {
        return ResponseEntity.ok(this.candidateProgramingLanguageService.getByCandidate(candidateId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> Add(@RequestBody CandidateProgramingAddDto addDto) {
        return ResponseEntity.ok(this.candidateProgramingLanguageService.add(addDto));
    }

}

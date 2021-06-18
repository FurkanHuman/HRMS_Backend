package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.LanguageLevelService;
import io.kodlama.hrms.entities.dtos.LanguageLevelDto;

@RestController
@RequestMapping(value = "/api/languageLevel")
public class LanguageLevelController {
    private final LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.languageLevelService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LanguageLevelDto languageLevelDto) {
        return ResponseEntity.ok(this.languageLevelService.add(languageLevelDto));
    }

}

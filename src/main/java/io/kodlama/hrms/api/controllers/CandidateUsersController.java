package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CandidateUserService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.CandidateUser;
import io.kodlama.hrms.entities.dtos.CvGetDto;

@RestController
@RequestMapping(value = "/api/candidateUsers")
public class CandidateUsersController {
    private final CandidateUserService candidateUserService;

    @Autowired
    public CandidateUsersController(CandidateUserService candidateUserService) {
        this.candidateUserService = candidateUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CandidateUser candidateUser) {
        return ResponseEntity.ok(this.candidateUserService.register(candidateUser));
    }

    @PostMapping("/getCv")
    public DataResult<CvGetDto> getCv(@RequestParam int candidateId) {
        return this.candidateUserService.getCv(candidateId);

    }

    @GetMapping("getAll")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(this.candidateUserService.getAll());
    }

}

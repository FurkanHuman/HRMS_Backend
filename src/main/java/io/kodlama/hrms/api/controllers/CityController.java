package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CityService;
import io.kodlama.hrms.entities.concretes.City;

@RestController
@RequestMapping(value = "/api/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody City city) {
        return ResponseEntity.ok(this.cityService.add(city));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.cityService.getAll());
    }

}

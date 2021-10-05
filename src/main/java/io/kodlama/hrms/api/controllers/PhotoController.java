package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.kodlama.hrms.business.abstracts.PhotoService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/Photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@ApiParam(name = "file", value = "The file") @RequestPart MultipartFile file,
            @RequestParam int candidateUserId) {
        return ResponseEntity.ok(this.photoService.add(file, candidateUserId));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.photoService.getAll());
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestParam int candidateUserId) {
        return ResponseEntity.ok(this.photoService.delete(candidateUserId));
    }
}

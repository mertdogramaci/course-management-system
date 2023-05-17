package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.InstructorLoginCredentials;
import com.group20.coursemanagementsystem.repository.InstructorLoginCredentialsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructorLoginCredentials")
public class InstructorLoginCredentialsController {
    private final InstructorLoginCredentialsRepository instructorLoginCredentialsRepository;

    public InstructorLoginCredentialsController(
            InstructorLoginCredentialsRepository instructorLoginCredentialsRepository) {
        this.instructorLoginCredentialsRepository = instructorLoginCredentialsRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllInstructorLoginCredentials() {
        return ResponseEntity.ok(instructorLoginCredentialsRepository.findAll());
    }

    @GetMapping("/{InstructorLoginCredentialsId}")
    public ResponseEntity<InstructorLoginCredentials> getInstructorLoginCredentialsById(Long id) {
        return ResponseEntity.ok(instructorLoginCredentialsRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<InstructorLoginCredentials> createInstructorLoginCredentials(
            @RequestBody InstructorLoginCredentials instructorLoginCredentials) {
        return ResponseEntity.ok(instructorLoginCredentialsRepository.save(instructorLoginCredentials));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorLoginCredentials> updateInstructorLoginCredentials(
            @PathVariable Long id, @RequestBody InstructorLoginCredentials instructorLoginCredentials) {
        return ResponseEntity.ok(instructorLoginCredentialsRepository.update(id, instructorLoginCredentials));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorLoginCredentials(@PathVariable Long id) {
        instructorLoginCredentialsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

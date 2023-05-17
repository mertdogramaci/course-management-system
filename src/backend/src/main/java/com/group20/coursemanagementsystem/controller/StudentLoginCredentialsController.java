package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.StudentLoginCredentials;
import com.group20.coursemanagementsystem.repository.StudentLoginCredentialsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentLoginCredentials")
public class StudentLoginCredentialsController {
    private final StudentLoginCredentialsRepository studentLoginCredentialsRepository;

    public StudentLoginCredentialsController(
            StudentLoginCredentialsRepository studentLoginCredentialsRepository) {
        this.studentLoginCredentialsRepository = studentLoginCredentialsRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllStudentLoginCredentials() {
        return ResponseEntity.ok(studentLoginCredentialsRepository.findAll());
    }

    @GetMapping("/{studentLoginCredentialsId}")
    public ResponseEntity<StudentLoginCredentials> getStudentLoginCredentialsById(Long id) {
        return ResponseEntity.ok(studentLoginCredentialsRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<StudentLoginCredentials> createStudentLoginCredentials(
            @RequestBody StudentLoginCredentials studentLoginCredentials) {
        return ResponseEntity.ok(studentLoginCredentialsRepository.save(studentLoginCredentials));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentLoginCredentials> updateStudentLoginCredentials(
            @PathVariable Long id, @RequestBody StudentLoginCredentials studentLoginCredentials) {
        return ResponseEntity.ok(studentLoginCredentialsRepository.update(id, studentLoginCredentials));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentLoginCredentials(@PathVariable Long id) {
        studentLoginCredentialsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

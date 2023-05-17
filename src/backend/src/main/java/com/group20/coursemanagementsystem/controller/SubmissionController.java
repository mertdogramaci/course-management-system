package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Submission;
import com.group20.coursemanagementsystem.repository.SubmissionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {
    private final SubmissionRepository submissionRepository;

    public SubmissionController(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllSubmissions() {
        return ResponseEntity.ok(submissionRepository.findAll());
    }

    @GetMapping("/{submissionId}")
    public ResponseEntity<Submission> getSubmissionById(Long id) {
        return ResponseEntity.ok(submissionRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        return ResponseEntity.ok(submissionRepository.save(submission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submission) {
        return ResponseEntity.ok(submissionRepository.update(id, submission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable Long id) {
        submissionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

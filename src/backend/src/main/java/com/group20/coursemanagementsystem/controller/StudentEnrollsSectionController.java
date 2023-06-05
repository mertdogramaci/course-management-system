package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.repository.StudentEnrollsSectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/studentEnrollsSection")
public class StudentEnrollsSectionController {
    private final StudentEnrollsSectionRepository studentEnrollsSectionRepository;

    public StudentEnrollsSectionController(StudentEnrollsSectionRepository studentEnrollsSectionRepository) {
        this.studentEnrollsSectionRepository = studentEnrollsSectionRepository;
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<List> getSectionsByStudentID(@PathVariable Long id) {
        return ResponseEntity.ok(studentEnrollsSectionRepository.findByStudentId(id));
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/{id}/{semester}/{year}")
    public ResponseEntity<List> getSectionsByStudentID(@PathVariable Long id, @PathVariable boolean semester,
                                                       @PathVariable int year) {
        return ResponseEntity.ok(studentEnrollsSectionRepository.findByTerm(id, semester, year));
    }
}

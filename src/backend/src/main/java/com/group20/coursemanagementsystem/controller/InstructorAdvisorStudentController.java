package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.InstructorAdvisorStudent;
import com.group20.coursemanagementsystem.repository.InstructorAdvisorStudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/instructorAdvisorStudent")
public class InstructorAdvisorStudentController {
    private final InstructorAdvisorStudentRepository instructorAdvisorStudentRepository;

    public InstructorAdvisorStudentController(InstructorAdvisorStudentRepository instructorAdvisorStudentRepository) {
        this.instructorAdvisorStudentRepository = instructorAdvisorStudentRepository;
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/instructorId={id}")
    public ResponseEntity<List> getStudentsByInstructorID(@PathVariable Long id) {
        return ResponseEntity.ok(instructorAdvisorStudentRepository.findByInstructorId(id));
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/studentId={id}")
    public ResponseEntity<InstructorAdvisorStudent> getInstructorByStudentID(@PathVariable Long id) {
        return ResponseEntity.ok(instructorAdvisorStudentRepository.findByStudentId(id));
    }
}

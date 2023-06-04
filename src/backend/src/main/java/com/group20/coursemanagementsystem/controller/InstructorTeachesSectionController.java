package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.repository.InstructorTeachesSectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/instructorTeachesSection")
public class InstructorTeachesSectionController {
    private final InstructorTeachesSectionRepository instructorTeachesSectionRepository;

    public InstructorTeachesSectionController(InstructorTeachesSectionRepository instructorTeachesSectionRepository) {
        this.instructorTeachesSectionRepository = instructorTeachesSectionRepository;
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<List> getSectionsByInstructorID(@PathVariable Long id) {
        return ResponseEntity.ok(instructorTeachesSectionRepository.findByInstructorId(id));
    }
}

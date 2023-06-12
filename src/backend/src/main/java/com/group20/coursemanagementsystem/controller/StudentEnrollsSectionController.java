package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Section;
import com.group20.coursemanagementsystem.model.StudentEnrollsSection;
import com.group20.coursemanagementsystem.repository.StudentEnrollsSectionRepository;
import com.group20.coursemanagementsystem.service.StudentEnrollsSectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/studentEnrollsSection")
public class StudentEnrollsSectionController {
    private final StudentEnrollsSectionRepository studentEnrollsSectionRepository;

    private final StudentEnrollsSectionService studentEnrollsSectionService;

    public StudentEnrollsSectionController(StudentEnrollsSectionRepository studentEnrollsSectionRepository, StudentEnrollsSectionService studentEnrollsSectionService) {
        this.studentEnrollsSectionRepository = studentEnrollsSectionRepository;
        this.studentEnrollsSectionService = studentEnrollsSectionService;
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

    @PreAuthorize("hasAnyAuthority('STUDENT')")
    @GetMapping("/getSectionsToEnroll/{id}/{semester}/{year}")
    public ResponseEntity<List> getSectionsToEnroll(@PathVariable Long id, @PathVariable boolean semester,
                                                       @PathVariable int year) {
        return ResponseEntity.ok(studentEnrollsSectionRepository.findSectionsToEnroll(id, semester, year));
    }

    @PreAuthorize("hasAnyAuthority('STUDENT')")
    @PostMapping("/enroll/{student_id}/{section_id}")
    public ResponseEntity<Section> getSectionsToEnroll(@PathVariable Long student_id,
                                                       @PathVariable Long section_id) {
        return ResponseEntity.ok(studentEnrollsSectionService.enroll(student_id, section_id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/courseStatistics")
    public ResponseEntity<Object> getSectionStatistics() {
        return ResponseEntity.ok(studentEnrollsSectionRepository.sectionStatistics());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/courseAverageStatistics")
    public ResponseEntity<Object> getSectionAverageStatistics() {
        return ResponseEntity.ok(studentEnrollsSectionRepository.sectionAverageStatistics());
    }
}

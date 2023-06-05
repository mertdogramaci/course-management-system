package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.repository.SectionHasTimeSlotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/sectionHasTimeSlot")
public class SectionHasTimeSlotController {
    private final SectionHasTimeSlotRepository sectionHasTimeSlotRepository;

    public SectionHasTimeSlotController(SectionHasTimeSlotRepository sectionHasTimeSlotRepository) {
        this.sectionHasTimeSlotRepository = sectionHasTimeSlotRepository;
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<List> getSectionsByStudentID(@PathVariable Long id) {
        return ResponseEntity.ok(sectionHasTimeSlotRepository.findByStudentId(id));
    }
}

package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.InstructorContactInfo;
import com.group20.coursemanagementsystem.repository.InstructorContactInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructorContactInfos")
public class InstructorContactInfoController {
    private final InstructorContactInfoRepository instructorContactInfoRepository;

    public InstructorContactInfoController(InstructorContactInfoRepository instructorContactInfoRepository) {
        this.instructorContactInfoRepository = instructorContactInfoRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllInstructorContactInfos() {
        return ResponseEntity.ok(instructorContactInfoRepository.findAll());
    }

    @GetMapping("/{instructorContactInfoId}")
    public ResponseEntity<InstructorContactInfo> getInstructorContactInfoById(Long id) {
        return ResponseEntity.ok(instructorContactInfoRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<InstructorContactInfo> createInstructorContactInfo(@RequestBody InstructorContactInfo instructorContactInfo) {
        return ResponseEntity.ok(instructorContactInfoRepository.save(instructorContactInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorContactInfo> updateInstructorContactInfo(@PathVariable Long id,
                                                              @RequestBody InstructorContactInfo instructorContactInfo) {
        return ResponseEntity.ok(instructorContactInfoRepository.update(id, instructorContactInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorContactInfo(@PathVariable Long id) {
        instructorContactInfoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

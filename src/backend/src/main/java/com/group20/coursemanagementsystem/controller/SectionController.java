package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Section;
import com.group20.coursemanagementsystem.repository.SectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    private final SectionRepository sectionRepository;

    public SectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllSections() {
        return ResponseEntity.ok(sectionRepository.findAll());
    }

    @GetMapping("/{sectionId}")
    public ResponseEntity<Section> getSectionById(Long id) {
        return ResponseEntity.ok(sectionRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        return ResponseEntity.ok(sectionRepository.save(section));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable Long id, @RequestBody Section section) {
        return ResponseEntity.ok(sectionRepository.update(id, section));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable Long id) {
        sectionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

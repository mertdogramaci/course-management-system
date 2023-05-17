package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Faculty;
import com.group20.coursemanagementsystem.repository.FacultyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyRepository facultyRepository;

    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllFaculties() {
        return ResponseEntity.ok(facultyRepository.findAll());
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getFacultyById(Long id) {
        return ResponseEntity.ok(facultyRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyRepository.save(faculty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyRepository.update(id, faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Instructor;
import com.group20.coursemanagementsystem.repository.InstructorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorRepository instructorRepository;

    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllInstructors() {
        return ResponseEntity.ok(instructorRepository.findAll());
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(Long id) {
        return ResponseEntity.ok(instructorRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorRepository.save(instructor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorRepository.update(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Homework;
import com.group20.coursemanagementsystem.repository.HomeworkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homeworks")
public class HomeworkController {
    private final HomeworkRepository homeworkRepository;

    public HomeworkController(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllHomeworks() {
        return ResponseEntity.ok(homeworkRepository.findAll());
    }

    @GetMapping("/{homeworkId}")
    public ResponseEntity<Homework> getHomeworkById(Long id) {
        return ResponseEntity.ok(homeworkRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Homework> createHomework(@RequestBody Homework homework) {
        return ResponseEntity.ok(homeworkRepository.save(homework));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Homework> updateHomework(@PathVariable Long id, @RequestBody Homework homework) {
        return ResponseEntity.ok(homeworkRepository.update(id, homework));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHomework(@PathVariable Long id) {
        homeworkRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

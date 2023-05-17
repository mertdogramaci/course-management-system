package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.StudentContactInfo;
import com.group20.coursemanagementsystem.repository.StudentContactInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentContactInfos")
public class StudentContactInfoController {
    private final StudentContactInfoRepository studentContactInfoRepository;

    public StudentContactInfoController(StudentContactInfoRepository studentContactInfoRepository) {
        this.studentContactInfoRepository = studentContactInfoRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllStudentContactInfos() {
        return ResponseEntity.ok(studentContactInfoRepository.findAll());
    }

    @GetMapping("/{studentContactInfoId}")
    public ResponseEntity<StudentContactInfo> getStudentContactInfoById(Long id) {
        return ResponseEntity.ok(studentContactInfoRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<StudentContactInfo> createStudentContactInfo(@RequestBody StudentContactInfo studentContactInfo) {
        return ResponseEntity.ok(studentContactInfoRepository.save(studentContactInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentContactInfo> updateStudentContactInfo(@PathVariable Long id,
                                                              @RequestBody StudentContactInfo studentContactInfo) {
        return ResponseEntity.ok(studentContactInfoRepository.update(id, studentContactInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentContactInfo(@PathVariable Long id) {
        studentContactInfoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

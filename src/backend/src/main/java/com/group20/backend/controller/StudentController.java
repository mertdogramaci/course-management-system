package com.group20.backend.controller;

import com.group20.backend.model.Student;
import com.group20.backend.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }
}
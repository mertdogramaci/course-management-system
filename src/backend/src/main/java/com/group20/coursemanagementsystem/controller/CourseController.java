package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Course;
import com.group20.coursemanagementsystem.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Object> getCourseById(Long id) {
        return ResponseEntity.ok(courseRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseRepository.save(course));
    }
}

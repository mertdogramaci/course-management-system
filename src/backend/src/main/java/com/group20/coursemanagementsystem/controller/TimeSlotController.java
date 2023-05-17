package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.TimeSlot;
import com.group20.coursemanagementsystem.repository.TimeSlotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeSlots")
public class TimeSlotController {
    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotController(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @GetMapping
    public ResponseEntity<List> getAllTimeSlots() {
        return ResponseEntity.ok(timeSlotRepository.findAll());
    }

    @GetMapping("/{timeSlotId}")
    public ResponseEntity<TimeSlot> getTimeSlotById(Long id) {
        return ResponseEntity.ok(timeSlotRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<TimeSlot> createTimeSlot(@RequestBody TimeSlot timeSlot) {
        return ResponseEntity.ok(timeSlotRepository.save(timeSlot));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSlot> updateTimeSlot(@PathVariable Long id, @RequestBody TimeSlot timeSlot) {
        return ResponseEntity.ok(timeSlotRepository.update(id, timeSlot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimeSlot(@PathVariable Long id) {
        timeSlotRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.model.ProcessingHistory;
import com.group20.coursemanagementsystem.model.Section;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.model.StudentEnrollsSection;
import com.group20.coursemanagementsystem.repository.ProcessingHistoryRepository;
import com.group20.coursemanagementsystem.repository.SectionRepository;
import com.group20.coursemanagementsystem.repository.StudentEnrollsSectionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentEnrollsSectionService {

    private final MemberService memberService;

    private final StudentEnrollsSectionRepository studentEnrollsSectionRepository;

    private final SectionRepository sectionRepository;

    private final ProcessingHistoryRepository processingHistoryRepository;

    public StudentEnrollsSectionService(MemberService memberService, StudentEnrollsSectionRepository studentEnrollsSectionRepository, SectionRepository sectionRepository, ProcessingHistoryRepository processingHistoryRepository) {
        this.memberService = memberService;
        this.studentEnrollsSectionRepository = studentEnrollsSectionRepository;
        this.sectionRepository = sectionRepository;
        this.processingHistoryRepository = processingHistoryRepository;
    }

    public Section enroll(Long student_id, Long section_id) {
        Student student = memberService.getStudentById(student_id);
        Section section = sectionRepository.findById(section_id);
        studentEnrollsSectionRepository.save(new StudentEnrollsSection(student, section, 0, 0, false));
        processingHistoryRepository.save(new ProcessingHistory(LocalDateTime.now(), student.getEmail(), "Student enrolled to a section with sectionID=%d".formatted(section_id)));
        return section;
    }
}

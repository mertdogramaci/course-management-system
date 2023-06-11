package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.model.Section;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.model.StudentEnrollsSection;
import com.group20.coursemanagementsystem.repository.SectionRepository;
import com.group20.coursemanagementsystem.repository.StudentEnrollsSectionRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollsSectionService {

    private final MemberService memberService;

    private final StudentEnrollsSectionRepository studentEnrollsSectionRepository;

    private final SectionRepository sectionRepository;

    public StudentEnrollsSectionService(MemberService memberService, StudentEnrollsSectionRepository studentEnrollsSectionRepository, SectionRepository sectionRepository) {
        this.memberService = memberService;
        this.studentEnrollsSectionRepository = studentEnrollsSectionRepository;
        this.sectionRepository = sectionRepository;
    }

    public Section enroll(Long student_id, Long section_id) {
        Student student = memberService.getStudentById(student_id);
        Section section = sectionRepository.findById(section_id);
        studentEnrollsSectionRepository.save(new StudentEnrollsSection(student, section, 0, 0, false));
        return section;
    }
}

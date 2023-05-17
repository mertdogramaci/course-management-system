package com.group20.coursemanagementsystem.security;

import com.group20.coursemanagementsystem.model.Department;
import com.group20.coursemanagementsystem.model.Faculty;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.model.StudentLoginCredentials;
import com.group20.coursemanagementsystem.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabasePopulator {
    private final StudentRepository studentRepository;

    private final FacultyRepository facultyRepository;

    private final DepartmentRepository departmentRepository;

    private final StudentLoginCredentialsRepository studentLoginCredentialsRepository;

    public DatabasePopulator(StudentRepository studentRepository, FacultyRepository facultyRepository,
                             DepartmentRepository departmentRepository, StudentLoginCredentialsRepository studentLoginCredentialsRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.studentLoginCredentialsRepository = studentLoginCredentialsRepository;
    }

    @Transactional
    public void populateDatabase() {
        facultyRepository.save(new Faculty("engineering"));
        Faculty faculty = facultyRepository.findById(1L);

        departmentRepository.save(new Department("computer", faculty));
        Department department = departmentRepository.findById(1L);

        studentRepository.save(new Student("ozgun", "akyuz", department, 21827005L, LocalDate.now(),
                40));
        Student student = studentRepository.findById(1L);

        studentLoginCredentialsRepository.save(new StudentLoginCredentials("b21827005", "ozgun", student));
    }
}

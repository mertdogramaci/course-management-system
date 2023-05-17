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
        Faculty faculty = new Faculty();
        faculty.setName("Engineering");
        facultyRepository.save(faculty);

        Department department = new Department();
        department.setFaculty(faculty);
        department.setName("Computer Engineering");
        departmentRepository.save(department);

        Student student = new Student();
        student.setName("Özgün");
        student.setSurname("Akyüz");
        student.setDepartment(department);
        student.setStudentID(21827005L);
        student.setSchoolEnrollmentDate(LocalDate.now());
        student.setSemesterECTS(40);
        studentRepository.save(student);

        studentLoginCredentialsRepository.save(new StudentLoginCredentials("b21827005", "ozgun", student));
    }
}

package com.group20.coursemanagementsystem.security;

import com.group20.coursemanagementsystem.model.*;
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

    private final InstructorRepository instructorRepository;

    private final InstructorLoginCredentialsRepository instructorLoginCredentialsRepository;

    private final SectionRepository sectionRepository;

    private final CourseRepository courseRepository;

    public DatabasePopulator(StudentRepository studentRepository, FacultyRepository facultyRepository,
                             DepartmentRepository departmentRepository, StudentLoginCredentialsRepository studentLoginCredentialsRepository,
                             InstructorRepository instructorRepository, InstructorLoginCredentialsRepository instructorLoginCredentialsRepository, SectionRepository sectionRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.studentLoginCredentialsRepository = studentLoginCredentialsRepository;
        this.instructorRepository = instructorRepository;
        this.instructorLoginCredentialsRepository = instructorLoginCredentialsRepository;
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void populateDatabase() {
        facultyRepository.save(new Faculty("Engineering"));
        facultyRepository.save(new Faculty("Education"));
        facultyRepository.save(new Faculty("Science"));

        Faculty faculty = facultyRepository.findById(1L);
        departmentRepository.save(new Department("Computer Engineering", faculty));
        departmentRepository.save(new Department("Endustrial Engineering", faculty));
        departmentRepository.save(new Department("Physics Engineering", faculty));

        faculty = facultyRepository.findById(2L);
        departmentRepository.save(new Department("Computer Education and Instructional Technology", faculty));
        departmentRepository.save(new Department("Educational Sciences", faculty));


        Department department = departmentRepository.findById(1L);
        studentRepository.save(new Student("ozgun", "akyuz", department, 21827005L, LocalDate.now(),
                40));
        studentRepository.save(new Student("ipek", "yildiz", department, 21827001L, LocalDate.now(),
                40));

        department = departmentRepository.findById(2L);
        studentRepository.save(new Student("mert", "dogramaci", department, 21827555L, LocalDate.now(),
                40));

        Student student = studentRepository.findById(1L);
        studentLoginCredentialsRepository.save(new StudentLoginCredentials("b21827005", "ozgun", student));

        student = studentRepository.findById(2L);
        studentLoginCredentialsRepository.save(new StudentLoginCredentials("b21827001", "ipek", student));

        student = studentRepository.findById(3L);
        studentLoginCredentialsRepository.save(new StudentLoginCredentials("b21827555", "mert", student));


        department = departmentRepository.findById(1L);
        instructorRepository.save(new Instructor("engin", "demir", department));
        instructorRepository.save(new Instructor("ali baran", "tasdemir", department));
        courseRepository.save(new Course("BBM101", 6, true, "example descriptionbbm101", department));
        courseRepository.save(new Course("BBM201", 5, true, "example descriptionbbm201", department));

        department = departmentRepository.findById(2L);
        instructorRepository.save(new Instructor("john", "doe", department));
        courseRepository.save(new Course("deneme101", 5, true, "example description2", department));


        Instructor instructor = instructorRepository.findById(1L);
        instructorLoginCredentialsRepository.save(new InstructorLoginCredentials("b21827999", "demir", instructor));
        Course course = courseRepository.findById(1L);
        sectionRepository.save(new Section(false, 2022, "BBM101 fall 2022 section 1", 40, course, instructor));
        instructor = instructorRepository.findById(2L);
        sectionRepository.save(new Section(false, 2022, "BBM101 fall 2022 section 2", 40, course, instructor));

        instructor = instructorRepository.findById(2L);
        instructorLoginCredentialsRepository.save(new InstructorLoginCredentials("b21827998", "tasdemir", instructor));

        instructor = instructorRepository.findById(3L);
        instructorLoginCredentialsRepository.save(new InstructorLoginCredentials("b21827997", "doe", instructor));
    }
}

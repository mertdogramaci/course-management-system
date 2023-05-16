package com.group20.coursemanagementsystem;

import com.group20.coursemanagementsystem.model.Department;
import com.group20.coursemanagementsystem.model.Faculty;
import com.group20.coursemanagementsystem.repository.CourseRepository;
import com.group20.coursemanagementsystem.repository.DepartmentRepository;
import com.group20.coursemanagementsystem.repository.FacultyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CourseManagementSystemApplication implements CommandLineRunner {

	private final FacultyRepository facultyRepository;
	private final DepartmentRepository departmentRepository;
	private final CourseRepository courseRepository;

	public CourseManagementSystemApplication(FacultyRepository facultyRepository, DepartmentRepository departmentRepository, CourseRepository courseRepository) {
		this.facultyRepository = facultyRepository;
		this.departmentRepository = departmentRepository;
		this.courseRepository = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Faculty faculty = new Faculty();
		faculty.setName("Engineering");
		facultyRepository.save(faculty);

		Department department = new Department();
		department.setName("Computer Engineering");
		department.setFaculty(faculty);
		departmentRepository.save(department);
	}

}

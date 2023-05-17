package com.group20.coursemanagementsystem;

import com.group20.coursemanagementsystem.security.DatabasePopulator;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CourseManagementSystemApplication {

	private final DatabasePopulator databasePopulator;

	public CourseManagementSystemApplication(DatabasePopulator databasePopulator) {
		this.databasePopulator = databasePopulator;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase() {
		databasePopulator.populateDatabase();
	}
}

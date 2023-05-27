package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Academician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicianRepository extends JpaRepository<Academician, Long> {
    boolean existsByEmail(String email);
}

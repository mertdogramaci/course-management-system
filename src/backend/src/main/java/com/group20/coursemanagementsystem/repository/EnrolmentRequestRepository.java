package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRequestRepository extends JpaRepository<EnrolmentRequest, Long> {
    boolean existsByHacettepeId(String hacettepeId);
    boolean existsByEmail(String email);
}


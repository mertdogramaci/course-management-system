package com.group20.coursemanagementsystem.security.repositories;

import com.group20.coursemanagementsystem.security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    boolean existsByAuthority(String authority);
    Authority findByAuthority(String authority);
}

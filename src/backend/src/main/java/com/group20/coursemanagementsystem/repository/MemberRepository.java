package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);

    boolean existsById(Long id);
    boolean existsByEmail(String email);

    @Query("SELECT m FROM Member m WHERE CONCAT(LOWER(m.firstName), ' ', LOWER(m.lastName)) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Member> search(String keyword);
}

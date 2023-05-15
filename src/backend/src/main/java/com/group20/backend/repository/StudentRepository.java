package com.group20.backend.repository;

import com.group20.backend.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List getAllStudents() {
        Query query = entityManager.createNativeQuery("SELECT * FROM Student", Student.class);
        return query.getResultList();
    }

    @Transactional
    public <S extends Student> S save(S student) {
        Query query = entityManager.createNativeQuery("INSERT INTO student (first_name, last_name) VALUES (?, ?)");
        query.setParameter(1, student.getFirstName());
        query.setParameter(2, student.getLastName());
        query.executeUpdate();
        return student;
    }
}

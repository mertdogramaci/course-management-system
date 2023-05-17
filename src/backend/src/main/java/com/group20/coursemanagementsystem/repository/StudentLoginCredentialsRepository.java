package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.StudentLoginCredentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentLoginCredentialsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public StudentLoginCredentials save(StudentLoginCredentials studentLoginCredentials) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO student_login_credentials (username, password, instructorID) VALUES (?, ?, ?)");
        query.setParameter(1, studentLoginCredentials.getUsername());
        query.setParameter(2, studentLoginCredentials.getPassword());
        query.setParameter(3, studentLoginCredentials.getStudent().getId());
        query.executeUpdate();

        return studentLoginCredentials;
    }

    public StudentLoginCredentials findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_login_credentials WHERE id = ?", StudentLoginCredentials.class);
        query.setParameter(1, id);
        return (StudentLoginCredentials) query.getSingleResult();
    }

    @Transactional
    public StudentLoginCredentials update(Long id, StudentLoginCredentials studentLoginCredentials) {
        Query query = entityManager.createNativeQuery(
                "UPDATE student_login_credentials SET username = ?, password = ?, studentID = ? " +
                        "WHERE ID = ?");
        query.setParameter(1, studentLoginCredentials.getUsername());
        query.setParameter(2, studentLoginCredentials.getPassword());
        query.setParameter(3, studentLoginCredentials.getStudent().getId());
        query.setParameter(4, id);
        query.executeUpdate();

        return studentLoginCredentials;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM student_login_credentials WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_login_credentials",
                StudentLoginCredentials.class);
        return query.getResultList();
    }
}

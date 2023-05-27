package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.InstructorLoginCredentials;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorLoginCredentialsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public InstructorLoginCredentials save(InstructorLoginCredentials instructorLoginCredentials) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO instructor_login_credentials (username, password, instructor_id) VALUES (?, ?, ?)");
        query.setParameter(1, instructorLoginCredentials.getUsername());
        query.setParameter(2, instructorLoginCredentials.getPassword());
        query.setParameter(3, instructorLoginCredentials.getInstructor().getId());
        query.executeUpdate();

        return instructorLoginCredentials;
    }

    public InstructorLoginCredentials findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM instructor_login_credentials WHERE id = ?", InstructorLoginCredentials.class);
        query.setParameter(1, id);
        return (InstructorLoginCredentials) query.getSingleResult();
    }

    @Transactional
    public InstructorLoginCredentials update(Long id, InstructorLoginCredentials instructorLoginCredentials) {
        Query query = entityManager.createNativeQuery(
                "UPDATE instructor_login_credentials SET username = ?, password = ?, instructor_id = ? " +
                        "WHERE ID = ?");
        query.setParameter(1, instructorLoginCredentials.getUsername());
        query.setParameter(2, instructorLoginCredentials.getPassword());
        query.setParameter(3, instructorLoginCredentials.getInstructor().getId());
        query.setParameter(4, id);
        query.executeUpdate();

        return instructorLoginCredentials;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor_login_credentials WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT ilc FROM InstructorLoginCredentials ilc",
                InstructorLoginCredentials.class);
        return query.getResultList();
    }
}

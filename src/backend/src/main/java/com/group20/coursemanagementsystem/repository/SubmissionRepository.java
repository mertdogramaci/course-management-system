package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Submission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubmissionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Submission save(Submission submission) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO submission (marks, content) VALUES (?, ?)");
        query.setParameter(1, submission.getMarks());
        query.setParameter(2, submission.getContent());
        query.executeUpdate();

        return submission;
    }

    public Submission findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM submission WHERE id = ?", Submission.class);
        query.setParameter(1, id);
        return (Submission) query.getSingleResult();
    }

    @Transactional
    public Submission update(Long id, Submission submission) {
        Query query = entityManager.createNativeQuery(
                "UPDATE submission SET marks = ?, content = ? WHERE ID = ?");
        query.setParameter(1, submission.getMarks());
        query.setParameter(2, submission.getContent());
        query.setParameter(3, id);
        query.executeUpdate();

        return submission;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM submission WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Submission s", Submission.class);
        return query.getResultList();
    }
}

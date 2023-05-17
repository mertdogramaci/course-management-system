package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Homework;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HomeworkRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Homework save(Homework homework) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO homework (title, content, issue_date, due_date, section_id) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, homework.getTitle());
        query.setParameter(2, homework.getContent());
        query.setParameter(3, homework.getIssueDate());
        query.setParameter(4, homework.getDueDate());
        query.setParameter(5, homework.getSection().getId());
        query.executeUpdate();

        return homework;
    }

    public Homework findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM homework WHERE id = ?", Homework.class);
        query.setParameter(1, id);
        return (Homework) query.getSingleResult();
    }

    @Transactional
    public Homework update(Long id, Homework homework) {
        Query query = entityManager.createNativeQuery(
                "UPDATE homework SET title = ?, content = ?, issue_date = ?, due_date = ?, section_id = ? WHERE ID = ?");
        query.setParameter(1, homework.getTitle());
        query.setParameter(2, homework.getContent());
        query.setParameter(3, homework.getIssueDate());
        query.setParameter(4, homework.getDueDate());
        query.setParameter(5, homework.getSection().getId());
        query.setParameter(6, id);
        query.executeUpdate();

        return homework;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM homework WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT h FROM Homework h", Homework.class);
        return query.getResultList();
    }
}

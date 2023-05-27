package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Faculty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FacultyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Faculty save(Faculty faculty) {
        Query query = entityManager.createNativeQuery("INSERT INTO faculty (name) VALUES (?)");
        query.setParameter(1, faculty.getName());
        query.executeUpdate();

        return faculty;
    }

    public Faculty findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM faculty WHERE id = ?", Faculty.class);
        query.setParameter(1, id);
        return (Faculty) query.getSingleResult();
    }

    @Transactional
    public Faculty update(Long id, Faculty faculty) {
        Query query = entityManager.createNativeQuery("UPDATE faculty SET name = ? WHERE ID = ?");
        query.setParameter(1, faculty.getName());
        query.setParameter(2, id);
        query.executeUpdate();

        return faculty;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM faculty WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT f FROM Faculty f", Faculty.class);
        return query.getResultList();
    }
}

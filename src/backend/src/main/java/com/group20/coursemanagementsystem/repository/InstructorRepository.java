package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Instructor save(Instructor instructor) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO instructor (name, surname, departmentID) VALUES (?, ?, ?)");
        query.setParameter(1, instructor.getName());
        query.setParameter(2, instructor.getSurname());
        query.setParameter(3, instructor.getDepartment().getId());
        query.executeUpdate();

        return instructor;
    }

    public Instructor findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor WHERE id = ?", Instructor.class);
        query.setParameter(1, id);
        return (Instructor) query.getSingleResult();
    }

    @Transactional
    public Instructor update(Long id, Instructor instructor) {
        Query query = entityManager.createNativeQuery(
                "UPDATE instructor SET name = ?, surname = ?, departmentID = ? WHERE ID = ?");
        query.setParameter(1, instructor.getName());
        query.setParameter(2, instructor.getSurname());
        query.setParameter(3, instructor.getDepartment().getId());
        query.setParameter(6, id);
        query.executeUpdate();

        return instructor;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor", Instructor.class);
        return query.getResultList();
    }
}

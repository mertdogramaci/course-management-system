package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Instructor;
import com.group20.coursemanagementsystem.model.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Instructor findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_table WHERE id = ?", Instructor.class);
        query.setParameter(1, id);
        return (Instructor) query.getSingleResult();
    }

    @Transactional
    public <I extends Instructor> I save(I instructor) {
        Query query = entityManager.createNativeQuery("INSERT INTO instructor_table (id) VALUES (?, ?, ?)");
        query.setParameter(1, instructor.getId());
        return instructor;
    }

//    @Transactional
//    public Instructor update(Long id, Instructor instructor) {
//        Query query = entityManager.createNativeQuery(
//                "UPDATE instructor SET name = ?, surname = ?, department_id = ? WHERE ID = ?");
//        query.setParameter(1, instructor.getName());
//        query.setParameter(2, instructor.getSurname());
//        query.setParameter(3, instructor.getDepartment().getId());
//        query.setParameter(4, id);
//        query.executeUpdate();
//
//        return instructor;
//    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class);
        return query.getResultList();
    }
}

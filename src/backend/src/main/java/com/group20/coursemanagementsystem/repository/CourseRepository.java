package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Course save(Course course) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO course (title, ects, is_compulsory, description, department_id) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, course.getTitle());
        query.setParameter(2, course.getEcts());
        query.setParameter(3, course.isCompulsory());
        query.setParameter(4, course.getDescription());
        query.setParameter(5, course.getDepartment().getId());
        query.executeUpdate();

        return course;
    }

    public Course findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM course WHERE id = ?", Course.class);
        query.setParameter(1, id);
        return (Course) query.getSingleResult();
    }

    @Transactional
    public Course update(Long id, Course course) {
        Query query = entityManager.createNativeQuery(
                "UPDATE course SET title = ?, ects = ?, is_compulsory = ?, description = ?, department_id = ? " +
                        "WHERE ID = ?");
        query.setParameter(1, course.getTitle());
        query.setParameter(2, course.getEcts());
        query.setParameter(3, course.isCompulsory());
        query.setParameter(4, course.getDescription());
        query.setParameter(5, course.getDepartment().getId());
        query.setParameter(6, id);
        query.executeUpdate();

        return course;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM course WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }
}

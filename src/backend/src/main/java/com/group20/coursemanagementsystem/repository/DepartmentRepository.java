package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Department save(Department department) {
        Query query = entityManager.createNativeQuery("INSERT INTO department (name, faculty_id) VALUES (?, ?)");
        query.setParameter(1, department.getName());
        query.setParameter(2, department.getFaculty().getId());
        query.executeUpdate();

        return department;
    }

    public Department findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM department WHERE id = ?", Department.class);
        query.setParameter(1, id);
        return (Department) query.getSingleResult();
    }

    @Transactional
    public Department update(Department department) {
        Query query = entityManager.createNativeQuery("UPDATE department SET name = ?, faculty_id = ? WHERE ID = ?");
        query.setParameter(1, department.getName());
        query.setParameter(2, department.getFaculty().getId());
        query.setParameter(3, department.getId());
        query.executeUpdate();

        return department;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM department WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM department", Department.class);
        return query.getResultList();
    }
}

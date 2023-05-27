package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.StudentContactInfo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentContactInfoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public StudentContactInfo save(StudentContactInfo studentContactInfo) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO student_contact_info (phone, email, address, student_id) VALUES (?, ?, ?, ?)");
        query.setParameter(1, studentContactInfo.getPhone());
        query.setParameter(2, studentContactInfo.getEmail());
        query.setParameter(3, studentContactInfo.getAddress());
        query.setParameter(4, studentContactInfo.getStudent().getId());
        query.executeUpdate();

        return studentContactInfo;
    }

    public StudentContactInfo findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_contact_info WHERE id = ?", StudentContactInfo.class);
        query.setParameter(1, id);
        return (StudentContactInfo) query.getSingleResult();
    }

    @Transactional
    public StudentContactInfo update(Long id, StudentContactInfo studentContactInfo) {
        Query query = entityManager.createNativeQuery(
                "UPDATE student_contact_info SET phone = ?, email = ?, address = ?, student_id = ? WHERE ID = ?");
        query.setParameter(1, studentContactInfo.getPhone());
        query.setParameter(2, studentContactInfo.getEmail());
        query.setParameter(3, studentContactInfo.getAddress());
        query.setParameter(4, studentContactInfo.getStudent().getId());
        query.setParameter(5, id);
        query.executeUpdate();

        return studentContactInfo;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM student_contact_info WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT sci FROM StudentContactInfo sci",
                StudentContactInfo.class);
        return query.getResultList();
    }
}

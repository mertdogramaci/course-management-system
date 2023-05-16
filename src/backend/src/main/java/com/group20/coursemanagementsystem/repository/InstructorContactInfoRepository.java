package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.InstructorContactInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorContactInfoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public InstructorContactInfo save(InstructorContactInfo instructorContactInfo) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO instructor_contact_info (phone, email, address, instructorID) VALUES (?, ?, ?, ?)");
        query.setParameter(1, instructorContactInfo.getPhone());
        query.setParameter(2, instructorContactInfo.getEmail());
        query.setParameter(3, instructorContactInfo.getAddress());
        query.setParameter(4, instructorContactInfo.getInstructor().getId());
        query.executeUpdate();

        return instructorContactInfo;
    }

    public InstructorContactInfo findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM instructor_contact_info WHERE id = ?", InstructorContactInfo.class);
        query.setParameter(1, id);
        return (InstructorContactInfo) query.getSingleResult();
    }

    @Transactional
    public InstructorContactInfo update(InstructorContactInfo instructorContactInfo) {
        Query query = entityManager.createNativeQuery(
                "UPDATE instructor_contact_info SET phone = ?, email = ?, address = ?, instructorID = ? WHERE ID = ?");
        query.setParameter(1, instructorContactInfo.getPhone());
        query.setParameter(2, instructorContactInfo.getEmail());
        query.setParameter(3, instructorContactInfo.getAddress());
        query.setParameter(4, instructorContactInfo.getInstructor().getId());
        query.setParameter(5, instructorContactInfo.getId());
        query.executeUpdate();

        return instructorContactInfo;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor_contact_info WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_contact_info",
                InstructorContactInfo.class);
        return query.getResultList();
    }
}

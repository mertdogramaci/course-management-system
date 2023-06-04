package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.InstructorTeachesSection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class InstructorTeachesSectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public InstructorTeachesSection save(InstructorTeachesSection instructorTeachesSection) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO instructor_teaches_section (instructor_id, section_id) VALUES (?, ?)");
        query.setParameter(1, instructorTeachesSection.getInstructor().getId());
        query.setParameter(2, instructorTeachesSection.getSection().getId());
        query.executeUpdate();

        return instructorTeachesSection;
    }

    public InstructorTeachesSection findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_teaches_section WHERE id = ?",
                InstructorTeachesSection.class);
        query.setParameter(1, id);
        return (InstructorTeachesSection) query.getSingleResult();
    }

    @Transactional
    public InstructorTeachesSection update(Long id, InstructorTeachesSection instructorTeachesSection) {
        Query query = entityManager.createNativeQuery(
                "UPDATE instructor_teaches_section SET instructor_id = ?, section_id = ? WHERE ID = ?");
        query.setParameter(1, instructorTeachesSection.getInstructor().getId());
        query.setParameter(2, instructorTeachesSection.getSection().getId());
        query.setParameter(3, id);
        query.executeUpdate();

        return instructorTeachesSection;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor_teaches_section WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_teaches_section",
                InstructorTeachesSection.class);
        return query.getResultList();
    }

    public List findByInstructorId(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_teaches_section WHERE instructor_id = ?",
                InstructorTeachesSection.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
}

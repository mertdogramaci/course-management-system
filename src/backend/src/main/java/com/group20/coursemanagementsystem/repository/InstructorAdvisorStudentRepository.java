package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.InstructorAdvisorStudent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class InstructorAdvisorStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public InstructorAdvisorStudent save(InstructorAdvisorStudent instructorAdvisorStudent) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO instructor_advisor_student (instructor_id, student_id) VALUES (?, ?)");
        query.setParameter(1, instructorAdvisorStudent.getInstructor().getId());
        query.setParameter(2, instructorAdvisorStudent.getStudent().getId());
        query.executeUpdate();

        return instructorAdvisorStudent;
    }

    public InstructorAdvisorStudent findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_advisor_student WHERE id = ?",
                InstructorAdvisorStudent.class);
        query.setParameter(1, id);
        return (InstructorAdvisorStudent) query.getSingleResult();
    }

    @Transactional
    public InstructorAdvisorStudent update(Long id, InstructorAdvisorStudent instructorAdvisorStudent) {
        Query query = entityManager.createNativeQuery(
                "UPDATE instructor_advisor_student SET instructor_id = ?, student_id = ? WHERE ID = ?");
        query.setParameter(1, instructorAdvisorStudent.getInstructor().getId());
        query.setParameter(2, instructorAdvisorStudent.getStudent().getId());
        query.setParameter(3, id);
        query.executeUpdate();

        return instructorAdvisorStudent;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM instructor_advisor_student WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_advisor_student",
                InstructorAdvisorStudent.class);
        return query.getResultList();
    }

    public List findByInstructorId(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_advisor_student WHERE instructor_id = ?",
                InstructorAdvisorStudent.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    public InstructorAdvisorStudent findByStudentId(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM instructor_advisor_student WHERE student_id = ?",
                InstructorAdvisorStudent.class);
        query.setParameter(1, id);
        return (InstructorAdvisorStudent) query.getSingleResult();
    }
}

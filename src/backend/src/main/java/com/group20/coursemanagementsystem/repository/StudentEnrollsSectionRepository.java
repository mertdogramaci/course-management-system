package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.StudentEnrollsSection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentEnrollsSectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public StudentEnrollsSection save(StudentEnrollsSection studentEnrollsSection) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO student_enrolls_section " +
                        "(student_id, section_id, grade, non_attendance_count, is_approved) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, studentEnrollsSection.getStudent().getId());
        query.setParameter(2, studentEnrollsSection.getSection().getId());
        query.setParameter(3, studentEnrollsSection.getGrade());
        query.setParameter(4, studentEnrollsSection.getNonAttendanceCount());
        query.setParameter(5, studentEnrollsSection.getIsApproved());
        query.executeUpdate();

        return studentEnrollsSection;
    }

    public StudentEnrollsSection findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_enrolls_section WHERE id = ?", StudentEnrollsSection.class);
        query.setParameter(1, id);
        return (StudentEnrollsSection) query.getSingleResult();
    }

    @Transactional
    public StudentEnrollsSection update(Long id, StudentEnrollsSection studentEnrollsSection) {
        Query query = entityManager.createNativeQuery(
                "UPDATE student_enrolls_section SET student_id = ?, section_id = ?, grade = ?, " +
                        "non_attendance_count = ?, is_approved = ? WHERE ID = ?");
        query.setParameter(1, studentEnrollsSection.getStudent().getId());
        query.setParameter(2, studentEnrollsSection.getSection().getId());
        query.setParameter(3, studentEnrollsSection.getGrade());
        query.setParameter(4, studentEnrollsSection.getNonAttendanceCount());
        query.setParameter(5, studentEnrollsSection.getIsApproved());
        query.setParameter(6, id);
        query.executeUpdate();

        return studentEnrollsSection;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM student_enrolls_section WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_enrolls_section",
                StudentEnrollsSection.class);
        return query.getResultList();
    }

    public List findByStudentId(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_enrolls_section WHERE student_id = ?",
                StudentEnrollsSection.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    public List findByTerm(Long id, boolean semester, int year) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_enrolls_section ss inner join section s on (ss.section_id = s.id) " +
                        "WHERE ss.student_id = ? and s.semester = ? and s.year = ?",
                StudentEnrollsSection.class);
        query.setParameter(1, id);
        query.setParameter(2, semester);
        query.setParameter(3, year);
        return query.getResultList();
    }
}

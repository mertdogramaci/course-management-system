package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <S extends Student> S save(S student) {
        Query query = entityManager.createNativeQuery("INSERT INTO student_table (id, hacettepe_id, semester_ects) VALUES (?, ?, ?, ?, ?, ?)");
        query.setParameter(1, student.getId());
        query.setParameter(2, student.getHacettepeID());
        query.setParameter(3, student.getSemesterECTS());
        query.executeUpdate();
        return student;
    }

    public Student findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_table WHERE id = ?", Student.class);
        query.setParameter(1, id);
        return (Student) query.getSingleResult();
    }

//    @Transactional
//    public Student update(Long id, Student student) {
//        Query query = entityManager.createNativeQuery(
//                "UPDATE Student SET StudentID = ?, SchoolEnrollmentDate = ?, semesterECTS = ?, departmentID = ? " +
//                        "UPDATE Student SET student_id = ?, school_enrollment_date = ?, semester_ects = ?, department_id = ? " +
//                        "WHERE ID = ?");
//        query.setParameter(1, student.getStudentID());
//        query.setParameter(2, student.getSchoolEnrollmentDate());
//        query.setParameter(3, student.getSemesterECTS());
//        query.setParameter(4, student.getDepartment().getId());
//        query.setParameter(5, id);
//        query.executeUpdate();
//
//        return student;
//    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM student_table WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }
}

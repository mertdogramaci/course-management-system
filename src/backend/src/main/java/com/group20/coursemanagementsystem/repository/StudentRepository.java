package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List getAllStudents() {
        Query query = entityManager.createNativeQuery("SELECT * FROM Student", Student.class);
        return query.getResultList();
    }

    @Transactional
    public <S extends Student> S save(S student) {
        Query query = entityManager.createNativeQuery("INSERT INTO student (name, surname, department_id, studentid, school_enrollment_date, semesterects) VALUES (?, ?, ?, ?, ?, ?)");
        query.setParameter(1, student.getName());
        query.setParameter(2, student.getSurname());
        query.setParameter(3, student.getDepartment());
        query.setParameter(4, student.getStudentID());
        query.setParameter(5, student.getSchoolEnrollmentDate());
        query.setParameter(6, student.getSemesterECTS());
        query.executeUpdate();
        return student;
    }
}

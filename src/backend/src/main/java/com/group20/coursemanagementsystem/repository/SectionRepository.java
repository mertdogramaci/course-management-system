package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Section;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Section save(Section section) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO section (semester, year, classroomInfo, quota, courseID) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, section.getSemester());
        query.setParameter(2, section.getYear());
        query.setParameter(3, section.getClassroomInfo());
        query.setParameter(4, section.getQuota());
        query.setParameter(5, section.getCourse().getId());
        query.executeUpdate();

        return section;
    }

    public Section findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM section WHERE id = ?", Section.class);
        query.setParameter(1, id);
        return (Section) query.getSingleResult();
    }

    @Transactional
    public Section update(Long id, Section section) {
        Query query = entityManager.createNativeQuery(
                "UPDATE section SET semester = ?, year = ?, classroomInfo = ?, quota = ?, courseID = ? WHERE ID = ?");
        query.setParameter(1, section.getSemester());
        query.setParameter(2, section.getYear());
        query.setParameter(3, section.getClassroomInfo());
        query.setParameter(4, section.getQuota());
        query.setParameter(5, section.getCourse().getId());
        query.setParameter(6, id);
        query.executeUpdate();

        return section;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM section WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM section", Section.class);
        return query.getResultList();
    }
}

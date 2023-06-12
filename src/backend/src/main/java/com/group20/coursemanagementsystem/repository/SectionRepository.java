package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Section;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
                "INSERT INTO section_table (semester, year, classroom_info, quota, course_id, instructor_id) VALUES (?, ?, ?, ?, ?, ?)");
        query.setParameter(1, section.getSemester());
        query.setParameter(2, section.getYear());
        query.setParameter(3, section.getClassroomInfo());
        query.setParameter(4, section.getQuota());
        query.setParameter(5, section.getCourse().getId());
        query.setParameter(6, section.getInstructor().getId());
        query.executeUpdate();

        return section;
    }

    public Section findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM section_table WHERE id = ?", Section.class);
        query.setParameter(1, id);
        return (Section) query.getSingleResult();
    }

    @Transactional
    public Section update(Long id, Section section) {
        Query query = entityManager.createNativeQuery(
                "UPDATE section_table SET semester = ?, year = ?, classroom_info = ?, quota = ?, course_id = ?, instructor_id WHERE ID = ?");
        query.setParameter(1, section.getSemester());
        query.setParameter(2, section.getYear());
        query.setParameter(3, section.getClassroomInfo());
        query.setParameter(4, section.getQuota());
        query.setParameter(5, section.getCourse().getId());
        query.setParameter(6, section.getInstructor().getId());
        query.setParameter(7, id);
        query.executeUpdate();

        return section;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM section_table WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Section s", Section.class);
        return query.getResultList();
    }

    public List maxQuotaSections() {
        Query query = entityManager.createNativeQuery("select s.id, c.title, c.description, s.semester, s.year, s.quota " +
                "from section s inner join course c on c.id = s.course_id " +
                "where s.quota = (select max(s2.quota) from section s2)");
        return query.getResultList();
    }

    public List minQuotaSections() {
        Query query = entityManager.createNativeQuery("select s.id, c.title, c.description, s.semester, s.year, s.quota " +
                "from section s inner join course c on c.id = s.course_id " +
                "where s.quota = (select min(s2.quota) from section s2)");
        return query.getResultList();
    }
}

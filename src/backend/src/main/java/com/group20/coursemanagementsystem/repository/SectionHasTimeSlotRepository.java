package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.SectionHasTimeSlot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SectionHasTimeSlotRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SectionHasTimeSlot save(SectionHasTimeSlot sectionHasTimeSlot) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO section_has_time_slot (section_id, time_slot_id) VALUES (?, ?)");
        query.setParameter(1, sectionHasTimeSlot.getSection().getId());
        query.setParameter(2, sectionHasTimeSlot.getTimeSlot().getId());
        query.executeUpdate();

        return sectionHasTimeSlot;
    }

    public SectionHasTimeSlot findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM section_has_time_slot WHERE id = ?", SectionHasTimeSlot.class);
        query.setParameter(1, id);
        return (SectionHasTimeSlot) query.getSingleResult();
    }

    @Transactional
    public SectionHasTimeSlot update(Long id, SectionHasTimeSlot sectionHasTimeSlot) {
        Query query = entityManager.createNativeQuery(
                "UPDATE section_has_time_slot SET section_id = ?, time_slot_id = ? WHERE ID = ?");
        query.setParameter(1, sectionHasTimeSlot.getSection().getId());
        query.setParameter(2, sectionHasTimeSlot.getTimeSlot().getId());
        query.setParameter(3, id);
        query.executeUpdate();

        return sectionHasTimeSlot;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM section_has_time_slot WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM section_has_time_slot",
                SectionHasTimeSlot.class);
        return query.getResultList();
    }

    public List findByStudentId(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM section_has_time_slot st inner join student_enrolls_section ss on (st.section_id = ss.section_id)" +
                        "WHERE ss.student_id = ?",
                SectionHasTimeSlot.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
}

package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.TimeSlot;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TimeSlotRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public TimeSlot save(TimeSlot timeSlot) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO time_slot (day, start_time, end_time) VALUES (?, ?, ?)");
        query.setParameter(1, timeSlot.getDay());
        query.setParameter(2, timeSlot.getStartTime());
        query.setParameter(3, timeSlot.getEndTime());
        query.executeUpdate();

        return timeSlot;
    }

    public TimeSlot findById(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM time_slot WHERE id = ?", TimeSlot.class);
        query.setParameter(1, id);
        return (TimeSlot) query.getSingleResult();
    }

    @Transactional
    public TimeSlot update(Long id, TimeSlot timeSlot) {
        Query query = entityManager.createNativeQuery(
                "UPDATE time_slot SET day = ?, start_time = ?, end_time = ? WHERE ID = ?");
        query.setParameter(1, timeSlot.getDay());
        query.setParameter(2, timeSlot.getStartTime());
        query.setParameter(3, timeSlot.getEndTime());
        query.setParameter(4, id);
        query.executeUpdate();

        return timeSlot;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM time_slot WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT ts FROM TimeSlot ts", TimeSlot.class);
        return query.getResultList();
    }
}

package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.TimeSlot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
                "INSERT INTO time_slot (day, startTime, endTime) VALUES (?, ?, ?)");
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
    public TimeSlot update(TimeSlot timeSlot) {
        Query query = entityManager.createNativeQuery(
                "UPDATE time_slot SET day = ?, startTime = ?, endTime = ? WHERE ID = ?");
        query.setParameter(1, timeSlot.getDay());
        query.setParameter(2, timeSlot.getStartTime());
        query.setParameter(3, timeSlot.getEndTime());
        query.setParameter(4, timeSlot.getId());
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
        Query query = entityManager.createNativeQuery("SELECT * FROM time_slot", TimeSlot.class);
        return query.getResultList();
    }
}

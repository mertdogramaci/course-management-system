package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.ProcessingHistory;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProcessingHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProcessingHistory> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM ProcessingHistory p", ProcessingHistory.class);
        return query.getResultList();
    }

    @Transactional
    public <P extends ProcessingHistory> P save(P processingHistory) {
        Query query = entityManager.createNativeQuery("INSERT INTO processing_history (time_stamp, user_email, activity) VALUES (?, ?, ?)");
        query.setParameter(1, processingHistory.getTimeStamp());
        query.setParameter(2, processingHistory.getUserEmail());
        query.setParameter(3, processingHistory.getActivity());
        query.executeUpdate();
        return processingHistory;
    }
}

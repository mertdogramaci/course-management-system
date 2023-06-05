package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import com.group20.coursemanagementsystem.security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EnrolmentRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EnrolmentRequest findByHacettepeID(String hacettepeID) {
        Query query = entityManager.createQuery("SELECT e FROM EnrolmentRequest e WHERE e.hacettepeID = :hacettepeID", EnrolmentRequest.class);
        query.setParameter("hacettepeID", hacettepeID);

        if (query.getResultList().isEmpty()) { return null; }

        return (EnrolmentRequest) query.getSingleResult();
    }

    public EnrolmentRequest findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT e FROM EnrolmentRequest e WHERE e.email = :email", EnrolmentRequest.class);
        query.setParameter("email", email);

        if (query.getResultList().isEmpty()) { return null; }

        return (EnrolmentRequest) query.getSingleResult();
    }

    public boolean existsByHacettepeID(String hacettepeID) {
        return findByHacettepeID(hacettepeID) != null;
    }

    public boolean existsByEmail(String email) {
        return findByEmail(email) != null;
    }

    public EnrolmentRequest findById(Long id) {
        Query query = entityManager.createQuery("SELECT e FROM EnrolmentRequest e WHERE e.id = :id", EnrolmentRequest.class);
        query.setParameter("id", id);
        return (EnrolmentRequest) query.getSingleResult();
    }

    public boolean existsById(Long id) {
        return findById(id) != null;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM EnrolmentRequest WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List<EnrolmentRequest> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM EnrolmentRequest e", EnrolmentRequest.class);
        return query.getResultList();
    }

    @Transactional
    public <E extends EnrolmentRequest> E save(E enrolmentRequest) {
        Query query = entityManager.createNativeQuery("INSERT INTO enrolment_request (first_name, last_name, email, " +
                "password, hacettepe_id, member_type) VALUES (?, ?, ?, ?, ?, ?)");
        query.setParameter(1, enrolmentRequest.getFirstName());
        query.setParameter(2, enrolmentRequest.getLastName());
        query.setParameter(3, enrolmentRequest.getEmail());
        query.setParameter(4, enrolmentRequest.getPassword());
        query.setParameter(5, enrolmentRequest.getHacettepeID());
        query.setParameter(6, enrolmentRequest.getMemberType().ordinal());
        query.executeUpdate();

        return enrolmentRequest;
    }
}


package com.group20.coursemanagementsystem.security.repositories;

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
public class AuthorityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <A extends Authority> A save(A authority) {
        Query query = entityManager.createNativeQuery("INSERT INTO authority (authority) VALUES (?)");
        query.setParameter(1, authority.getAuthority());
        query.executeUpdate();

        return authority;
    }

    public Authority findByAuthority(String authority) {
        Query query = entityManager.createQuery("SELECT a FROM Authority a WHERE a.authority = :authority", Authority.class);
        query.setParameter("authority", authority);
        List resultList = query.getResultList();

        if (resultList.isEmpty()) { return null; }

        return (Authority) resultList.get(0);
    }

    public boolean existsByAuthority(String authority) {
        return findByAuthority(authority) != null;
    }

    public void deleteByMemberId(Long id) {
        Query query = entityManager.createQuery("SELECT a FROM Authority a WHERE a.member_id = :id", Authority.class);
        query.setParameter("id", id);
    }
}

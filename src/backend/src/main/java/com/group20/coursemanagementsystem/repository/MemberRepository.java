package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.Student;

import javax.persistence.Query;

import com.group20.coursemanagementsystem.security.domain.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Member findById(Long id) {
        Query query = entityManager.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class);
        query.setParameter("id", id);
        return (Member) query.getSingleResult();
    }

    public Member findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT m FROM Member m WHERE m.email = :email", Member.class);
        query.setParameter("email", email);
        return (Member) query.getSingleResult();
    }

    public boolean existsById(Long id) {
        if (findById(id) == null) {
            return false;
        }

        return true;
    }

    public boolean existsByEmail(String email) {
        if (findByEmail(email) == null) {
            return false;
        }

        return true;
    }

    @Transactional
    public <M extends Member> M save(M member) {
        if (member.getMemberType() == MemberType.ADMIN) {
            Query query = entityManager.createNativeQuery("INSERT INTO member_table (email, password, member_type) VALUES (?, ?, ?)");
            query.setParameter(1, member.getEmail());
            query.setParameter(2, member.getPassword());
            query.setParameter(3, member.getMemberType().ordinal());
            query.executeUpdate();

            Member savedMember = findByEmail(member.getEmail());
            for (Authority auth : member.getAuthorities()) {
                query = entityManager.createNativeQuery("INSERT INTO member_authorities (member_id, authority_id) VALUES (?, ?)");
                query.setParameter(1, savedMember.getId());
                query.setParameter(2, auth.getId());
                query.executeUpdate();
            }

            return member;
        }

        Query query = entityManager.createNativeQuery("INSERT INTO member_table (first_name, last_name, email, password, " +
                "phone_number, about, member_type, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1, member.getFirstName());
        query.setParameter(2, member.getLastName());
        query.setParameter(3, member.getEmail());
        query.setParameter(4, member.getPassword());
        query.setParameter(5, member.getPhoneNumber());
        query.setParameter(6, member.getAbout());
        query.setParameter(7, member.getMemberType().ordinal());
        query.setParameter(8, member.getDepartment().getId());
        query.executeUpdate();

        Member savedMember = findByEmail(member.getEmail());
        for (Authority auth : member.getAuthorities()) {
            query = entityManager.createNativeQuery("INSERT INTO member_authorities (member_id, authority_id) VALUES (?, ?)");
            query.setParameter(1, savedMember.getId());
            query.setParameter(2, auth.getId());
            query.executeUpdate();
        }

        if (savedMember.getMemberType() == MemberType.STUDENT) {
            Student student = (Student) member;
            query = entityManager.createNativeQuery("INSERT INTO student_table (id, hacettepe_id, semester_ects) VALUES (?, ?, ?)");
            query.setParameter(1, savedMember.getId());
            query.setParameter(2, student.getHacettepeID());
            query.setParameter(3, student.getSemesterECTS());
            query.executeUpdate();
        }

        if (savedMember.getMemberType() == MemberType.INSTRUCTOR) {
            query = entityManager.createNativeQuery("INSERT INTO instructor_table (id) VALUES (?)");
            query.setParameter(1, savedMember.getId());
            query.executeUpdate();
        }

        return member;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM member_table WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT m FROM Member m", Member.class);
        return query.getResultList();
    }

//    @Query("SELECT m FROM Member m WHERE CONCAT(LOWER(m.firstName), ' ', LOWER(m.lastName)) LIKE LOWER(CONCAT('%', ?1, '%'))")
//    List<Member> search(String keyword);
}

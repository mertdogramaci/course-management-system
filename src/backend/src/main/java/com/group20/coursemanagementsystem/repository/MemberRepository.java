package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Department;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.Student;

import javax.persistence.Query;

import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import com.group20.coursemanagementsystem.security.domain.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Member findById(Long id) {
        Query query = entityManager.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class);
        query.setParameter("id", id);
        List resultList = query.getResultList();

        if (resultList.isEmpty()) { return null; }

        return (Member) resultList.get(0);
    }

    public Member findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT m FROM Member m WHERE m.email = :email", Member.class);
        query.setParameter("email", email);
        List resultList = query.getResultList();

        if (resultList.isEmpty()) { return null; }

        return (Member) resultList.get(0);
    }

    public boolean existsById(Long id) {
        return findById(id) != null;
    }

    public boolean existsByEmail(String email) {
        return findByEmail(email) != null;
    }

    public Student findByHacettepeID(String hacettepeID) {
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.hacettepeID = :hacettepeID", Student.class);
        query.setParameter("hacettepeID", hacettepeID);
        List resultList = query.getResultList();

        if (resultList.isEmpty()) { return null; }

        return (Student) resultList.get(0);
    }

    public boolean existsByHacettepeID(String hacettepeID) {
        return findByHacettepeID(hacettepeID) != null;
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
                "phone_number, address, profile_photo, member_type, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1, member.getFirstName());
        query.setParameter(2, member.getLastName());
        query.setParameter(3, member.getEmail());
        query.setParameter(4, member.getPassword());
        query.setParameter(5, member.getPhoneNumber());
        query.setParameter(6, member.getAddress());
        query.setParameter(7, member.getProfilePhoto());
        query.setParameter(8, member.getMemberType().ordinal());
        query.setParameter(9, member.getDepartment().getId());
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
            query = entityManager.createNativeQuery("INSERT INTO student_table (id, hacettepe_id, semester_ects, school_enrollment_date) VALUES (?, ?, ?, ?)");
            query.setParameter(1, savedMember.getId());
            query.setParameter(2, student.getHacettepeID());
            query.setParameter(3, student.getSemesterECTS());
            query.setParameter(4, student.getSchoolEnrollmentDate());
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
    public <M extends Member> M saveFromEnrolmentRequest(M member) {
//        Query query = entityManager.createNativeQuery("INSERT INTO member_table (first_name, last_name, email, password, member_type, department_id) VALUES (?, ?, ?, ?, ?, ?)");
//        query.setParameter(1, member.getFirstName());
//        query.setParameter(2, member.getLastName());
//        query.setParameter(3, member.getEmail());
//        query.setParameter(4, member.getPassword());
//        query.setParameter(5, member.getMemberType().ordinal());
//        query.setParameter(6, member.getDepartment().getId());
//        query.executeUpdate();

        Query query = entityManager.createNativeQuery("INSERT INTO member_table (first_name, last_name, email, password, member_type) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, member.getFirstName());
        query.setParameter(2, member.getLastName());
        query.setParameter(3, member.getEmail());
        query.setParameter(4, member.getPassword());
        query.setParameter(5, member.getMemberType().ordinal());
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
    public <M extends Member> M update(M member) {
        Query query = entityManager.createNativeQuery("UPDATE member_table SET first_name = ?, last_name = ?, email = ?, password = ?, " +
                "phone_number = ?, address = ?, profile_photo = ?, member_type = ?, department_id = ? WHERE id = ?");
        query.setParameter(1, member.getFirstName());
        query.setParameter(2, member.getLastName());
        query.setParameter(3, member.getEmail());
        query.setParameter(4, member.getPassword());
        query.setParameter(5, member.getPhoneNumber());
        query.setParameter(6, member.getAddress());
        query.setParameter(7, member.getProfilePhoto());
        query.setParameter(8, member.getMemberType().ordinal());
        query.setParameter(9, member.getDepartment().getId());
        query.setParameter(10, member.getId());
        query.executeUpdate();

        if (member.getMemberType() == MemberType.STUDENT) {
            Student student = (Student) member;
            query = entityManager.createNativeQuery("UPDATE student_table SET hacettepe_id = ?, semester_ects = ? WHERE id = ?");
            query.setParameter(1, student.getHacettepeID());
            query.setParameter(2, student.getSemesterECTS());
            query.setParameter(3, member.getId());
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

    public Department getDepartmentOfMember(Long memberId) {
        Query query = entityManager.createNativeQuery(
                "SELECT d.* FROM member_table m inner join department d on (m.department_id = d.id) WHERE id = ?",
                Department.class);
        query.setParameter(1, memberId);
        query.executeUpdate();

        return (Department) query.getResultList().get(0);
    }

    public int getEnrollmentDate(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT s.school_enrollment_date FROM member_table m inner join student_table s on (m.id = s.id) WHERE m.id = ?");
        query.setParameter(1, id);

        return Integer.parseInt(query.getResultList().get(0).toString().split("-")[0]);
    }

//    @Query("SELECT m FROM Member m WHERE CONCAT(LOWER(m.firstName), ' ', LOWER(m.lastName)) LIKE LOWER(CONCAT('%', ?1, '%'))")
//    List<Member> search(String keyword);
}

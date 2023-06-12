package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.model.Section;
import com.group20.coursemanagementsystem.model.StudentEnrollsSection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentEnrollsSectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public StudentEnrollsSection save(StudentEnrollsSection studentEnrollsSection) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO student_enrolls_section " +
                        "(student_id, section_id, grade, non_attendance_count, is_approved) VALUES (?, ?, ?, ?, ?)");
        query.setParameter(1, studentEnrollsSection.getStudent().getId());
        query.setParameter(2, studentEnrollsSection.getSection().getId());
        query.setParameter(3, studentEnrollsSection.getGrade());
        query.setParameter(4, studentEnrollsSection.getNonAttendanceCount());
        query.setParameter(5, studentEnrollsSection.getIsApproved());
        query.executeUpdate();

        return studentEnrollsSection;
    }

    public StudentEnrollsSection findById(Long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_enrolls_section WHERE id = ?", StudentEnrollsSection.class);
        query.setParameter(1, id);
        return (StudentEnrollsSection) query.getSingleResult();
    }

    @Transactional
    public StudentEnrollsSection update(Long id, StudentEnrollsSection studentEnrollsSection) {
        Query query = entityManager.createNativeQuery(
                "UPDATE student_enrolls_section SET student_id = ?, section_id = ?, grade = ?, " +
                        "non_attendance_count = ?, is_approved = ? WHERE ID = ?");
        query.setParameter(1, studentEnrollsSection.getStudent().getId());
        query.setParameter(2, studentEnrollsSection.getSection().getId());
        query.setParameter(3, studentEnrollsSection.getGrade());
        query.setParameter(4, studentEnrollsSection.getNonAttendanceCount());
        query.setParameter(5, studentEnrollsSection.getIsApproved());
        query.setParameter(6, id);
        query.executeUpdate();

        return studentEnrollsSection;
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM student_enrolls_section WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public List findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_enrolls_section",
                StudentEnrollsSection.class);
        return query.getResultList();
    }

    public List findByStudentId(Long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM student_enrolls_section WHERE student_id = ?",
                StudentEnrollsSection.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    public List findByTerm(Long id, boolean semester, int year) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM student_enrolls_section ss inner join section_table s on (ss.section_id = s.id) " +
                        "WHERE ss.student_id = ? and s.semester = ? and s.year = ?",
                StudentEnrollsSection.class);
        query.setParameter(1, id);
        query.setParameter(2, semester);
        query.setParameter(3, year);
        return query.getResultList();
    }


//    SELECT DISTINCT s.* FROM section_table s " +
//            "INNER JOIN course crs ON s.course_id = crs.id " +
//            "WHERE s.semester = ? AND s.year = ? " +
//            "AND crs.department_id = (SELECT department_id FROM member_table mt WHERE mt.id = ?)" +
//            "AND NOT EXISTS(SELECT * FROM student_enrolls_section ses WHERE ses.section_id = s.id AND ses.student_id = ?)"
    public List findSectionsToEnroll(Long student_id, boolean semester, int year) {
        Query query = entityManager.createNativeQuery(
                "SELECT DISTINCT s.* FROM section_table s " +
                        "JOIN course crs ON s.course_id = crs.id " +
                        "LEFT JOIN student_enrolls_section ses ON ses.section_id = s.id AND ses.student_id = ? " +
                        "WHERE s.semester = ? AND s.year = ? " +
                        "AND crs.department_id = (SELECT department_id FROM member_table mt WHERE mt.id = ?)" +
                        "AND ses.section_id IS NULL;",
                Section.class);
        query.setParameter(1, student_id);
        query.setParameter(2, semester);
        query.setParameter(3, year);
        query.setParameter(4, student_id);
        return query.getResultList();
    }

    public Object sectionStatistics() {
        Query query = entityManager.createNativeQuery(
                "select ss_table.count, c.title, c.description, s.semester, s.year, d.name\n" +
                        "from (select count(*), ss.section_id\n" +
                        "from student_enrolls_section ss\n" +
                        "group by ss.section_id) as ss_table, section s inner join course c on c.id = s.course_id\n" +
                        "inner join department d on d.id = c.department_id\n" +
                        "where ss_table.section_id = s.id\n" +
                        "order by ss_table.count desc limit 1");
        return query.getResultList().get(0);
    }

    public Object sectionAverageStatistics() {
        Query query = entityManager.createNativeQuery(
                "select avg_grade.avg, c.title, c.description\n" +
                        "from (select avg(ss.grade), c.id\n" +
                        "from student_enrolls_section ss inner join section s on (s.id = ss.section_id)\n" +
                        "inner join course c on (c.id = s.course_id)\n" +
                        "group by ss.section_id, c.id \n" +
                        "having c.title like 'BBM471') as avg_grade inner join course c on c.id = avg_grade.id");
        return query.getResultList().get(0);
    }
}

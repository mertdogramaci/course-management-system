package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_enrolls_section")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentEnrollsSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Member student;

    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "non_attendance_count")
    private Integer nonAttendanceCount;

    @Column(name = "is_approved")
    private Boolean isApproved = false;

    public StudentEnrollsSection(Member student, Section section, int grade, int nonAttendanceCount,
                                 boolean isApproved) {
        this.student = student;
        this.section = section;
        this.grade = grade;
        this.nonAttendanceCount = nonAttendanceCount;
        this.isApproved = isApproved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEnrollsSection that = (StudentEnrollsSection) o;

        if (!id.equals(that.id)) return false;
        if (!student.equals(that.student)) return false;
        if (!section.equals(that.section)) return false;
        if (!Objects.equals(grade, that.grade)) return false;
        if (!Objects.equals(nonAttendanceCount, that.nonAttendanceCount))
            return false;
        return isApproved.equals(that.isApproved);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + section.hashCode();
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (nonAttendanceCount != null ? nonAttendanceCount.hashCode() : 0);
        result = 31 * result + isApproved.hashCode();
        return result;
    }
}

package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "instructor_advisor_student")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class InstructorAdvisorStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Member instructor;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Member student;

    public InstructorAdvisorStudent(Member instructor, Member student) {
        this.instructor = instructor;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorAdvisorStudent that = (InstructorAdvisorStudent) o;

        if (!id.equals(that.id)) return false;
        if (!instructor.equals(that.instructor)) return false;
        return student.equals(that.student);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + instructor.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }
}

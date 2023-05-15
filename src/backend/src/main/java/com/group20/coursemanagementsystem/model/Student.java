package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student{

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "studentID")
    private Long studentID;

    @Column(name = "schoolEnrollmentDate")
    private Date schoolEnrollmentDate;

    @Column(name = "semesterECTS")
    private Integer semesterECTS = 0;

    @OneToOne
    private StudentContactInfo studentContactInfo;

    @OneToOne
    private StudentLoginCredentials studentLoginCredentials;

    @OneToMany
    private List<Submission> submissions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;
        if (!name.equals(student.name)) return false;
        if (!surname.equals(student.surname)) return false;
        if (!department.equals(student.department)) return false;
        if (!studentID.equals(student.studentID)) return false;
        if (!schoolEnrollmentDate.equals(student.schoolEnrollmentDate)) return false;
        return Objects.equals(semesterECTS, student.semesterECTS);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + studentID.hashCode();
        result = 31 * result + schoolEnrollmentDate.hashCode();
        result = 31 * result + (semesterECTS != null ? semesterECTS.hashCode() : 0);
        return result;
    }
}

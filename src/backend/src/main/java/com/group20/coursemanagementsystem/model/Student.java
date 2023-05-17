package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "student_id", unique = true)
    private Long studentID;

    @Column(name = "school_enrollment_date")
    private LocalDate schoolEnrollmentDate;

    @Column(name = "semester_ects")
    private Integer semesterECTS = 0;

    public Student(String name, String surname, Department department, Long studentID, LocalDate schoolEnrollmentDate,
                   Integer semesterECTS) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.studentID = studentID;
        this.schoolEnrollmentDate = schoolEnrollmentDate;
        this.semesterECTS = semesterECTS;
    }

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

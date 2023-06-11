package com.group20.coursemanagementsystem.model;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.security.domain.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Inheritance
@Entity
@Table(name = "student_table")
@DiscriminatorValue(value = "STUDENT")
@NoArgsConstructor
public class Student extends Member {

    @Column(name = "hacettepe_id", unique = true)
    protected String hacettepeID;

    @Column(name = "semester_ects")
    protected int semesterECTS;

    @Column(name = "school_enrollment_date")
    private LocalDate schoolEnrollmentDate;

    public Student(String firstName, String lastName, String email,
                   String password, MemberType memberType, Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Student(String firstName, String lastName, String email, String password, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
    }

    public Student(String firstName, String lastName, String email, String password, String profilePhoto, String phoneNumber,
                   String address, MemberType memberType, Set<Authority> authorities, Department department,
                   String hacettepeID, int semesterECTS, LocalDate schoolEnrollmentDate) {
        super(firstName, lastName, email, password, phoneNumber, address, profilePhoto, memberType, authorities, department);
        this.hacettepeID = hacettepeID;
        this.semesterECTS = semesterECTS;
        this.schoolEnrollmentDate = schoolEnrollmentDate;
    }

    public Student(String firstName, String lastName, String email, String password, String phoneNumber, String address,
                   MemberType memberType, Set<Authority> authorities, Department department, String hacettepeID,
                   int semesterECTS, LocalDate schoolEnrollmentDate) {
        super(firstName, lastName, email, password, phoneNumber, address, memberType, authorities, department);
        this.hacettepeID = hacettepeID;
        this.semesterECTS = semesterECTS;
        this.schoolEnrollmentDate = schoolEnrollmentDate;
    }

    public void updateMemberFields(Member m) {
        this.firstName = m.getFirstName();
        this.lastName = m.getLastName();
        this.email = m.getEmail();
        this.password = m.getPassword();
        this.phoneNumber = m.getPhoneNumber();
        this.address = m.getAddress();
        this.memberType = m.getMemberType();
        this.authorities = m.getAuthorities();
        updateDepartment(m.getDepartment());
    }
}

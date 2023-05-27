package com.group20.coursemanagementsystem.model;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.security.domain.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Getter
@Inheritance
@Entity
@Table(name = "student_table")
@DiscriminatorValue(value = "STUDENT")
@NoArgsConstructor
public class Student extends Member {

    public Student(String firstName, String lastName, String hacettepeId, String email,
                   String password, MemberType memberType  , Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Student(String firstName, String lastName, String hacettepeId, String email, String password, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
    }

    public Student(String firstName, String lastName, String hacettepeId, String email, String password, String profilePhoto, String phoneNumber, String linkedInURL, String githubURL, String about, String experience, String interests, MemberType memberType, Set<Authority> authorities) {
        super(firstName, lastName, hacettepeId, email, password, profilePhoto, phoneNumber, linkedInURL, githubURL, about, experience, interests, memberType, authorities);
    }
}

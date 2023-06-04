package com.group20.coursemanagementsystem.model;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.security.domain.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Inheritance
@Entity
@Table(name = "instructor_table")
@DiscriminatorValue(value = "INSTRUCTOR")
@NoArgsConstructor
public class Instructor extends Member {

    public Instructor(String firstName, String lastName, String email, String password, MemberType memberType, Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Instructor(String firstName, String lastName, String email, String password, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
    }

    public Instructor(String firstName, String lastName, String email, String password, String phoneNumber,
                      String profilePhoto, String about, MemberType memberType, Set<Authority> authorities, Department department) {
        super(firstName, lastName, email, password, phoneNumber, about, profilePhoto, memberType, authorities, department);
    }

    public Instructor(String firstName, String lastName, String email, String password, String phoneNumber,
                      String about, MemberType memberType, Set<Authority> authorities, Department department) {
        super(firstName, lastName, email, password, phoneNumber, about, memberType, authorities, department);
    }
}

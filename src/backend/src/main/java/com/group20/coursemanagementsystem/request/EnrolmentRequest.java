package com.group20.coursemanagementsystem.request;

import com.group20.coursemanagementsystem.model.Academician;
import com.group20.coursemanagementsystem.model.BaseEntity;
import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@RequiredArgsConstructor
@Getter
@ToString
@Entity
public class EnrolmentRequest extends BaseEntity {

    @NotEmpty(message = "First name cannot be empty!")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty!")
    private String lastName;

    private String hacettepeId;

    // TODO check email if it ends with @hacettepe.edu.tr etc
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotEmpty(message = "Password cannot be empty!")
    @Setter
    private String password;

    private MemberType memberType;

    public EnrolmentRequest(String firstName, String lastName, String hacettepeId, String email, String password, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
    }

    //Map function to Member
    public Member toMember() {
        return new Member(firstName, lastName, hacettepeId, email, memberType);
    }

    //Map function to Student
    public Student toStudent() {
        return new Student(firstName, lastName, hacettepeId, email, password, memberType);
    }

    //Map function to Academician
    public Academician toAcademician() {
        return new Academician(firstName, lastName, hacettepeId, email, password, memberType);
    }
}


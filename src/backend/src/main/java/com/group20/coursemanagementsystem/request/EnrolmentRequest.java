package com.group20.coursemanagementsystem.request;

import com.group20.coursemanagementsystem.model.Instructor;
import com.group20.coursemanagementsystem.model.BaseEntity;
import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
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

    @Column(name = "hacettepe_id")
    private String hacettepeID;

    // TODO check email if it ends with @hacettepe.edu.tr etc
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotEmpty(message = "Password cannot be empty!")
    @Setter
    private String password;

    private MemberType memberType;

    public EnrolmentRequest(String firstName, String lastName, String hacettepeID, String email, String password, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeID = hacettepeID;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
    }

    //Map function to Member
    public Member toMember() {
        return new Member(firstName, lastName, email, memberType);
    }

    public Student toStudent() {
        return new Student(firstName, lastName, email, password, memberType);
    }

    public Instructor toInstructor() {
        return new Instructor(firstName, lastName, hacettepeID, email, memberType);
    }
}


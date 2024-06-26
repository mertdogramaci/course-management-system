package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Student;
import lombok.Getter;

@Getter
public class StudentResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final MemberType memberType;
    private final String phoneNumber;
    private final String address;
    private final String hacettepeID;
    private final int semesterECTS;

    public StudentResponse(final Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.memberType = student.getMemberType();
        this.phoneNumber = student.getPhoneNumber();
        this.address = student.getAddress();
        this.hacettepeID = student.getHacettepeID();
        this.semesterECTS = student.getSemesterECTS();
    }
}

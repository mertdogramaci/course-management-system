package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import lombok.Getter;

@Getter
public class EnrolmentQueryResponse {

    private final Long id;
    private String firstName;
    private String lastName;
    private String hacettepeId;
    private String email;
    private MemberType memberType;

    public EnrolmentQueryResponse(final EnrolmentRequest enrolmentRequest) {
        this.id = enrolmentRequest.getId();
        this.firstName = enrolmentRequest.getFirstName();
        this.lastName = enrolmentRequest.getLastName();
        this.hacettepeId = enrolmentRequest.getHacettepeID();
        this.email = enrolmentRequest.getEmail();
        this.memberType = enrolmentRequest.getMemberType();
    }
}

package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import lombok.Getter;

import java.util.Set;

// Get members all fields
@Getter
public class MemberResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final MemberType memberType;
    private final String phoneNumber;
    private final String about;

    public MemberResponse(final Member member) {
        this.id = member.getId();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.email = member.getEmail();
        this.memberType = member.getMemberType();
        this.phoneNumber = member.getPhoneNumber();
        this.about = member.getAbout();
    }
}

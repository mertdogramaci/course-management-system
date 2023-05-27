package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.model.Member;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class MemberQueryResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String hacettepeId;
    private final String email;
    private final MemberType memberType;
    private final String profilePhoto;
    private List<LocalDate> joinDates;

    public MemberQueryResponse(final Member member) {
        this.id = member.getId();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.hacettepeId = member.getHacettepeId();
        this.email = member.getEmail();
        this.memberType = member.getMemberType();
        this.profilePhoto = member.getProfilePhoto();
        this.joinDates = member.getJoinDates();
    }
}

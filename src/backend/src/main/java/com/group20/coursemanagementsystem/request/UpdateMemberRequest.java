package com.group20.coursemanagementsystem.request;

import com.group20.coursemanagementsystem.model.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UpdateMemberRequest implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String about;

    //Map function to Member
    public Member toMember() {
        return new Member(firstName, lastName, email, phoneNumber, about);
    }
}


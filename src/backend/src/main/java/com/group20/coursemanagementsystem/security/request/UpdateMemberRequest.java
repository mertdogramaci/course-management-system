package com.group20.coursemanagementsystem.security.request;

import com.group20.coursemanagementsystem.model.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UpdateMemberRequest implements Serializable {

    private String firstName;

    private String lastName;

    private String hacettepeId;

    private String email;

    private MultipartFile profilePhoto;

    private String phoneNumber;

    private String linkedInURL;

    private String githubURL;

    private String about;

    private String experience;

    private String interests;

    //Map function to Member
    public Member toMember(String profilePhotoPath) {
        return new Member(firstName, lastName, hacettepeId, email, profilePhotoPath, phoneNumber,
                linkedInURL, githubURL, about, experience, interests);
    }
}

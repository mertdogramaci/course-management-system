package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.response.MemberQueryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginQueryResponse {

    String accessToken;
    MemberQueryResponse user;
}

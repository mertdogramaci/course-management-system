package com.group20.coursemanagementsystem.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor
public class LoginRequest {

    @NotEmpty
    private final String email;

    @NotEmpty
    private final String password;
}
